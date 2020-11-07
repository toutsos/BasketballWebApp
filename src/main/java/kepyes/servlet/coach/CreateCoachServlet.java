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
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/coach/insertCoach.jsp");
        dispatcher.forward(request, response);
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
        response.sendRedirect("menu/coachMenu.jsp");
        
    }

}
