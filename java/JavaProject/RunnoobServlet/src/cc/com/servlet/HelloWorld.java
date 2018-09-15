package cc.com.servlet;

import cc.com.dao.requestMapping;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends javax.servlet.http.HttpServlet {

    private String msg = "WORK";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        requestMapping mapping = new requestMapping();
        mapping.setMap(request.getParameterMap());
        mapping.printProperties();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(msg);
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
