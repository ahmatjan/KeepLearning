<?php
echo '起床<br>';
echo '刷牙<br>';
echo '吃早饭<br>';

$mood = 'good';
if ($mood == 'good')
{
	echo '烦恼<br>';
}
else
{
	echo '开心<br>';
}

$rice = 1;
while ($rice < 10)
{
	echo '吃了', $rice, '份米饭，没吃饱<br>';
	echo '再来一份<br>';
	$rice = $rice + 1;
}
echo '吃了', $rice, '份米饭，终于吃饱了.<br>';



?>
