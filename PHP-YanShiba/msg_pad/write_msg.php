<?php

//写入留言到文件
$str = $_POST['title'] . "," . $_POST['content'] . "\n";

$fh = fopen("./msg.txt", "a");
fwrite($fh, $str);
fclose($fh);

echo "OK<br>";
?>
