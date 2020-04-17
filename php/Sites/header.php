<?php ob_start(); ?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php 
	header('Refresh : 1');
	
	session_start();
	
	if(!isset($_SESSION['remain'])){
		$_SESSION['remain'] = 10;
	}
	
	echo 'This page will switch to kingsinfo official website in '.$_SESSION['remain'].' seconds';
		
	if($_SESSION['remain'] < 1){
		header('Location: http://www.kingsinfo.com.tw');
	} else {
		$_SESSION['remain']--;
	}
?>
</body>
</html>
<?php ob_end_flush(); ?>