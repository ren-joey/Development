package com.joey.servlets;

import com.joey.services.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employeeList = new ArrayList<Employee>();

        Employee employee = new Employee("01", "Joey", "full-stack developer");
        employeeList.add(employee);

        employee = new Employee("02", "Chad", "java server developer");
        employeeList.add(employee);

        employee = new Employee("03", "Daren", "java server developer");
        employeeList.add(employee);

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("title", "bmd jobs");
        request.setAttribute("url", "https://bmdiot.sharepoint.com/default.aspx");

        String jspUrl = "/views/index.jsp";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(jspUrl);
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
