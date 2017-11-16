<?php
require "init.php";
$fcm_token=$_POST["fcm_token"];
$sql="insert into fcminfo values(1,'".$fcm_token."');";
mysqli_query($connection,$sql);
mysqli_close($connection);

?>