<%-- 
    Document   : welcomeuser
    Created on : Dec 1, 2016, 4:39:45 PM
    Author     : Ishita
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>     
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome <%=session.getAttribute("name")%></title>
<link rel="stylesheet" href="styles/welcomeuserstyling.css">
<jsp:include page="/header.jsp" /> 
</head>
<body>
     
    
    <h5>
        Welcome
        <%=session.getAttribute("name")%></h5>
        
        <a class="view" href="menu?action=viewmenubyuser" ><img src="images/ordernow.png" alt="HTML5 icon" ></a>
       <div class="imgwrapper">
         <h4>Broccoli, Babycorn and Colourful Pasta Salad<br></h4>
         <p>This incredibly easy pasta salad recipe will get you hooked.<br> 
             Tip in some fresh herbs like parsley and basil for some added flavor<br>
             or a dollop of cream for some indulgence.<br>
         </p>
        
        <img src="images/food1.jpg" class="img-responsive" align="left">
        
        
        <h4>Chorizo Penne Pasta in Tomato Sauce<br></h4>
         <p>This dish is a magic of penne pasta, chorizo, tomato, parmesan.<br> 
             This recipe is for the lazy cooks and pork lovers.  <br>
         </p>
        
        <img src="images/food2.jpg" class="img-responsive" align="left">
        
        
        <h4>Chicken Caesar Pasta Salad<br></h4>
         <p>We make this all-time favourite Caesar Salad with wholesome penne pasta .<br> 
             It makes for a quick and easy lunch meal.<br>
             Top it with Parmesan and enjoy..<br>
        
        <img src="images/food3.jpg" class="img-responsive" align="left">
        
        
         <h4>Continental Apple Cake<br></h4>
         <p>Simple and easy to make cake recipe adorned with apples.<br>
             Baked golden to satisfy your sweet tooth. .<br> 
       
        <img src="images/food4.jpg" class="img-responsive" align="left">
        
        <h4>Broccoli Bake<br></h4>
        <p>A cheesy sauce poured over blanched broccoli and baked to perfection.<br>
             This broccoli bake recipe is tasty and creamy.<br>
              
       
        <img src="images/food5.jpg" class="img-responsive" align="left">
        
        <h4>Devilled Eggs<br></h4>
        <p>Devilled eggs, also known as picnic eggs, egg mimosa and Russian<br> 
            eggs, are stuffed with a cream filling that can be spruced up in <br>
            numerous ways using spices, herbs and sauces.<br>
            It's ridiculously easy and hard to resist!<br>
              
       
        <img src="images/food6.jpg" class="img-responsive" align="left">
        
                </div>
        
     </body>
</html>
