<?php
  $host="localhost";
  $db_user="anand";
  $db_password="";
  $db_name="users";
  $con=mysqli_connect($host,$db_user,$db_password,$db_name);
  if($con)
  {
	  echo "connection successful";
  }
  else
  {
	  echo "connection unsuccessful";
  }
?>