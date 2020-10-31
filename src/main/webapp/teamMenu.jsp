<%-- 
    Document   : teamMenu
    Created on : Oct 31, 2020, 11:37:18 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Information</title>
    </head>
    <body>
        <h1>Team information</h1>
        <a href="<%request.getContextPath();%>/playerList"><h2>Player Information</h2></a>
        <a href="<%request.getContextPath();%>/TODO"><h2>Coach Information</h2></a>
        <a href="<%request.getContextPath();%>/TODO"><h2>Stadium Information</h2></a>
        
    </body>
</html>
