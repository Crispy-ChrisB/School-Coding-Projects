<!DOCTYPE html>
<html>
	<head>
		<title>Project - 01a :: Chinook Database</title>
	</head>

	<body style="background-color:#fcb3e1;">
		<form method="POST">
			<p><label for="cust_name">Your Name: 
				<select name="cust_name" id="cust_name" size="1">
					<?php
						// create link to Database
						$dbh = new PDO("mysql:host=localhost;dbname=chinook",
							"csc313","dbadmin");
							
						// get and create a drop-down list of customers
						$res = $dbh->query("SELECT first_name, last_name FROM customers");
						while($data = $res->fetch()){
							print "<option>" . $data["first_name"] . " " . $data["last_name"] . "</option>";
						}
						$res->closeCursor();
					?>
				</select>
			<p><input type="submit" value="  Shop  "></p>
		</form>
		<?php
			if(isset($_POST["cust_name"])){
				session_start();
				
				// save customer name
				$_SESSION["cust_name"] = $_POST["cust_name"];
				
				// jump to page 2
				header("Location:project01b.php");
				exit();
			}

		?>
	</body>
</html>