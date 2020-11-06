<%-- 
    Document   : gameMenu
    Created on : Nov 5, 2020, 8:33:25 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Games menu</title>
    </head>
    <body>
        <h1>Game Information</h1>
        <a href="<%request.getContextPath();%>/BasketWebApp/gamelist"><h2>Game List</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/game/insert"><h2>Add new Game</h2></a>
        <a href="<%request.getContextPath();%>/BasketWebApp/mainMenu.jsp"><input type=button value=Back></a>
    </body>
</html>
