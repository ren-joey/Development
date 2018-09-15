package cc.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "AllRequest")
public class AllRequest extends HttpServlet {
    /**
     * AllRequest
     * http://www.runoob.com/servlet/servlet-client-request.html
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> enu = request.getHeaderNames();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> <title>Document</title></head><body>");
        out.println("<table border=\"1\"><tbody>");
        while (enu.hasMoreElements()){
            String each = enu.nextElement();
            out.println("<tr>");
            out.println("<td>" + each + "</td><td>" + request.getHeader(each) + "</td>");
            out.println("</tr>");
        }
        out.println("</tbody></table>");
        out.println("</body></html>");
//        out.println("");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
