<%-- 
    Document   : gameForm
    Created on : Nov 7, 2020, 1:31:38 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Add Game</title>
    </head>
    <body>
        <div align='center'>
            <h1>Add Game</h1>
            <form action= "${request.contextPath()}/BasketWebApp/game/insert" method= "post">
                Date: <input type="date" name="date">
                <br/>
                Time:<input type="time" name="time">
                <br/>
                Opponent:<input type="text" name="opponent">
                <br/>
                Stadium:<input type="text" name="stadium">
                <br/>
                <input type="submit" value="Submit">
                <br/>
            </form>
            <a href="${request.getContextPath()}/menu/gameMenu.jsp"><input type=button value=Back></a>
        </div>
    </body>
</html>
