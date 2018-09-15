<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Calendar" %>

<%! String now = ""; %>

<html>
<head>
    <title>Jsp Response</title>
</head>
<body>

    <%
        response.setIntHeader("Refresh", 1);
        Calendar calendar = new GregorianCalendar();
        String am_pm;

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second  = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0){
            am_pm = "AM";
        }else {
            am_pm = "PM";
        }

        String CT = String.format("%s %02d:%02d:%02d", am_pm, hour, minute, second);
        now = CT;
    %>

    <jsp:element name="input">
        <jsp:attribute name="type">
            text
        </jsp:attribute>
        <jsp:attribute name="value">
            <%= now %>
        </jsp:attribute>
    </jsp:element>
</body>
</html>
