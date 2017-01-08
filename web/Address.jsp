<%-- 
    Document   : Confirmation
    Created on : Dec 4, 2016, 10:37:23 PM
    Author     : Ishita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address</title>
        <link rel="stylesheet" href="styles/addressstyling.css">
        <jsp:include page="/header.jsp" /> 
    </head>
    <body>
        <div class="style">
        <form action="Final.jsp" action="post">
            <!--Address-->
        <fieldset>
            <legend>Shipping Address</legend>
            <p><label class="address" for="Name">Name:</label><input class="textbox-400" type="text" name="Name" required></p>
            <p><label class="address" for="Address">Address:</label><input type="text" name="Address" class="textbox-400" required/></p>
            <p><label class="address" for="State">State:</label><input type="text" name="State" class="textbox-400" required/></p>
            <p><label class="address" for="City">City:</label><input type="text" name="City" class="textbox-400"required/></p>
            <p><label class="address" for="Zip">Zip:</label><input type="text" name="Zip" class="textbox-400" required/></p>
            <p><label class="address" for="Contact">Contact:</label><input type="text" name="Contact" class="textbox-400" required/></p>
        </fieldset>
            
            <!--Card Details-->
            <fieldset>
            <legend>Card Details</legend>
            <p><label class="address" for="CardType">Card Type:</label><input class="textbox-400" type="text" name="Card Type" required></p>
            <p><label class="address" for="Card Number">Card Number</label><input type="text" name="Card Number" class="textbox-400"required/></p>
            <p><label class="address" for="CVV">CVV:</label><input type="text" name="CVV" class="textbox-400"required/></p>
       </fieldset>
        </div>
        <div style="text-align:center">  
        <input type="submit" name="Submit" />  
        </div> </form>
         
    </body>
</html>
