<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Get ID of the last inserted record using PDO
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

    $sql = "INSERT INTO $tablename(firstname , lastname , email)
    VALUE ('Amy' , 'Jobs' , 'amy@example.com')";

    //use exec() because no results are returned
    $conn -> exec($sql);
    $last_id = $conn->lastInsertId();
    echo "New record created successfully. Last inserted ID is: " . $last_id;
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
