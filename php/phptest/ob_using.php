<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
<?php
	function callback($buffer){
		return '<span style="color:red; font-size:36px;">' . $buffer . '</span>';
	}
	
	ob_start('callback');
	
	for($i=1;$i<=50;$i++){
		echo $i . ' ';
		if($i % 5 == 0){
			ob_flush();
			echo ob_get_contents();
		}else{
			ob_clean();
		}
	}
	ob_end_clean();
	
	?>
</body>
</html>
