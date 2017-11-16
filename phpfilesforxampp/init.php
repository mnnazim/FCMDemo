<?php

$host="localhost";
$db_user="root";
$db_password="";
$db_name="fcmdb";

$connection=mysqli_connect($host,$db_user,$db_password,$db_name);

if($connection)
	echo "connection success";
else
	echo "Connection Error";
?>