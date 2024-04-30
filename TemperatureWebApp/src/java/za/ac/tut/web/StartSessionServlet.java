/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.pojo.Employee;

/**
 *
 * @author USER
 */
public class StartSessionServlet extends HttpServlet {

    

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
        HttpSession session = request.getSession(true);
        
        initializedSession(session);
        RequestDispatcher disp = request.getRequestDispatcher("employee_details.jsp");
        disp.forward(request, response);
    }

    private void initializedSession(HttpSession session) {
        int highTempCnt = 0 ,lowTempCnt = 0;
        
        List<Employee> highTempEmps = new ArrayList<>();
        List<Employee> lowTempEmps = new ArrayList<>();
        
        
        session.setAttribute("highTempCnt", highTempCnt);
        session.setAttribute("lowTempCnt",lowTempCnt);
        session.setAttribute("highTempEmps",highTempEmps);
        session.setAttribute("lowTempEmps", lowTempEmps);
    }

    

}
