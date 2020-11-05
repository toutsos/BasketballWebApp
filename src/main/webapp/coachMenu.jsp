<%-- 
    Document   : coachMenu
    Created on : Nov 4, 2020, 10:05:42 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Coach Information</title>
    </head>
    <body>
        <h1>Coach Information</h1>
        <a href="<%request.getContextPath();%>/BasketWebApp/currentcoach"><h2>Current Coach Information</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/insertcoach"><h2>Insert new Coach</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/previouscoaches"><h2>Coach History</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/teamMenu.jsp"><input type=button value=Back></a>
    </body>
</html>
