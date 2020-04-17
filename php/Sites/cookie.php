<?php ob_start(); ?>
<!doctype html>
<?php
	$cu = 'cookie_username';
	$cp = 'cookie_password';
	$cph = 'cookie_phone';
	$n = 'name';
	$v = 'value';
	$cookie_set = array(
	'cookie_username'=>array(
		'name'=>'username',
		'value'=>'joey'
	),
	'cookie_password'=>array(
		'name'=>'password',
		'value'=>'1234'
	),
	'cookie_phone'=>array(
		'name'=>'phone',
		'value'=>'0937472767'
	)
	);
	
	setcookie($cookie_set[$cu][$n],$cookie_set[$cu][$v],time() + (86400*30),'/');
	setcookie($cookie_set[$cp][$n],$cookie_set[$cp][$v],time() + (86400*30),'/');
	setcookie($cookie_set[$cph][$n],$cookie_set[$cph][$v],time() + (86400*30),'/');
?>

<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	
	if(!isset($_COOKIE['username'])){
		echo 'cookie is not set';
	}else{
		echo 'username:' . $_COOKIE['username'] . '<br>';
		echo 'password:' . $_COOKIE['password'] . '<br>';
		echo 'phone:' . $_COOKIE['phone'] . '<br>';
	}
	?>
</body>
</html>
<?php ob_end_flush();?>