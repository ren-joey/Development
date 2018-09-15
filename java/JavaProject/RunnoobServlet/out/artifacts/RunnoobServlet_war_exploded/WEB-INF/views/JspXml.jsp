<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.

  無法使用無法使用無法使用無法使用無法使用無法使用無法使用無法使用無法使用無法使用
  無法使用無法使用無法使用

  無法使用無法使用無法使用無法使用無法使用無法使用無法使用無法使用無法使用

  無法使用無法使用無法使用無法使用
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>JSTL x:parse Tags</title>
</head>
<body>
    <h3>Books Info:</h3>
    <c:import var="bookInfo" url="http://localhost:8080/xml/books.xml"/>

    <x:parse xml="${bookInfo}" var="output"/>
    <b>The title of the first book is</b>:
    <x:out select="$output/books/book[1]/name" />
    <br>
    <b>The price of the second book</b>:
    <x:out select="$output/books/book[2]/price" />
</body>
</html>
