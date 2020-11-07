<%-- 
    Document   : mainMenu
    Created on : Oct 31, 2020, 11:26:12 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Basket APP</title>
    </head>
    <body>
        <div align="center">
        <h1>Welcome to our Team!</h1>
        <a href="<%request.getRequestURI();%>/BasketWebApp/menu/teamMenu.jsp"><h2>Team Information</h2></a>
        <a href="<% request.getContextPath();%>/BasketWebApp/menu/trainingMenu.jsp"><h2>Trainings Information</h2></a>
        <a href="<% request.getContextPath();%>/BasketWebApp/menu/gameMenu.jsp"><h2>Games Information</h2></a> 
        </div>
        
           
    </body>
</html>
