<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="styles/main.css">
        <jsp:include page="/header.jsp" /> 
    </head>
    <body>
 <h4>Today's Menu</h4>
<!--table-->       
 <table >
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th></th>
                <th></th>
            </tr>
             <c:forEach items="${products}" var="product">
            <tr>
              <td>${product.code}</td>
              <td>${product.description}</td>
              <td>${product.getPriceCurrencyFormat()}</td>
              <td><a href= "productMaint?action=addProduct&productCode=${product.code}&operationType=displayProduct">Edit</a></td>
              <td><a href="productMaint?action=deleteProduct&Code=${product.code}&Description=${product.description}&Price=${product.price}">Delete</a></td>   
            </tr>
        </c:forEach>
     </table>
 
      <br>
     <div>
        <form action="productMaint" method="get">
             <input type="hidden" name="action" value="addProduct">
             <input type="hidden" name="operationType" value="displayEmptyProduct">
             <input type="submit" value="Add Product" >
        </form>
      </div>
      
     
    </body>
   
</html>