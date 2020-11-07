/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.coach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.entities.Coach;
import kepyes.service.CoachService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CurrentCoach", urlPatterns = {"/currentcoach"})
public class CurrentCoach extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CoachService cs = new CoachService();
        List<Coach> listOfCoaches = cs.getCoaches();
        Coach coach = listOfCoaches.get(listOfCoaches.size()-1);
        request.setAttribute("coach", coach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/coach/currentCoach.jsp");
        dispatcher.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
