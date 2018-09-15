package cc.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SubmitForm")
public class SubmitForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> <title>Document</title></head><body> <form action=\"updatePage\"> <input type=\"text\" name=\"name\" id=\"\" /> <input type=\"number\" name=\"age\" id=\"\" /> <input type=\"radio\" name=\"sex\"\" value=\"male\" /> <input type=\"radio\" name=\"sex\"\" value=\"female\" /> <button type=\"submit\">送出</button> </form></body></html>");
        out.close();
    }
}
