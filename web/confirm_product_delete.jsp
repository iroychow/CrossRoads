<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Product Maintenance</title>
        <link rel="stylesheet" href="styles/main.css">
         <jsp:include page="/header.jsp" />
    </head>
    <body>
        <h1>Are you sure you want to delete this product?</h1>

        <label>Code:</label>
        <label style="font-weight: normal">${product.code}</label> <br>
        
        
        <label>Description:</label>
        <label style="font-weight: normal; width: 40%">${product.description}</label> <br>
        
        <label>Price:</label>
        <label style="font-weight: normal">${product.price}</label> <br>
        
        <div style="float: left;">
             <form  action="productMaint" method="get">
                <input type="hidden" name="action" value="deleteConfirmation">
                <input type="hidden" name="Code" value="${product.code}">
                <input type="hidden" name="Description" value="${product.description}">
                <input type="hidden" name="Price" value="${product.price}">
                <input type="submit" value="Yes">
           </form>
            
        </div>
            <div style="float: right;width: 80%">
            <form  action="productMaint" method="get">
                <input type="hidden" name="action" value="displayProducts">
                <input type="submit" value="No">
           </form>
            </div>
     </body>
</html>