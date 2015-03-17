<?php

/*
//1. 练习使用POST
print_r($_POST);
*/

//2. 练习文件写入操作
$fh = fopen("./msg.txt", "a");
fwrite($fh, "From php to text.\n");
fclose($fh);

echo "OK<br>";
?>
