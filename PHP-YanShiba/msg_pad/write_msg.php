<?php

//д�����Ե��ļ�
$str = $_POST['title'] . "," . $_POST['content'] . "\n";

$fh = fopen("./msg.txt", "a");
fwrite($fh, $str);
fclose($fh);

echo "OK<br>";
?>
