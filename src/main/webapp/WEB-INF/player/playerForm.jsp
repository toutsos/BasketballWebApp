<%-- 
    Document   : playerForm
    Created on : Nov 7, 2020, 1:40:03 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Insert Player</title>
    </head>
    <body>
        <div align='center'>
            <h1>New Player</h1>
            <form action= "${request.contextPath()}/BasketWebApp/player/insert" method= "post">
                Name:<input type="text" name="name">
                <br/>
                Age: <input type="text" name="age">
                <br/>
                Phone: <input type="text" name="phone">
                <br/>
                Height: <input type="text" name="height">
                <br/>
                Weight: <input type="text" name="weight">
                <br/>
                <input type="submit" value="Submit">
                <br/>
                <a href="${request.getContextPath()}/BasketWebApp/playerlist"><input type="button" value=Back></a>
                <br/>
            </form>
        </div>
    </body>
</html>
