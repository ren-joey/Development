<?php session_start(); ?>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>

<?php
	if(isset($_SESSION['counter'])){
		$_SESSION['counter']++;
	} else {
		$_SESSION['counter']=1;
	}
	
	echo 'Your session id is : ' . session_id() . '<br>';
	echo 'You have visit this page for ' . $_SESSION['counter'] . ' times.'
	
	?>

</body>
</html>
