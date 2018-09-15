package cc.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ErrorPage")
public class ErrorPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if(servletName == null){
            servletName = "unknown";
        }

        String requestUri = (String) request.getAttribute("javax.servlet.error.servlet_uri");
        if(requestUri == null){
            requestUri = "unknown";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> <title>Document</title></head><body>");
        out.println("<table border=\"1\"><tbody>");

        if( throwable == null && statusCode == null ){
            out.println("<tr>");
            out.println("<td>錯誤代碼</td><td>訊息遺失，請返回<a href=\"" + requestUri + "\">首頁</a></td>");
            out.println("</tr>");
        }else {
            if( statusCode != null ){
                out.println("<tr>");
                out.println("<td>錯誤代碼</td><td>" + statusCode + "</td>");
                out.println("</tr>");
            }
            if( throwable != null ) {
                out.println("<tr>");
                out.println("<td>錯誤種類</td><td>" + throwable.getClass().getName() + "</td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>異常訊息</td><td>" + throwable.getMessage() + "</td>");
                out.println("</tr>");
            }
            out.println("<tr>");
            out.println("<td>訪問頁面</td><td>" + servletName + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>錯誤種類</td><td>" + throwable + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>完整請求</td><td>" + requestUri + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody></table>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
