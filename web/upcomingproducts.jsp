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
        <h4>Tomorrow's Menu</h4>
        <table >
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                
            </tr>
             <c:forEach items="${products}" var="product">
            <tr>
              <td>${product.code}</td>
              <td>${product.description}</td>
              <td>${product.getPriceCurrencyFormat()}</td>
               
            </tr>
        </c:forEach>
     </table>
 
      <br>
     <div>
        <form action="productMaint" method="get">
             <input type="hidden" name="action" value="addProducts">
             <input type="hidden" name="operationType" value="displayEmptyProducts">
             <input type="submit" value="Add Products" >
        </form>
      </div>
    </body>
    </html>
