<!DOCTYPE html>
<?php
	// Start session and connect to Database
	session_start();
	$dbh = new PDO("mysql:host=localhost;dbname=chinook",
					"csc313","dbadmin");
?>
<html>
	<head>
	<title>Project - 01d :: Chinook Database</title>
	</head>
	<body style="background-color:#fcb3e1;">
	<b>Shopping For ~ 
		<?php
			// shopping for
			print $_SESSION["cust_name"] . "</b>";
			
			// Get customer_id
			list($firstName, $lastName) = explode(" ", $_SESSION["cust_name"]);
			$res = $dbh->prepare("SELECT customer_id FROM customers WHERE first_name=? AND
				last_name=?");
			$res->execute(array($firstName,$lastName));
			$cust_id = $res->fetchColumn();
			$res->closeCursor();
			
			// Get the tracks that the customer already owns
			$res = $dbh->prepare("SELECT DISTINCT tracks.track_name FROM customers INNER JOIN
				invoices ON customers.customer_id=invoices.customer_id INNER JOIN 
				invoice_lines ON invoices.invoice_id=invoice_lines.invoice_id INNER JOIN
				tracks ON invoice_lines.track_id=tracks.track_id 
				WHERE customers.customer_id=?");
			$res->execute([$cust_id]);
			
			/* List Owned Tracks
				print "<p><b>Owned Tracks: </b></p>";
				while($data = $res->fetch()){
					print "<p>" . $data["track_name"] . "</p>";
				}
			*/
			
			// Check if tracks are already owned
			while($data = $res->fetch()){
				if(isset($_SESSION["trackSelect"])){
					foreach($_SESSION["trackSelect"] as $key => $track){
						// Owned track = remove from cart
						if($track == $data["track_name"]){
							print "<p>We have removed " . $track . 
								" from the cart since you already own it.</p>";
							unset($_SESSION["trackSelect"][$key]);
						}
					}
				}
			}
			$res->closeCursor();
			
			if(!empty($_SESSION["trackSelect"])){
				// Review and place order w/ total cost
				// Get album id to distinct between tracks with the same name in dif albums
				$res = $dbh->prepare("SELECT album_id FROM albums WHERE album_title=?");
				$res->execute(array($_SESSION["albumSelect"]));
				$albumID = $res->fetch();
				$res->closeCursor();

				// Get info of each track and add together price for a total cost
				$totalCost = 0.0;
				$unitPrices = array();
				$res = $dbh->prepare("SELECT track_id, unit_price FROM tracks WHERE track_name=:track_name AND album_id=:album_id");
				
				foreach($_SESSION["trackSelect"] as $track){
					$res->bindParam(':track_name', $track);
					$res->bindParam(':album_id', $albumID[0]);
					$res->execute();
					$trackInfo = $res->fetch();

					// Get track_id and unit_prices
					$trackID = $trackInfo["track_id"];
					$unitPrice = $trackInfo["unit_price"];

					// Store track_id and unit_price for later use in invoice_lines
					$unitPrices[$track] = array(
						"track_id" => $trackID,
						"unit_price" => $unitPrice
					);

					$totalCost += $unitPrice;
				}
				$res->closeCursor();
				// Display formatted total cost
				print "<p>Total Cost: $" . number_format((float)$totalCost, 2, '.', '') . "</p>";

				// HTML to submit order
				print "<form method='POST'>";
				print "<p><input type='submit' value='Confirm Order' name='sub' /></p>";
				print "</form>";

			} else {
				// Cart empty. Return
				print "<p>Your cart is empty!</p>";
				print "<p><a href='project01b.php'>Return To Albums</a></p>";
			}

			// Functions to submit the order
			if(array_key_exists('sub', $_POST)){
				submitOrder($totalCost, $unitPrices);
			}

			function submitOrder($totalCost, $unitPrices){
				// Reconnect to database; needed for some reason. Breaks without
				$dbh = new PDO("mysql:host=localhost;dbname=chinook","csc313","dbadmin");
				// Get customer's info
				$customerName = explode(" ", $_SESSION["cust_name"]);

				$res = $dbh->prepare("SELECT customer_id, address, city, state, country, postal_code
					FROM customers WHERE first_name=? AND last_name=?");
				$res->execute(array(
					$customerName[0],
					$customerName[1]
				));
				$customerData = $res->fetch();
				$res->closeCursor();

				// Get last invoice_id since it isn't auto-incrementing for some reason
				$res = $dbh->query("SELECT MAX(invoice_id) FROM invoices");
				$invoiceIDArr = $res->fetch();
				$invoiceID = $invoiceIDArr[0] + 1;
				$res->closeCursor();

				// Insert into database
				$stmt = $dbh->prepare("INSERT INTO invoices (invoice_id, customer_id, invoice_date, billing_address, 
					billing_city, billing_state, billing_country, billing_postal_code, total) VALUES 
					(?,?,?,?,?,?,?,?,?)");
				if($stmt->execute(array(
					$invoiceID,
					$customerData["customer_id"],
					date("Y-m-d"),
					$customerData["address"],
					$customerData["city"],
					$customerData["state"],
					$customerData["country"],
					$customerData["postal_code"],
					$totalCost
				))){
					$stmt->closeCursor();
					// Update invoice_lines table
					// Get next invoice_line_id because it also isn't auto incrementing for some reason
					$res = $dbh->query("SELECT MAX(invoice_line_id) FROM invoice_lines");
					$invoiceLineIDArr = $res->fetch();
					$invoiceLineID = $invoiceLineIDArr[0] + 1;
					$res->closeCursor();

					$stmt = $dbh->prepare("INSERT INTO invoice_lines VALUES (?, ?, ?, ?, 1)");
					

					foreach($unitPrices as $trackInfo){
						$stmt->execute(array(
							$invoiceLineID,
							$invoiceID,
							$trackInfo["track_id"],
							$trackInfo["unit_price"],
						));
						$invoiceLineID++;
					}
					$stmt->closeCursor();

					// Go to final page
					$_SESSION["success"] = 1;
					header("Location:project01e.php");
					exit();
				} else {
					$stmt->closeCursor();
					
					// Go to final page
					$_SESSION["success"] = 0;
					header("Location:project01e.php");
					exit();
				}
			}


		?>
	</body>
</html>