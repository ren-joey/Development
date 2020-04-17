<?php
/**
 * Created by PhpStorm.
 * User: Joey
 * Date: 2017/6/17
 * Time: 上午 12:04
 *Asking database for the amount of table columns.
 *Delete data of score that less then 90.
 */
    $connection = mysql_connect('localhost','root','123456789');
    if(!$connection)die('Can not connected with MySQL.');

    $db_selected = mysql_select_db('ch21',$connection);
    if(!$db_selected)die('Can not connected with ch21 database.');

    $result = mysql_query('select * from class' , $connection) or
    die('Running SQL searching function failed.');
    if($result){
        $num_rows = mysql_num_rows($result);
        echo 'The amount of CLASS database had been recorded : ' . $num_rows . '<br>';

        $num_cols = mysql_num_fields($result);
        echo 'The amount of table columns on CLASS database : ' . $num_cols . '<br>';
    }

    $deleted =  mysql_query('DELETE FROM class WHERE math < 90');
    if($rows = mysql_affected_rows() != -1){
        echo $rows . ' data of score had been deleted.';
    }else{
        echo 'deleted failed';
    }

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

