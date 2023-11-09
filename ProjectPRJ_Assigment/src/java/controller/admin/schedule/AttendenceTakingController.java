/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin.schedule;

import controller.authentication.BasedRequiredAuthentication;
import dal.AttendenceDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Array;
import java.util.ArrayList;
import model.Attendence;
import model.Session;
import model.Student;

/**
 *
 * @author THINKPAD
 */
public class AttendenceTakingController extends BasedRequiredAuthentication {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionDBContext db = new SessionDBContext();
        int id = Integer.parseInt(request.getParameter("id"));
        Session ses = db.getSessions(id);
        request.setAttribute("ses", ses);
        
        AttendenceDBContext attDb = new AttendenceDBContext();
        ArrayList<Attendence> atts = attDb.getAttendenceBySession(id);
        
        request.setAttribute("atts", atts);
        request.getRequestDispatcher("../view/admin/att.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        String[] stuids = request.getParameterValues("stuid");
        for(String stuid: stuids){
            Attendence a = new Attendence();
            a.setSession(ses);
            Student s = new Student();
            s.setId(Integer.parseInt(stuid));
            a.setStudent(s);
            a.setStatus(request.getParameter("status"+stuid).equals("present"));
            a.setDescription(request.getParameter("description"+stuid));
            ses.getAtts().add(a);
        }
        SessionDBContext sesDB = new SessionDBContext();
        sesDB.addAttendences(ses);
        response.getWriter().println("done");
        request.setAttribute("error", "Update attendence succesfully");
        request.getRequestDispatcher("../view/admin/timetable.jsp").forward(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
