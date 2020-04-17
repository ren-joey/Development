<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Create a MySQL database using PDO.
 */

$servername = 'localhost';
$username = 'root';
$password = '123456789';

try{
    //Create connection
    $conn = new PDO("mysql:host=$servername",$username,$password);
    //set the PDO error mode to exception
    $conn -> setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
    $sql = "CREATE DATABASE pdo_test";
    //use exec() because no results are returned
    $conn -> exec($sql);
    echo "Database created successfully<br>";
}
catch(PDOException $e){
    echo $sql . "<br>" . $e -> getMessage();
}
    //Close the connection
    $conn = null;
?>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Untitled Document</title>
</head>

<body>

</body>
</html>
