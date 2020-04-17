<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Select data from a MySQL database
 */

echo "
<table style='border: solid 1px blue;'>
";
echo "
<tr>
    <th>Id</th>
    <th>Firstname</th>
    <th>Lastname</th>
</tr>
";

class TableRows extends RecursiveIteratorIterator{
    function __construct($it)
    {
        parent::__construct($it,self::LEAVES_ONLY);
    }

    function current()
    {
        return "<td style='width: 150px;border: 1px solid black;'>" . parent::current() . "</td>";
    }

    function beginChildren()
    {
        echo "<tr>";
    }

    function endChildren()
    {
        echo "</tr>" . "\n";
    }

}

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

    $stmt = $conn -> prepare("SELECT id , firstname , lastname FROM " . $tablename);
    $stmt -> execute();

    // set the resulting array to associative
    $result = $stmt -> setFetchMode(PDO::FETCH_ASSOC);
    foreach(
        new TableRows(
            new RecursiveArrayIterator(
                $stmt->fetchAll()
            )
        ) as $k => $v
    ){
        echo $v;
    }
}
catch(PDOException $e){
    echo $sql . "<br>" . $e -> getMessage();
}
    //Close the connection
    $conn = null;
echo  "</table>";
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
