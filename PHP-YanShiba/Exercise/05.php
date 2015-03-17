<?php
$i = 1;
while ($i <= 100)
{
	echo $i, '<br>';
	$i++;
}

$i = 1;
while ($i <= 100)
{
	if ($i % 2 == 0)
	{
		echo $i, '<br>';
	}
	$i++;
}

for ($i = 1; $i <= 100; $i++)
{
	$flag1 = 0;
	$flag2 = 0;

	if ($i % 3 == 0)
	{
		$flag1 = 1;
	}
	if ($i % 5 == 0)
	{
		$flag2 = 1;
	}

	if ($flag1 && $flag2)
	{
		echo $i, '是3和5的倍数<br>';
		continue;
	}
	if ($flag1)
	{
		echo $i, '仅是3的倍数<br>';
		continue;
	}
	if ($flag2)
	{
		echo $i, '仅是5的倍数<br>';
		continue;
	}
}

?>
