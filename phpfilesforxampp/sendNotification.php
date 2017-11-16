<?php
require "init.php";

$message=$_POST['message'];
$title=$_POST['title'];
$path_to_fcm='https://fcm.googleapis.com/fcm/send';
//$server_key="AAAA8T-Kkfw:APA91bGqLYpr4Re1bYQQH2re44A8VIoLHmliGo5yuYgyJKQtyehaF7gVmh3NqQ7OkQSfILgsuMlaIQB9TTRuW6lO8wZsVs1x0R0Sk1yr6qZG-oSLL4VJvGtwqptQjLrykDvixhUnXEK8";
$server_key="AIzaSyBUdQyNadNNPbFdHiL3OkAYDd8yqKsX_io";
$sql="select * from fcminfo where ID=1";
$result=mysqli_query($connection,$sql);
$row=mysqli_fetch_row($result);
$key=$row[1];

$headers=array(
	'Authorization:key='.$server_key,
	'Content-Type:application/json'
);
if($key!==''){
	//echo $key;
}else{
		echo "Key is empty";
}
//print($key);
$fields=array('to'=>$key,'notification'=>array('title'=>$title,'body'=>$message));

$payload=json_encode($fields);

$curl_session=curl_init();
curl_setopt($curl_session,CURLOPT_URL,$path_to_fcm);
curl_setopt($curl_session,CURLOPT_POST,true);
curl_setopt($curl_session,CURLOPT_HTTPHEADER,$headers);
curl_setopt($curl_session,CURLOPT_RETURNTRANSFER,true);
curl_setopt($curl_session,CURLOPT_SSL_VERIFYPEER,false);
curl_setopt($curl_session,CURLOPT_IPRESOLVE,CURL_IPRESOLVE_V4);
curl_setopt($curl_session,CURLOPT_POSTFIELDS,$payload);

$result=curl_exec($curl_session);

curl_close($curl_session);
mysqli_close($connection);


?>