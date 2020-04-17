<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Create a MySQL table using PDO.
 */

$servername = "localhost";
$username = "root";
$password = "123456789";
$dbname = "pdo_test";

try{
    //Create connection
    $conn = new PDO("mysql:host=$servername;dbname=$dbname",$username,$password);
    //set the PDO error mode to exception
    $conn -> setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

    //sql to create table
    $sql = "CREATE TABLE MyGuests(
      id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
      firstname VARCHAR(30) NOT NULL ,
      lastname VARCHAR(30) NOT NULL ,
      email VARCHAR(50) ,
      reg_date TIMESTAMP
      );";

    //use exec() because no results are returned
    $conn -> exec($sql);
    echo "Table MyGuests created successfully";
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
