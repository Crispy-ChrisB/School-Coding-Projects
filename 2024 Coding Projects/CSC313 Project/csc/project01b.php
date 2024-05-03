<!DOCTYPE html>
<?php
	// Start Session and Connect to Database
	session_start();
	$dbh = new PDO("mysql:host=localhost;dbname=chinook",
					"csc313","dbadmin");
	
	if(isset($_POST["albumSelect"])){
		// Save selected album
		$_SESSION["albumSelect"] = $_POST["albumSelect"];
		
		// Go to page 3
		header("Location:project01c.php");
		exit();
	}
?>
<html>
	<head>
		<title>Project - 01b :: Chinook Database</title>
	</head>
	<body style="background-color:#fcb3e1;">
		<b>Shopping For ~  
			<?php
				// shopping for?
				print $_SESSION["cust_name"] . "</b>";
				// See owned tracks?
				print "<p><a href='project01f.php'><i>Owned Tracks</i></a></p>";
			?>
		<form method="POST">
			<div class="album-container">
				<?php
					// Get each album and list it
					$res = $dbh->query("SELECT album_title, album_art_url FROM albums");
					while($data = $res->fetch()){
						print "<div class='album'>";
						print "<button type='submit' name='albumSelect' value='" . $data["album_title"] . "'>
							<img src='../img/Chinook_Project/" . $data["album_art_url"] . "' height=130></button>";
						print "<p>" . $data["album_title"] . "</p>";
						print "</div>";
					}
					$res->closeCursor();
				?>
			</div>
		</form>
	</body>
</html>
<style>
	.album-container {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
	}

	.album{
		width: 18%;
		margin-bottom: 20px;
		text-align: center;
	}

	button{
		background-color: transparent;
		border: none;
	}
</style>