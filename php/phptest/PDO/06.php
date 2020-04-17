<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Insert multiple records into MySQL using PDO
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

    //begin the transaction
    $conn -> beginTransaction();

    //our SQL statments
    $insert_code = "INSERT INTO $tablename(firstname , lastname , email)";
    $conn -> exec($insert_code . "VALUES ('John', 'Doe', 'john@example.com')");
    $conn -> exec($insert_code . "VALUES ('Mary', 'Moe', 'mary@example.com')");
    $conn -> exec($insert_code . "VALUES ('Julie', 'Dooley', 'julie@example.com')");

    //commit the transaction
    $conn -> commit();
    echo "New records created successfully.";
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
