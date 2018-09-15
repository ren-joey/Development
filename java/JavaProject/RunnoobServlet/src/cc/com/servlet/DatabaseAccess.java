package cc.com.servlet;

import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@WebServlet(name = "DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ilease?characterEncoding=utf-8";
    static final String USER_ID = "root";
    static final String USER_PASS = "123456789";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        Random rand = new Random();

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Servlet Mysql";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER_ID, USER_PASS);

//            stmt = conn.createStatement();
            String sql = "INSERT INTO `USER` (UUID, ID, NAME, DESCRIPTION, PASSWORD) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            UUID uuid = UUID.randomUUID();
            String str = String.format("%07d", rand.nextInt(1000000));
            String str2 = String.format("%04d", rand.nextInt(1000));

            ps.setString(1, uuid.toString());
            ps.setString(2, "test" + str);
            ps.setString(3, "測試員" + str2);
            ps.setString(4, "prepareStatement 測試");
            ps.setString(5, "abcd");
            ps.executeUpdate();

            sql = "SELECT * FROM `USER` ORDER BY USER.id DESC";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                // 通过字段检索
                String myuuid  = rs.getString("uuid");
                String myid = rs.getString("id");
                String myname = rs.getString("name");
                String mydesc = rs.getString("description");

                // 输出数据
                out.println("uuid: " + myuuid);
                out.println(", id: " + myid);
                out.println(", name: " + myname);
                out.println(", description: " + mydesc);
                out.println("<br />");
            }

            out.println("</body></html>");

            // 完成后关闭
            rs.close();
            conn.close();

        } catch(SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch(Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 最后是用于关闭资源的块
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
