<?php
$fh = fopen("./msg.txt", "r");
$i = 1;
while (($row=fgetcsv($fh)) != false)
{
	echo "��", $i, "������:" , "<br>";
	echo $row[0] , "<br>";
	echo $row[1] , "<br><br>"; 
	$i = $i + 1;
}
fclose($fh);
?>
