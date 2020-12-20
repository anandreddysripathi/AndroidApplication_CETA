<?php
 $host="localhost";
  $db_user="anand";
  $db_password="";
  $db_name="users";
  $con=mysqli_connect($host,$db_user,$db_password,$db_name);
 $username=$_POST["username"];
 $password=$_POST["password"];
 $encrypted_password=md5($password);
 
   /*$sql_for_password="select password from login where username like '".$username."';";
	$result_password=mysqli_query($con,$sql_for_password);
	 if(mysqli_num_rows($result_password)>0)
	 {
         $row_for_password=mysqli_fetch_row($result_password);
		 //$username_tp=$row_for_password[0];
         $encrypted_password=$row_for_password[0];
	 }
	$decrypted_password=md5(utf8_decode('".$encrypted_password."'));
	*/
	
	
	$sql="select * from login where Rollnumber like '".$username."' and password like '".$encrypted_password."';";
 $result=mysqli_query($con,$sql);
 $response1=array();

 
 if(mysqli_num_rows($result)>0)
 {
    $row=mysqli_fetch_row($result);
	$rollnumber=$row[1];
	$username=$row[0];
	 //$password=$row[2];
	  if($rollnumber=='admin')
	  {
		  $code="login_success_admin";
    array_push($response1,array("code"=>$code,"username"=>$username,"rollnumber"=>$rollnumber));
    echo json_encode($response1);
	  }
	   else
	  {
	 $code="login_success";
    array_push($response1,array("code"=>$code,"username"=>$rollnumber,"rollnumber"=>$username));
    //array_push($response1,array("code"=>$code,"username"=>$username,"rollnumber"=>$rollnumber));
    echo json_encode($response1);
	  }
	 }	 
  else
  {
	 $code="login_failed";
	// $message="Enter valid details";
	 array_push($response1,array("code"=>$code));
	 echo json_encode($response1);
  }
  mysqli_close($con);
 ?>
 