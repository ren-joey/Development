<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	if((isset($_GET['username']))&&(isset($_GET['password']))){
		echo '您的帳號是：' . $_GET['username'] . '<br>';
		echo '您的密碼是：' . $_GET['password'] ;
	}
	?>
<form action="test.php" method="get">
	帳號：<input type="text" name="username">
	密碼：<input type="password" name="password">
	<input type="submit" value="送出">
</form>
</body>
</html>
