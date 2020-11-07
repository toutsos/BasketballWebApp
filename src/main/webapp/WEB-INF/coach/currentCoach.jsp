<%-- 
    Document   : currentCoach
    Created on : Nov 6, 2020, 1:29:24 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coach</title>
    </head>
    <body>
        <div align='center'>
        <h1>Coach</h1>
        <table border=\"1\">
            <tr>
                <th>Name</th>
                <th>Hire Day</th>
                <th>Salary</th>
            </tr>
            <tr>
                <td>${coach.name}</td>
                <td>${coach.start}</td>
                <td>${coach.salary}</td>
            </tr>
        </table>
         <a href="${request.getContextPath()}/BasketWebApp/menu/coachMenu.jsp"><input type=button value=Back></a>
        </div>
    </body>
</html>