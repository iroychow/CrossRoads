<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Menu</title>
    <link rel="stylesheet" href="styles/menustyling.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <jsp:include page="/header.jsp" /> 
    </head>

    <body>
     <div class="cart"><%=session.getAttribute("quantity")%>
            <a href="menu?action=displaycart">
                <img src="images/Add_to_Cart-512.png" alt="HTML5 icon" height="100px" width="auto"> </a></div>
          <!--Table design-->
            <div id="Container-1">
            <div id="Container-2">
                 <div class="container">
                      <div class="table-responsive">          
                        <table class="table"id="Table" border >
                            <tr> 
                                <th>Description</th>
                                <th>Price</th>
                                <th>Add to Cart</th>
                            </tr>
                        <c:forEach items="${menus}" var="menu">
                            <tr>

                              <td>${menu.description}</td>
                              <td>${menu.getPriceCurrencyFormat()}</td>
                              <td><a href= "menu?action=addtocart&code=${menu.code}&description=${menu.description}&price=${menu.price}">
                                      <img src="images\cart.png" alt="HTML5 icon" height="35px" width="30px"></a></td>
                             </tr>
                         </c:forEach>
                             
                        </table>
                          
                      </div>   
                </div>
            
        </div>
        </div>
     <div> <a href="menu?action=upcomingitems"><img src="images/comingup.png" alt="HTML5 icon" height="100px" width="auto"> </a></div>
            
            
    <div>
        <form action="menu" method="get">
        </form>
      </div>
    </body>
</body>
</html>

    
