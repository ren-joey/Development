<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>All request</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>名稱</th>
                <th>數據</th>
            </tr>
        </thead>
        <tbody>
    <%
        Enumeration<String> enu = request.getHeaderNames();
        while (enu.hasMoreElements()){
            String each =  enu.nextElement();
            out.println("<tr>");
            out.println("<td>" + each + "</td><td>" + request.getHeader(each) + "</td>");
            out.println("</tr>");
        }
    %>
        </tbody>
    </table>
</body>
</html>
