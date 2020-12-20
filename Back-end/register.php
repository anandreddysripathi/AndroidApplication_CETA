

<?php
  $host="localhost";
  $db_user="anand";
  $db_password="";
  $db_name="users";
  $con=mysqli_connect($host,$db_user,$db_password,$db_name);
$rollnumber=$_POST["rollnumber"];
$username=$_POST["username"];
$password=$_POST["password"];
$passwordfinal=md5($password);
 $sql="select * from login where rollnumber like '".$rollnumber."';";
 $result=mysqli_query($con,$sql);
 $response1=array();
   if((mysqli_num_rows($result)>0))
   {
	   $code="reg_failed";
       $message="User already exists";
	   array_push($response1,array("code"=>$code,"message"=>$message));
	   echo json_encode($response1);
   }
   else
   {
	   $sql="insert into login values('".$rollnumber."','".$username."','".$passwordfinal."');";
	   $result=mysqli_query($con,$sql);
	   $code="reg_success";
	   $message="thanks for registering";
       array_push($response1,array("code"=>$code,"message"=>$message));
	   echo json_encode($response1);
   }
   mysqli_close($con);
?>