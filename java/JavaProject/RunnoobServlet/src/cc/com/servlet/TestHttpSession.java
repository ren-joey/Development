package cc.com.servlet;

import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TestHttpSession")
public class TestHttpSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Date createTime = new Date( session.getCreationTime() );
        Date nowTime = new Date( session.getLastAccessedTime() );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd aahh:mm:ss");
        String userKey = "user";
        String userID = "#KEOFJEO";
        String enterKey = "Enter times";
        Integer enterTimes = 0;

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");

        out.println("<html><body><table border=\"1\">");
        out.println("<thead><tr><th>KEY</th><th>VALUE</th></tr></thead><tbody>");

        if(session.isNew()){
            out.println("<tr><td colspan=\"2\">NEW SESSION!</td></tr>");

            session.setAttribute(userKey, userID);
        }else {
            enterTimes = (Integer) session.getAttribute(enterKey);
            enterTimes ++;
        }
        session.setAttribute(enterKey, enterTimes);

        out.println("<tr><td>created time</td><td>" + simpleDateFormat.format(createTime) + "</td></tr>" +
                "<tr><td>current time</td><td>" + simpleDateFormat.format(nowTime) + "</td></tr>" +
                "<tr><td>" + userKey + "</td><td>" + session.getAttribute(userKey) + "</td></tr>" +
                "<tr><td>" + enterKey + "</td><td>" + session.getAttribute(enterKey) + "</td></tr>" +
                "</tbody>");
        out.println("</table></body></html>");

        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
