<%-- 
    Document   : Checkout
    Created on : Dec 3, 2016, 9:21:41 PM
    Author     : Ishita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/mainpagestyle.css" type="text/css"/>
    <link rel="stylesheet" href="styles/menustyling.css">
    <link rel="stylesheet" href="styles/checkoutstyling.css">
    <link rel="stylesheet" href="styles/mainpagestyle.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
    <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="/header.jsp" /> 
         <p>
            
         </p>
         <form action="menu" method="get">
         <div style="float:right;">
               <a href="#" data-toggle="modal" data-target="#buy-modal">
                <img src="images/buy.png" alt="HTML5 icon" height="100px" width="auto"></a>
                </div>
        <!--table--> 
         <div style="float: right;">
             <a href="menu?action=ClearAll">
                 <img src="images/delete.png" alt="HTML5 icon" height="100px" width="auto"></a>
              </div>
           </form>
         <div id="Container-1">
            <div id="Container-2">
         <table id="Table" border>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th>Add Item</th>
                <th>Remove Item</th>
             </tr>
             
        <c:forEach items="${cartitems}" var="item">
            <tr>
                <td>${item.quantity}</td>
                <td>${item.menu.description}</td>
                <td>${item.getTotal()}</td>
                <td><a href= "menu?action=addItemtoCart&code=${item.menu.code}&description=${item.menu.description}&price=${item.menu.price}">
                <img src="images/add-to-cart-dark.png" alt="HTML5 icon" height="55px" width="auto"></td>
                <td><a href= "menu?action=removeFromCart&code=${item.menu.code}&description=${item.menu.description}&price=${item.menu.price}">
                <img src="images/remove-from-cart-dark.png" alt="HTML5 icon" height="55px" width="auto"></a></td>
             </tr>
        </c:forEach>
        </table>
        </div>
        </div>
        <p></p>
        
        <!--Buy-Confirm purchase-->
    <div class="modal fade" id="buy-modal" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
            <div class="loginmodal-container">
		<h1>Confirmation</h1><br>
                <p><i>${message}</i></p>
                
		<form action="Address.jsp" action="post">
                     <label style="width:100%">Total quantity in your cart :${totalCartQuantity}</label>  
                    <label style="width:100%">Total value of your cart :${totalCartValue}</label>  
                    <input type="submit" name="operationType" class="login loginmodal-submit" value="Confirm purchase?" >
		</form>
              </div> 

	</div>
    </div>
    </body>
</html>
