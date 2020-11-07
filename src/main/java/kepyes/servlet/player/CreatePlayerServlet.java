/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.player;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.entities.Player;
import kepyes.service.PlayerService;

/**
 *
 * @author atoutsios
 */
@WebServlet (name = "CreatePlayerServlet", urlPatterns = {"/player/insert"})
public class CreatePlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/player/playerForm.jsp");
        dispatcher.forward(request, response);
        
    }//doGet
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService ps = new PlayerService();
        String pname = request.getParameter("name");
        String age = request.getParameter("age");
        int page = Integer.parseInt(age);
        
        String pphone = request.getParameter("phone");
       
        String height = request.getParameter("height");
        int pheight = Integer.parseInt(height);
        String weight = request.getParameter("weight");
        double pweight = Double.parseDouble(weight);
        Player newPlayer = new Player(pname,page,pphone,pheight,pweight);
        ps.createPlayer(newPlayer);
        
        response.sendRedirect("../playerlist");
        
        
    }//doPost
    
    
    
}
