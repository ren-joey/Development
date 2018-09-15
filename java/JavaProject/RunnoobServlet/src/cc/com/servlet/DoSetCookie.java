package cc.com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "DoSetCookie")
public class DoSetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encodename = "";
        String url = "";

        try{
            encodename = URLEncoder.encode(request.getParameter("name"), "utf-8");
            url = request.getParameter("url");
        }catch (Exception e){
            encodename = "unknown";
            url = "unknown";
        }

        // 設置cookie
        Cookie cookie = new Cookie("name", encodename);
        Cookie cookie2 = new Cookie("url", url);

        cookie.setMaxAge(60 * 60 * 24);
        cookie2.setMaxAge(60 * 60 * 24);

        response.addCookie(cookie);
        response.addCookie(cookie2);

        response.sendRedirect("getCookie");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("getCookie");
//        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
