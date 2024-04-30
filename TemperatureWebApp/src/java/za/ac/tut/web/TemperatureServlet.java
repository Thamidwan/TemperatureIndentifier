/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.TemperatureClassifierLocal;
import za.ac.tut.model.pojo.Employee;

/**
 *
 * @author USER
 */
public class TemperatureServlet extends HttpServlet {

    @EJB TemperatureClassifierLocal  psl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        Double temp = Double.parseDouble(request.getParameter("temperature"));
        
        String category = psl.classifyTemperature(temp);
        String advice = psl.advice(name);
        
        updateSession(session,category,name,temp);
        request.setAttribute("name",name);
        request.setAttribute("temp", temp);
        request.setAttribute("category", category);
        request.setAttribute("advice", advice);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, String category, String name, Double temp) {
        int highTempCnt =(Integer) session.getAttribute("highTempCnt");
         int lowTempCnt =(Integer) session.getAttribute("lowTempCnt");
         
         List<Employee> highTempEmps= (List<Employee>)session.getAttribute("highTempEmps");
         List<Employee> lowTempEmps = (List<Employee>)session.getAttribute("lowTempEmps");
         
         Employee emp = new Employee();
         emp.setName("name");
         emp.setTemp(temp);
         
         if(category.equals("High")){
             highTempCnt++;
             highTempEmps.add(emp);
             session.setAttribute("highTempCnt", highTempCnt);
             session.setAttribute("highTempEmps", highTempEmps);
             
         }else{
             lowTempCnt++;
             lowTempEmps.add(emp);
             session.setAttribute("lowTempCnt", lowTempCnt);
             session.setAttribute("lowTempEmps", lowTempEmps);
         }
    }


}
