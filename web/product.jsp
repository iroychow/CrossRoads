<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Menu</title>
        <link rel="stylesheet" href="styles/main.css">
        <jsp:include page="/header.jsp" />
    </head>
    <body>
        <h1>Product</h1>
        <p><i>${message}</i></p>
        <form action="productMaint" method="get">
            <input type="hidden" name="action" value="addProduct"> 
            
            <label class="pad_top">Code:</label>
            <input type="text" name="Code" value="${product.code}" id="code"><span>*</span> <br>
            
            <label class="pad_top">Description:</label>
            <input type="text" name="Description" value="${product.description}"><span>*</span> <br>

            <label class="pad_top">Price:</label>
           <input type="text" name="Price" value="${product.price}"><span>*</span> <br>

           <label class="pad_top">&nbsp;</label> <br>
            
           
           
               <div style="float: left;">
               <input type="submit" name="operationType" value="View Product" >
             </div>
            <div style="float: right;width: 70%">
               <input type="submit" name="operationType" value="Update Product">
                </div>
               
        </form>
   </body>
</html>