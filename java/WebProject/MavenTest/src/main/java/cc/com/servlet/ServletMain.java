package cc.com.servlet;

import cc.com.service.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "ServletMain")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = "職員職務";

        List<Employee> employeeList = new ArrayList<Employee>();

        Employee emp = new Employee("01", "com.joey", "front-end developer");
        employeeList.add(emp);

        emp = new Employee("02", "double", "designer");
        employeeList.add(emp);

        emp = new Employee("03", "charlie", "back-end developer");
        employeeList.add(emp);

        request.setAttribute("emplist", employeeList);
        request.setAttribute("title", title);

        String forwardUrl = "/views/index.jsp";

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(forwardUrl);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
