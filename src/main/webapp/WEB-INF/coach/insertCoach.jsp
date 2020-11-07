<%-- 
    Document   : insertCoach
    Created on : Nov 6, 2020, 1:42:45 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
    <html>
        <head>
            <title>Insert Coach</title>
        </head>
        <body>
            <div align='center'>
                <h1>New Coach</h1>
                <form action= "${pageContext.request.getContextPath()}/insertcoach" method="post">
                    <table align="center">
                    <tr>
                        <th>Name:<input type="text" name="name"></th>
                    </tr>
                    <tr>
                        <th>Salary:<input type="text" name="salary"></th>
                    </tr>
                    <tr>
                        <th>Start Date:<input type="date" name="date"></th>
                    </tr>
                    <tr>    
                        <th><input type="submit" value="Submit"></th>
                    </tr>
                    </table>
                </form>
                <a href="${request.getContextPath()}/BasketWebApp/menu/coachMenu.jsp"><input type=button value=Back></a>
            </div>
        </body>
    </html>

