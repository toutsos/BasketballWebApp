/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.entities.Game;
import kepyes.entities.Stadium;
import kepyes.service.GameService;
import kepyes.service.StadiumService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CreateGameServlet", urlPatterns = {"/game/insert"})
public class CreateGameServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game/gameForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService gs = new GameService();
        StadiumService ss = new StadiumService();
        String pdate = request.getParameter("date");
        LocalDate date = LocalDate.parse(pdate);
        String ptime = request.getParameter("time");
        LocalTime time = LocalTime.parse(ptime);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        
        String sstadium = request.getParameter("stadium");
        String opponent = request.getParameter("opponent");
        Stadium stadium = ss.findStadiumFromName(sstadium);
        Game newGame = new Game(opponent,dateTime, stadium);
        gs.createGame(newGame);
        
        response.sendRedirect("../gamelist");
        
    }
}
