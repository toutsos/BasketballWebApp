/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "StadiumListServlet", urlPatterns = {"/stadiumlist"})
public class StadiumListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService ss = new StadiumService();
        List<Stadium> listOfStadiums = ss.getStadiums();
        request.setAttribute("listOfStadiums", listOfStadiums);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/stadium/stadiumList.jsp");
        dispatcher.forward(request, response);
        
        
                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doGet(request, response);
    }

}
