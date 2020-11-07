/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.TrainingService;
import kepyes.entities.Training;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "TrainingListServlet", urlPatterns = {"/traininglist"})
public class TrainingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService ts = new TrainingService();
        List<Training> listOfTrainings = ts.getTrainings();
        request.setAttribute("listOfTrainings", listOfTrainings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/training/trainingList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
