
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>     
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/header.jsp" /> 
<title>Welcome</title>


<link rel="stylesheet" href="styles/mainpagestyle.css">
</head>
<body>

    <h4>
        Welcome
        <%=session.getAttribute("name")%></h4>
        <a href="productMaint?action=displayProducts">Today's Menu</a>
        <a href="productMaint?action=displayProduct">Upcoming Menu</a>
</body>

  
</html>
