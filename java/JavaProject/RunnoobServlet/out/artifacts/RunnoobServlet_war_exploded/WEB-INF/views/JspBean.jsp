<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSP USE BEAN</title>
</head>
<body>
    <jsp:useBean id="member" class="cc.com.beans.TestBean">
        <jsp:setProperty name="member" property="name" value="王大明" />
        <jsp:setProperty name="member" property="age" value="16" />
    </jsp:useBean>

    <table border="1">
        <thead>
            <tr>
                <th>姓名</th>
                <th>年齡</th>
                <th>備註</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <jsp:getProperty name="member" property="name"/>
                </td>
                <td>
                    <jsp:getProperty name="member" property="age" />
                </td>
                <td>
                    <jsp:getProperty name="member" property="message" />
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
