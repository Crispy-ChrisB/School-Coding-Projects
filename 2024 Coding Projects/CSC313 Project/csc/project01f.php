<!DOCTYPE html>
<?php
	// Start session and connect to Database
	session_start();
	$dbh = new PDO("mysql:host=localhost;dbname=chinook",
					"csc313","dbadmin");
?>
<html>
	<head>
		<title>Project - 01f :: Chinook Database</title>
	</head>
	<body style="background-color:#fcb3e1;">
		<b>Shopping For ~  
			<?php
				// shopping for?
				print $_SESSION["cust_name"] . "</b>";

				// Go back to albums
				print "<p><a href='project01b.php'><i>Back to Albums</i></a></p>";

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
				
				// List Owned Tracks
					print "<p><b>Owned Tracks: </b></p>";
					while($data = $res->fetch()){
						print "<p>" . $data["track_name"] . "</p>";
					}
			?>
	</body>
</html>