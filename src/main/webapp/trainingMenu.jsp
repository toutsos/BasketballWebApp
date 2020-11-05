<%-- 
    Document   : trainingMenu
    Created on : Nov 4, 2020, 11:51:43 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainings Inforamtion</title>
    </head>
    <body>
        <h1>Coach Information</h1>
        <a href="<%request.getContextPath();%>/BasketWebApp/traininglist"><h2>Trainings List</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/training/insert"><h2>Add new Training</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/mainMenu.jsp"><input type=button value=Back></a>
    </body>
</html>
