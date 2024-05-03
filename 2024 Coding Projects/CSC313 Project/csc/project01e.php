<!DOCTYPE html>
<?php
	// Start session
	session_start();
?>
<html>
	<head>
	<title>Project - 01e :: Chinook Database</title>
	</head>
	<body style="background-color:#fcb3e1;">
	<b>Shopping For ~ 
		<?php
			// shopping for
			print $_SESSION["cust_name"] . "</b>";
			
			// Get rid of session
			session_destroy();
			// Check if order was successful
			if($_SESSION["success"] == 1){
				print "<p><i>Your order has been placed!</i></p>";
				print "<p><a href='project01a.php'>Return To User Selection</a></p>";
			} else {
				print "There was an issue with placing your order! ";
				print "<a href='project01a.php'>Please logout and try again.</a>";
			}
		?>
	</body>
</html>