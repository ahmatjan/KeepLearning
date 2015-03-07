<?php

//写入留言到数据库

mysql_query("set names utf8;");
$con = mysql_connect("localhost", "root", "");
if (!$con)
{
	die("Can't connect to mysql.<br>" . mysql_error());
}

mysql_select_db("msg_pad", $con);
$sql_statement = "INSERT INTO msg VALUES ('$_POST[title]', '$_POST[content]');";
if (!mysql_query($sql_statement, $con))
{
	die("Could not execute sql_statement.<br>" . mysql_error());
}

mysql_close($con);

echo "OK", "<br>";

?>
