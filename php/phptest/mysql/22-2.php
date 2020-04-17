<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/17
 * Time: 上午 12:04
 * Trying to Send a Null password on purpose.
 * NOT WORK
 */
?>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Untitled Document</title>
</head>

<body>

<?php
    $connection = mysql_connect('localhost','root','1');
    if(!$connection){
        $msg = 'Connection failed' . '<br>';
        $msg .= 'Error code:' . mysql_errno() . '<br>';
        $msg .= 'Error message' . mysql_error();
    }

    mysql_close($connection);
?>

</body>
</html>

