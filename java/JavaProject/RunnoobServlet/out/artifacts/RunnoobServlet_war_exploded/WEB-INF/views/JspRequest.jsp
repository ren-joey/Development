<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/21
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.

  http://www.runoob.com/jsp/jsp-syntax.html
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>

<%--轉跳--%>
<%--<jsp:forward page="/WEB-INF/views/upload.jsp" />--%>

<%--文字模塊--%>
<jsp:text><![CDATA[<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "DTD/xhtml1-strict.dtd">]]>
</jsp:text>

<%!
    Date date = new Date();
    int rand = new Random().nextInt(50) + 1;
    String attr = "#cool";
    String title = "Accessing Request Param";
%>
<%
    System.out.println("done");
    request.setAttribute("name", "cool");
%>
<html>
<head>
    <title>JSP Request</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/global/header.jsp" flush="true" />
<%
    out.println( request.getRemoteAddr() );
%>
<br>
<%=
    date.toString()
%>
<ul>
<% for(int i=0; i<10; i++){ %>
    <li>
        <% out.println(i); %>
    </li>
 <% } %>
    <li>
        <%= String.format("%02d", rand) %>
    </li>
</ul>
<jsp:useBean id="myName" class="cc.com.beans.TestBean" />
<jsp:setProperty name="myName" property="message" value="Hello World" />
<p>輸出Bean訊息</p>
<jsp:getProperty name="myName" property="message" />
<%--我是註解--%>

<%--JApplet--%>
<%--<jsp:plugin--%>
        <%--type="applet"--%>
        <%--code="cc.com.applets.InfoJApplet"--%>
        <%--codebase="/PluginAction"--%>
        <%--jreversion="1.8"--%>
        <%--archive="PluginActionApplet.jar"--%>
<%-->--%>
    <%--<jsp:params>--%>
        <%--<jsp:param name="firstName"--%>
                   <%--value="James" />--%>
        <%--<jsp:param name="lastName"--%>
                   <%--value="Bond" />--%>
    <%--</jsp:params>--%>
    <%--<jsp:fallback>--%>
        <%--<p>Could not load the applet!</p>--%>
    <%--</jsp:fallback>--%>
<%--</jsp:plugin>--%>
<br>
<jsp:element name="div">
    <jsp:attribute name="data-target">
       <%= attr %>
    </jsp:attribute>
    <jsp:body>
        XML 元素的主体
    </jsp:body>
</jsp:element>
<br>
<jsp:text>
    我是文字模塊 Welcome to JSP Programming
</jsp:text>

<table border="1">
    <thead>
        <tr>
            <th>名稱</th>
            <th>數值</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                web.xml Servelt Name
            </td>
            <td>
                <%
                    out.println( config.getServletName() );
                %>
            </td>
        </tr>
    </tbody>
</table>


</body>
</html>
