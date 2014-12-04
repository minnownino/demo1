<%-- 
    Document   : success
    Created on : Nov 10, 2014, 11:27:37 AM
    Author     : yuminnow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"></link>
        <link rel="stylesheet" href="style1.css" type="text/css"></link>
        <title>JSP Page</title>
    </head>
    <body align="center">
        <h1>Hello World!</h1>
        <p>welcome, <%= request.getParameter("usernamer")%> </p>
        <a href="index.jsp">Click here to login</a>        
    </body>
</html>
