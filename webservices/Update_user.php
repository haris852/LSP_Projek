<?php
include 'connection.php';
        $first_name= null;
        $last_name= null;
        $email = null; 
        $password = null;



if($_SERVER['REQUEST_METHOD']=='POST'){

   $first_name = $_POST['first_name'];
    $last_name= $_POST['last_name'];
    $email= $_POST['email'];
    $password= $_POST['password'];
    $user_id= $_POST['user_id'];

}

if($_SERVER['REQUEST_METHOD']=='GET'){

    $first_name = $_GET['first_name'];
    $last_name= $_GET['last_name'];
    $user_id= $_GET['user_id'];

    $email= $_GET['email'];
    $password= $_GET['password'];
   
}

$sql="UPDATE tb_user SET
`first_name`='$first_name',
`last_name`= '$last_name',
`email`='$email',
`password`= '$password'
      WHERE (`user_id`='$user_id')";

      $result=mysqli_query($conn,$sql);


// get the result in the sucees 
if($result)
    {


$sql_select="SELECT * FROM `tb_user` WHERE `user_id`='$user_id'";
$result_select=mysqli_query($conn,$sql_select);



        while($row=mysqli_fetch_assoc($result_select)) {
         

            $first_name=$row['first_name'];
            $last_name=$row['last_name'];
            $password=$row['password']; 
            $email=$row['email']; 
             $user_id=$row['user_id'];
               
     
        }

   $result_array = array("user_id" =>$user_id,
                                "first_name" =>$first_name,
                                 "last_name" =>$last_name,
                                "email" => $email
                                   
                                   
                           
                                    );

    $response = array("response"=> $result_array);
      echo json_encode($response);
   


    }
else
    {
    $response = array("response"=>"failure");
    echo json_encode($response);
    }
