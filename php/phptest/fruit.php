<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	if(isset($_GET['submit1'])){
		$fruit="";
		foreach($_GET['fruit'] as $value)
		{
			switch($value){
					case'apple':
					$fruit .= 'apple, ';break;
					case'orange':
					$fruit .= 'orange, ';break;
					case'strawberry':
					$fruit .= 'strawberry';break;
			}
		}
		echo 'fruits that you liked are:' . $fruit;
	}
	?>
<form action="fruit.php" method="get">
	Please selected fruits you liked:<br>
	<select name="fruit[]" size="3" multiple="multiple">
		<option value="apple" selected="selected">apple</option>
		<option value="orange">orange</option>
		<option value="strawberry">strawberry</option>
	</select>
	<input type="submit" name="submit1" value="submit">
</form>
</body>
</html>
