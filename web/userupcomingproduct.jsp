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
     <div id="Container-1">
            <div id="Container-2">
                 <div class="container">
                      <div class="table-responsive">          
                        <table class="table"id="Table" border >
                            <tr> 
                            <p>
                            <p>
                                Tomorrow's Menu
                                <br>
                                <br>
                            </p>
                                <th>Description</th>
                                <th>Price</th>
                                
                            </tr>
                        <c:forEach items="${menus}" var="menu">
                            <tr>

                              <td>${menu.description}</td>
                              <td>${menu.getPriceCurrencyFormat()}</td>
                              
                             </tr>
                         </c:forEach>
                             
                        </table>
                          
                      </div>   
                </div>
            
        </div>
        </div>
            
    <div>
        <form action="menu" method="get">
        </form>
      </div>
    </body>
</body>
</html>

    
