<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/18
 * Time: 下午 03:30
 * https://www.w3schools.com/php/php_mysql_connect.asp
 * Delete data from a MySQL table using PDO
 */

class val_send extends RecursiveIteratorIterator{
    function __construct($it)
    {
        parent::__construct($it,self::LEAVES_ONLY);
    }
    function current()
    {
        return "<td>". parent::current() ."</td>";
    }
    function beginChildren()
    {
        echo "<tr>";
    }
    function endChildren()
    {
        echo "</tr>";
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

    //sql to delete a record
    $sql = "DELETE FROM " . $tablename . " WHERE id=3";

    // use exec() because no result are returned
    $conn -> exec($sql);
    echo "Record deleted successfully";

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
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Firstname</th>
            </tr>
        </thead>
        <tbody>
        <?php
        $stmt = $conn -> prepare("SELECT id,firstname FROM " . $tablename);
        $stmt -> execute();

        $result = $stmt -> setFetchMode(PDO::FETCH_ASSOC);
        foreach(new val_send(new RecursiveArrayIterator($stmt -> fetchAll())) as $key => $value){
            echo $value;
        }
        ?>
        </tbody>
    </table>
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
echo  "</table>";
?>