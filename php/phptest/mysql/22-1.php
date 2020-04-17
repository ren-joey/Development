<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/17
 * Time: 上午 12:04
 * Trying to connect with MySQL database through php.
 */
    $connection = mysql_connect('localhost','root','123456789');
    if(!$connection)die('Can not connected with MySQL.');
    else echo 'connection succeeded';

    mysql_close($connection);
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

