/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.training;

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
import kepyes.entities.Stadium;
import kepyes.entities.Training;
import kepyes.service.StadiumService;
import kepyes.service.TrainingService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CreateTrainingServlet", urlPatterns = {"/training/insert"})
public class CreateTrainingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/training/trainingForm.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainingService ts = new TrainingService();
        StadiumService ss = new StadiumService();
        String pdate = request.getParameter("date");
        LocalDate date = LocalDate.parse(pdate);
        String stime = request.getParameter("time");
        LocalTime time = LocalTime.parse(stime);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        
        
        String sstadium = request.getParameter("stadium");
        Stadium stadium = ss.findStadiumFromName(sstadium);
        Training newTraining = new Training(dateTime, stadium);
        ts.createTraining(newTraining);
        response.sendRedirect("../traininglist");
        
    }

}
