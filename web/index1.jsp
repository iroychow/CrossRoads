<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<!--external style sheets,links,scripts-->
    <head>
        <meta charset="utf-8">
        <title>CrossRoads</title>
        <link rel="stylesheet" href="styles/mainpagestyle.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="login.js"></script>
     </head>
<!--bootstrap-->
        <div style="background:#DE6262 !important" class="jumbotron container-fluid">
        <h1>CrossRoads</h1>      
        <p> <b>Pit stop for taste buds</b></p>
        </div>  
       
      <a href="#" data-toggle="modal" data-target="#register-modal">Register</a>
      <a href="#" data-toggle="modal" data-target="#userlogin-modal">Login</a>
      <a href="#" data-toggle="modal" data-target="#login-modal" style="float:right" >Admin</a> 
      <a href="#" data-toggle="modal" data-target="#aboutus-modal" style="float:right" >About US</a>
      <a href="#" data-toggle="modal" data-target="#contactus"  >Contact US</a>
 
 <!--admin-login-->
      <div class="modal fade" id="login-modal" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" 
           aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="loginmodal-container">
		<h1>Admin Login</h1><br>
                <p><i>${message2}</i></p>
                <form action="registercontroller" method="post">
		<input type="text" name="username" placeholder="Username">
		<input type="password" name="password" placeholder="Password">
		<input type="submit" name="operationType" class="login loginmodal-submit" value="Submit" >
		</form>
              </div> 
        </div>
        <input id="errorMsg2" type="hidden" value="${message2}"/>
      </div>   
  <!--About US-->  
    <div  class="modal fade" id="aboutus-modal" tabindex="-2" role="dialog" 
          aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
              <p class="aboutus"> We are group of 6 Chefs and we specialize in continental dishes.
                  We have gained our culinary abilities from all over the world.
                  Cooking and making people happy with our food is our passion.<br>
                  Please feel free to email your suggestions to us.<br>
                  <img src="images/about-us.jpg"  
                       alt="HTML5 Icon" style='width:100%; height:auto' border="0"> 
               </p><br>
	</div>
    </div> 
  <!--Contact US-->       
    <div  class="modal fade" id="contactus" tabindex="-2" role="dialog" 
          aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
            <p class="aboutus"> <b>For any suggestions or complaints please feel free to 
                    contact us at rc530297@gmail.com or at +1-704-345-7895.</b> <br>
                  <img src="images/contactus.jpg"  
                       alt="HTML5 Icon" style='width:100%; height:auto' border="0"> 
               </p><br>
	</div>
    </div> 
   <!--Background image-->   
    <div class="image"> 
           <img src="images/continental-breakfast-5-c601.jpg-cropper-1270x649.jpg"  
                alt="HTML5 Icon" style='width:100%; height:auto' border="0"> 
    </div>
      
    <!--User reg-->
     <div class="modal fade" id="register-modal" tabindex="-2" role="dialog" 
          aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
            <div class="loginmodal-container">
		<h1>Register</h1><br>
                <p><i>${message}</i></p>
		<form action="registercontroller" action="post">
                <input type="email" name="email" placeholder="Email">
		<input type="text" name="username" placeholder="Username">
		<input type="password" name="password" pattern=".{6,}" title="Six or more characters" placeholder="Password">
		<input type="submit" name="operationType" class="login loginmodal-submit" value="Register" >
		</form>
              </div> 
            </div>
        <input id="errorMsg" type="hidden" value="${message}"/>
     </div>  
    
               
   <!--User Login-->           
     <div class="modal fade" id="userlogin-modal" tabindex="-2" role="dialog" 
          aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
            <div class="loginmodal-container">
		<h1>Login</h1><br>
                <p><i>${message1}</i></p>
		<form action="registercontroller" action="post">
		<input type="email" name="email" placeholder="Email">
		<input type="password" name="password" placeholder="Password">
		<input type="submit" name="operationType" class="login loginmodal-submit" value="login" >
		</form>
              </div> 
            </div>
        <input id="errorMsg1" type="hidden" value="${message1}"/>
     </div>  
</html>
