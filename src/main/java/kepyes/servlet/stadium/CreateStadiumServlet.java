/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.StadiumService;
import kepyes.entities.Stadium;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CreateStadiumServlet", urlPatterns = {"/stadium/insert"})
public class CreateStadiumServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Stadium</title>")
                .append("</head>")
                .append("<body>")
                .append("<div align='center'>")
                .append("<h1>New Stadium</h1>")
                .append("<form action= \"").append(contextPath).append("/stadium/insert\" method= \"post\">")
                .append("Name:").append("<input type=\"text\" name=\"name\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("<a href="+request.getContextPath()+"/stadiumlist><input type=button value=Back></a>")
                .append("</div>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService ss = new StadiumService();
        String name = request.getParameter("name");
        Stadium newStadium = new Stadium(name);
        ss.createStadium(newStadium);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../stadiumlist");
        dispatcher.forward(request,response);
    }

    
}
