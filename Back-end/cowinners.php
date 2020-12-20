<?php
 
 define('DB_HOST', 'localhost');
 define('DB_USER', 'anand');
 define('DB_PASS', '');
 define('DB_NAME', 'users');
 
 //connecting to database and getting the connection object
 $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
 
 //Checking if any error occured while connecting
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 //creating a query
 $stmt = $conn->prepare("select * from winners where event='coding' ORDER BY points DESC;");
 
 //executing the query 
 $stmt->execute();
 
 
 //binding results to the query 
 $stmt->bind_result($event,$student, $points);
 
 $names = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 //$temp['event'] = $event; 
 $temp['student'] = $student; 
 $temp['points'] = $points;
 //$temp['position']=$position;
 array_push($names, $temp);
 }
 
 //displaying the result in json format
 echo "{\"winners\":"; 
 echo json_encode($names);
 echo "}";
 mysqli_close($conn);
 
 ?>
 