/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.coach;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.CoachService;
import kepyes.entities.Coach;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CreateCoachServlet", urlPatterns = {"/insertcoach"})
public class CreateCoachServlet extends HttpServlet {

   
    

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Coach</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>New Coach</h1>")
                .append("<form action= \"").append(contextPath).append("/insertcoach\" method= \"post\">")
                .append("Name:").append("<input type=\"text\" name=\"name\">")
                .append("<br/>")
                .append("Salary:").append("<input type=\"text\" name=\"salary\">")
                .append("<br/>")
                .append("Start Date:").append("<input type=\"date\" name=\"date\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("<a href="+request.getContextPath()+"/coachMenu.jsp><input type=button value=Back></a>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CoachService cs = new CoachService();
        String name = request.getParameter("name");
        String ssalary = request.getParameter("salary");
        int salary = Integer.parseInt(ssalary);
        String sdate = request.getParameter("date");
        LocalDate date = LocalDate.parse(sdate);
        
        Coach newCoach = new Coach(name,salary,date);
        cs.createCoach(newCoach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../coachMenu.jsp");
        dispatcher.forward(request,response);
    }

}
