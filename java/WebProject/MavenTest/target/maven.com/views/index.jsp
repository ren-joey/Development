<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/24
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${requestScope.title}</title>
</head>
<body>

    <table border="1">
        <thead>
            <tr>
                <th>員工id</th>
                <th>員工姓名</th>
                <th>職務名稱</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.emplist}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.role}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
