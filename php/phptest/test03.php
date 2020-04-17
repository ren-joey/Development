<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>無標題文件</title>
</head>

<body>
<?php # 3-7
    $a = 'successful';
    $b = 3;
    $c = '3 dollar';
    $successful33 = 100;
?>
<p style="font-size: 14px;color: blue;">
    <?php
        echo "you can use" . ' \'.\' or \',\' ' . 'to put string ' , 'together' , '<br>' , $a;
    ?>
    <br>
    $a的內容是： <?=$a?>
    <?php
        printf("%s%d%d",$a,$b,$c); #printf 用來直接輸出字串
        echo ${sprintf("%s%d%d",$a,$b,$c)}; #sprintf用來回傳自串供程式使用，此例子就是用運回傳的successful33來呼叫100
    ?>
</p>


</body>
</html>