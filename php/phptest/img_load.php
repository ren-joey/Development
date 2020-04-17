<?php ob_start(); ?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	header('Content-Type: img/jpg');
	header('Content-Disposition:attachment; filename="vivi.jpg"');
	readfile('test.jpg');
	?>
</body>
</html>
<?php ob_end_flush(); ?>