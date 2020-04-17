<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<div style="color: green;">
<?php 
	echo'this is php profile <br>';
	$a = 1 ; $b = 2 ; $c = 3;
	echo $a.$b.$c;
	?>
</div>
<?php
	$name = '01';
	if($name == '01')
	{
		echo '<div style="color: red;">123</div>';
	}	else	{	
		echo '<div style="color: blue;">321</div>';
	}
	?>
</body>
</html>