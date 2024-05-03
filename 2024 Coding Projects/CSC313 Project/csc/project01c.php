<!DOCTYPE html>
<?php
	// Start session and connect to Database
	session_start();
	$dbh = new PDO("mysql:host=localhost;dbname=chinook",
					"csc313","dbadmin");
?>
<html>
	<head>
		<title>Project - 01c :: Chinook Database</title>
	</head>
	<body style="background-color:#fcb3e1;">
		<b>Shopping For ~ 
		<?php
			// shopping for and what Album
			print $_SESSION["cust_name"] . "</b>";
			print "<p><b>Album ~ " . $_SESSION["albumSelect"] . "</b></p>";
			
			// Show album cover
			$res = $dbh->prepare("SELECT album_art_url FROM albums WHERE album_title=?");
			$res->execute(array($_SESSION["albumSelect"]));
			$data = $res->fetch();
			$res->closeCursor();
			print "<img src='../img/Chinook_Project/" . $data["album_art_url"] . 
					"' height:64 width:64>";
		?>
		<form method="POST">
			<ol id="trackSelect" name="trackSelect">
				<?php
					$res = $dbh->prepare("SELECT tracks.track_name FROM tracks INNER JOIN albums 
						ON tracks.album_id=albums.album_id WHERE albums.album_title=?");
					$res->execute(array($_SESSION["albumSelect"]));
					while($data = $res->fetch()){
						$trackName = htmlspecialchars($data["track_name"]);
						print "<li><input type='checkbox' name='trackSelect[]' value='" .
							$trackName . "'>" . $trackName . "</li>";
					}
					$res->closeCursor();
				?>
			</ol>
			<p><input type="submit" name="submit" value="Checkout"></p>
		</form>
			<?php
				if(isset($_POST["submit"])){
					// Initialize session array if not set
					if(!isset($_SESSION["trackSelect"])){
						$_SESSION["trackSelect"] = array();
					}
					
					// Check if any checkboxes are checked
					if(isset($_POST["trackSelect"])){
						// Loop through checked checkboxes and store in session
						foreach($_POST["trackSelect"] as $track){
							$_SESSION["trackSelect"][] = $track;
						}
					}
					
					print "<p>";
					print_r($_SESSION["trackSelect"]);
					print "</p>";
					// go to page 4
					header("Location:project01d.php");
					exit();
				}
			?>
	</body>
</html>