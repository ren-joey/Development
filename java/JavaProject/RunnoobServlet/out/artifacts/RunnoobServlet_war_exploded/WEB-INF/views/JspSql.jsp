<%@ page import="java.util.UUID" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%!
    UUID randuuid;
    int randid;
%>

<%
    randuuid = UUID.randomUUID();
    randid = new Random().nextInt(99);
    request.setAttribute("randuuid", randuuid.toString() );
    request.setAttribute("randid", String.format("%02d", randid));
%>

<html>
<head>
    <title>JSP SQL</title>
</head>
<body>
    <!--
    JDBC 驱动名及数据库 URL
    数据库的用户名与密码，需要根据自己的设置
    useUnicode=true&characterEncoding=utf-8 防止中文乱码
    -->

    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/ilease?useUnicode=true&characterEncoding=utf-8"
        user="root" password="123456789" />

    <sql:query dataSource="${snapshot}" var="result" sql="SELECT * FROM `USER` ORDER BY id ASC " />

    <h2>新增前</h2>
    <table border="1">
        <thead>
            <tr>
                <th>uuid</th>
                <th>id</th>
                <th>name</th>
                <th>description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td>${row.uuid}</td>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                    <td>${row.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <sql:update dataSource="${snapshot}" var="result"
                sql="INSERT INTO `USER` (uuid, id, password, name, description) VALUES (?, ?, '1234567', '測試員', 'JSTL測試')">
        <sql:param value="${randuuid}" />
        <sql:param value="${randid}" />
    </sql:update>
    <sql:query dataSource="${snapshot}" var="result" sql="SELECT * FROM `USER` ORDER BY id ASC "/>

    <h2>新增後</h2>
    <table border="1">
        <thead>
        <tr>
            <th>uuid</th>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td>${row.uuid}</td>
                <td>${row.id}</td>
                <td>${row.name}</td>
                <td>${row.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <sql:update dataSource="${snapshot}" var="result" sql="DELETE FROM `USER` WHERE DESCRIPTION='JSTL測試'" />
    <sql:query dataSource="${snapshot}" var="result" sql="SELECT * FROM `USER` ORDER BY id ASC "/>

    <h2>刪除後</h2>
    <table border="1">
        <thead>
        <tr>
            <th>uuid</th>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td>${row.uuid}</td>
                <td>${row.id}</td>
                <td>${row.name}</td>
                <td>${row.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
