<?php
$con = mysql_connect("localhost", "root", "");
if (!$con)
{
	die("Could not connect to localhost<br>" . mysql_error());
}

mysql_select_db("msg_pad", $con);
mysql_query("set names utf8;");
$result = mysql_query("SELECT * FROM msg", $con);
if (!$result)
{
	die("Could not query.<br>" . mysql_error());
}
//print_r($result);
//echo "<br>";
$i = 1;
while ($row = mysql_fetch_array($result))
{
	echo "µ⁄", $i, "Ãı¡Ù—‘£∫<br>";
	echo $row[0], "<br>";
	echo $row[1], "<br><br>";
	$i = $i + 1;
}


mysql_close($con);
echo "OK<br>";
?>
