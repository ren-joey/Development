package cc.com.servlet;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdatePage")
public class UpdatePage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> set = map.entrySet();
        Iterator<Map.Entry<String, String[]>> itr = set.iterator();

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> <title>Document</title></head><body>");
        out.println("<table border=\"1\"><tbody>");

        while (itr.hasNext()){
            Map.Entry<String, String[]> thisItr = itr.next();
            String[] values = thisItr.getValue();

            out.println("<tr>");
            out.println("<td>" + thisItr.getKey() + "</td>");
            out.println("<td>");
                for( int i=0; i<values.length; i++ ){
                    out.print(values[i]);
                    if (i != values.length -1){
                        out.print(", ");
                    }else {
                        out.print("\n");
                    }
                }
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody></table></body></html>");
        out.close();
    }
}
