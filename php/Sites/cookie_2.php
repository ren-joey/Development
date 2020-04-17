<?php ob_start(); ?>
<!doctype html>
<?php
	setcookie('user_info[username]','joey',time() + (86400*30),'/');
	setcookie('user_info[password]','1234',time() + (86400*30),'/');
	setcookie('user_info[phone]','0937472767',time() + (86400*30),'/');
?>

<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	if(!isset($_COOKIE['user_info'])){
		echo 'cookie is not set';
	}else{
		foreach ($_COOKIE['user_info'] as $name => $value){
			echo $name . ':' . $value . '<br>';
		}
	}
	?>
</body>
</html>
<?php ob_end_flush();?>