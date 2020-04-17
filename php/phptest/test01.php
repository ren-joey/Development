<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>無標題文件</title>
</head>

<body>
<?php # 3-1~3-3
$a = 4 + 4 * 2 ;
$b = "d";
$c = 3.44556;
$d = "success";
$e = &$d; #$e指向$d的記憶體位置
?>
<p style="font-size: 14px;color: red;">
	<?php
	echo "this is a php page. $a <br>";
	echo "a = $a <br>";
	var_dump($a , $b , $c , $$b ,$e);
	echo "<br> $$b {$$b}"; # $$b 會輸出成 $d ，因為$b = "d" ，$$b = $"d"，但若要正確輸出$d的內容"success"，就必須用大刮號框起來{$$b}
	echo "<br>";
	var_dump(isset($a));	#判斷是否有值
	echo "<br>";
	var_dump(isset($d));
	echo "<br>";
	?>	 
</p>


</body>
</html>