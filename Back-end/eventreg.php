

<?php
  $host="localhost";
  $db_user="anand";
  $db_password="";
  $db_name="users";
  $con=mysqli_connect($host,$db_user,$db_password,$db_name);
  $event=$_POST["event"];
$username=$_POST["rollnumber"];
 $sql="select * from events_registration where rollnumber like '".$username."' and Events like '".$event."';";
 $result=mysqli_query($con,$sql);
 $response1=array();
 if(mysqli_num_rows($result)>0)
   {
	   $code="reg_failed";
       $message="Already Registered";
	   array_push($response1,array("code"=>$code,"message"=>$message));
	   echo json_encode($response1);
   }
   else
   {
	   $sql="insert into events_registration values('".$event."','".$username."');";
	   $result=mysqli_query($con,$sql);
	   $code="reg_success";
	   $message="you are now registered ";
       array_push($response1,array("code"=>$code,"message"=>$message));
	   echo json_encode($response1);
   }
   mysqli_close($con);
?>