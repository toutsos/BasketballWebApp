/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.TrainingService;
import kepyes.entities.Training;
import kepyes.entities.PlayerTraining;
import kepyes.service.PlayerService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "TrainingPlayerServlet", urlPatterns = {"/participatedplayers"})
public class TrainingPlayerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        TrainingService ts = new TrainingService();
        Training training = ts.findTraining(id);
        Set<PlayerTraining> playerTrainings = training.getPlayers();
        request.setAttribute("playerTrainings", playerTrainings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/training/trainingPlayersList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
