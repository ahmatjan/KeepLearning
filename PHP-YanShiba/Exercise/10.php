<?php

/*
//1. ��ϰʹ��POST
print_r($_POST);
*/

//2. ��ϰ�ļ�д�����
$fh = fopen("./msg.txt", "a");
fwrite($fh, "From php to text.\n");
fclose($fh);

echo "OK<br>";
?>
