<?php
 /**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Select data from a MySQL database
 **/

$servername = "localhost";
$username = "a500error";
$password = "a500protected";
$dbname = "ch21";
$tablename = "class";

class TableRows extends RecursiveIteratorIterator{
    function __construct($it)
    {
        parent::__construct($it,self::LEAVES_ONLY);
    }
    function current()
    {
        return parent::current() . "<br>";
    }
    function beginChildren()
    {
        echo "<div class='col-4'><div class='col-inner'><div class='table-cell'>";
    }
    function endChildren()
    {
        echo "</div></div></div>";
    }
}

?>

<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="../jquery-3.1.1.slim.min.js"></script>
    <script src="../tether.min.js"></script>
    <script src="../bootstrap.min.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../bootstrap.min.css">

    <!-- Normalize.css -->
    <link rel="stylesheet" href="../normalize.css">

    <!-- Responsive breakpoints -->
    <style>
        /* Extra small devices (portrait phones, less than 576px)
        No media query since this is the default in Bootstrap*/

        /* Small devices (landscape phones, 576px and up)*/
        @media (max-width: 575px) {
            html{
                font-size: 24px;
            }
        }

        /* Medium devices (tablets, 768px and up) */
        @media (min-width: 576px) and (max-width: 767px) {
            html{
                font-size: 20px;
            }
        }

        /* Large devices (desktops, 992px and up) */
        @media (min-width: 768px) and (max-width: 991px) {
            html{
                font-size: 18px;
            }
        }

        /* Extra large devices (large desktops, 1200px and up) */
        @media (min-width: 992px) and (max-width: 1199px) {
            html{
                font-size: 14px;
            }
        }

        /* Extra large devices (large desktops, 1200px and up) */
        @media (min-width: 1200px) {
            html{
                font-size: 12px;
            }
        }

        /*-------------------------------- global style ----------------------------------*/

        body{
            background-color: #eeeeee;
        }

        /*-------------------------------- wrapper style ----------------------------------*/

        .col-inner{
            border-radius: 5px;
            box-shadow: 1px 1px 2px rgba(0,0,0,0.2);
            padding: 10px;
            background-color: #ffffff;
        }

        .col-3 , .col-4{
            padding: 15px;
        }

        .table-cell{
            display: table-cell;
        }

        .title-style{
            font-weight: 900;
            min-width: 50px;
            padding-right: 10px;
        }
    </style>

    <script>
        $(function(){
            $('.col-inner').each(function(){
                var str = "編號<br>姓名<br>地址<br>生日<br>數學<br>英文<br>歷史<br>總成績";
                $('<div>').attr({'class':'table-cell title-style'}).html(str).prependTo(this);
            });
        })
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
    <?php
    try{
        $conn = new PDO("mysql:host=$servername;dbname=$dbname",$username,$password);
        $conn -> setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

        $stmt = $conn->prepare("SELECT id,name,address,birthday,math,english,history,total FROM " . $tablename);
        $stmt -> execute();

        $result = $stmt -> setFetchMode(PDO::FETCH_ASSOC);
        foreach(new TableRows(new RecursiveArrayIterator($stmt -> fetchAll())) as $k => $v){
            echo $v;
        }
    }
    catch(PDOException $e){
        echo $sql . "<br>" . $e -> getMessage();
    }
    //Close the connection
    $conn = null;
    ?>
    </div>
</div>
</body>
</html>
