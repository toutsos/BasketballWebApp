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
            out.println("<title>Servlet Training List</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrainingListServlet at " + request.getContextPath() + "</h1>");
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
        TrainingService ts = new TrainingService();
        List<Training> listOfTrainings = ts.getTrainings();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Training List</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Training List</h1>")
                .append("<table border=\"1\">");
        for (Training t : listOfTrainings){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formatDateTime = t.getTrainingDateTime().format(formatter);
                builder.append("<tr>")
                .append("<td>").append(formatDateTime).append("</td>")
                .append("<td>").append(t.getTrainingStadium().getName()).append("</td>")
                .append("<td>").append("<a href=\"").append(request.getContextPath()).append("/participatedplayers?id=").append(t.getId()).append("\">players</a>").append("</td>")
                .append("<td>").append("<a href=\"").append(request.getContextPath()).append("/insertplayers?id=").append(t.getId()).append("\">insert</a>").append("</td>")
                .append("<tr>");
            }
        builder.append("</table>")
                .append("<a href="+request.getContextPath()+"/trainingMenu.jsp><input type=button value=Back></a>")
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
        doGet(request, response);
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
