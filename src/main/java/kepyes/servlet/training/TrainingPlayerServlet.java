/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainingPlayerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainingPlayerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        TrainingService ts = new TrainingService();
        Training training = ts.findTraining(id);
        Set<PlayerTraining> playerTrainings = training.getPlayers();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Player List</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Player List</h1>")
                .append("<table border=\"1\">");
        for (PlayerTraining pt:playerTrainings){
            builder.append("<tr>")
            .append("<td>").append(pt.getPlayer().getName()).append("</td>")
            .append("<td>").append(pt.getRank()).append("</td>")
            .append("<tr>");       
            
        }
         builder.append("</table>")
                .append("<a href="+request.getContextPath()+"/traininglist><input type=button value=Back></a>")
                .append("</body>")
                .append("</html>");
        PrintWriter out = response.getWriter();
        out.println(builder);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
