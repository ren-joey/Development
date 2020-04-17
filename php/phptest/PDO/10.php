<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * update data in a MySQL table using PDO
 */

$servername = "localhost";
$username = "root";
$password = "123456789";
$dbname = "pdo_test";
$tablename = "MyGuests";

try{
    //Create connection
    $conn = new PDO("mysql:host=$servername;dbname=$dbname",$username,$password);
    //set the PDO error mode to exception
    $conn -> setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
?>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Untitled Document</title>
    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="../jquery-3.1.1.slim.min.js"></script>
    <script src="../tether.min.js"></script>
    <script src="../bootstrap.min.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <?php
    $sql = "UPDATE " .$tablename . " SET lastname='Zara' WHERE id=2";
    $stmt = $conn -> prepare($sql);
    $stmt -> execute();

    echo $stmt->rowCount() . " records updated successfully";
    ?>
</div>
</body>
</html>

<?php
}
catch(PDOException $e){
    echo $sql . "<br>" . $e -> getMessage();
}
//Close the connection
$conn = null;
?>