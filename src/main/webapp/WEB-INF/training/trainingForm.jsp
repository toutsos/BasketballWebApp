<%-- 
    Document   : trainingForm
    Created on : Nov 7, 2020, 10:53:44 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Training</title>
    </head>
    <body>
        <div align='center'>
            <h1>New Training</h1>
            <form action= "${pageContext.request.getContextPath()}/training/insert" method= "post">
                <h4>Date:<input type="date" name="date"></h4>
                <h4>Time<input type="time" name="time"></h4>
                <h4>Stadium<input type="text" name="stadium"></h4>
                <a href="${request.getContextPath()}/BasketWebApp/traininglist"><input type=button value=Back></a>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>;
