<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>無標題文件</title>
</head>

<body>
<?php # 3-4~3-6
    define('userName','joey'); #常數定義後將無法再修改
    $a = 'test';
    $b = array(
        1 => '01',
        2 => '02',
        3 => '1.34cm',
        'color' => 'red',
        1
    );
    $c = new book(); #新增物件
    class book{ #定義新的物件
    var $title;
    var $author;
    var $price;
    }
?>
<p style="font-size: 14px;color: blue;">
    <?php
    echo userName;
    echo '<br>I\'ll<br>' ;  #單引號只能用來輸出字串，直接輸出單引號需用脫逸字元\'
    echo 'C:\\\\<br>'; #要直接輸出\需用脫逸字元\\
    echo "$a <br>"; #要輸出變數需使用雙引號
    echo "${a}001 <br>"; #要讓變數跟其他字元直接連接，可以使用大括號把變數框起來
    echo "$b[color]{$b[1]} <br>";
    echo (int)$b[3]; echo'<br>'; #若要直接改變變數本身型態可以用settype($b[3],'integer');
    echo (float)$b[3]; echo'<br>';
    settype($b[3],'int');   #若要直接改變變數本身型態可以用settype($b[3],'integer');
    echo "$b[3] <br>";
    ?>
</p>


</body>
</html>