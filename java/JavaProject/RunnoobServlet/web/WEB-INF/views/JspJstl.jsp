<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/22
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    request.setAttribute("username", "cool");
    request.setAttribute("num", new Random().nextInt(50) + 1);
    request.setAttribute("num2", new Random().nextInt(3) + 1);
%>

<html>
<head>
    <title>Jsp JSTL</title>
</head>
<body>
<h1>&lt;c:out&gt; 实例</h1>

    <%--  <c:out value="<string1>" default="<string2>" escapeXml="<true|false>"/>  --%>
    <%--  string1 -> 要輸出的數值  --%>
    <%--  string2 -> 若string1為null時的預設值  --%>
    <%--  <true/false> -> 是否要忽略XML格式  --%>
    <%--  http://www.runoob.com/jsp/jstl-core-out-tag.html  --%>
    <c:out value="&lt顯示數值（未進行Xml轉換）&gt" escapeXml="true" default="默認值" />
    <br>
    <c:out value="&lt顯示數值（使用Xml轉換）&gt" escapeXml="false" default="默認值" />
    <br>
    <c:out value="${null}" escapeXml="false">若表達式結果為null，則輸出默認數值</c:out>
    <br>
    <c:out value="${null}" escapeXml="false" default="若表達式結果為null，則輸出默認數值" />
    <br>
    <c:out value="非null" escapeXml="false">若表達式結果為null，則輸出默認數值</c:out>
    <br>


    <%--  <c:set var="<string1>" value="<string2>" target="<string3>" property="<string4>" scope="<string5>"/>  --%>
    <%--  string1 -> 要儲存的數值名稱  --%>
    <%--  string2 -> 要輸出的數值  --%>
    <%--  string3 -> 要修改的屬性所屬對象  --%>
    <%--  string4 -> 要修改的屬性  --%>
    <%--  string5 -> 作用的範圍，application > session > request > page(默认)  --%>
    <%--  http://www.runoob.com/jsp/jstl-core-set-tag.html  --%>
    <input type="text" value="${username}">
    <br>

    <c:set var="userage" scope="page" value="${16}" />
    <c:out value="${userage}" default="永遠的18歲"/>
    <br>

    <c:remove var="userage" scope="page" />
    <c:out value="${userage}" default="永遠的18歲"/>
    <br>


    <%--jstl 意外處理--%>
    <c:catch var="catchException">
        <% int x = 5/0; %>
    </c:catch>
    <c:if test="${catchException != null}">
        <p>${catchException} : ${catchException.message}</p>
    </c:if>


    <%--jstl if else--%>
    <c:if test="${num > 25}" var="testNum" scope="page">
        <p>恭喜大大於25，你的數字為${num}</p>
    </c:if>
    <c:if test="${not testNum}">
        <p>再接再厲哦，你的數字為${num}</p>
    </c:if>


    <%--jstl switch case--%>
    <c:choose>
        <c:when test="${num2 == 1}">
            <p>星期一</p>
        </c:when>
        <c:when test="${num2 == 2}">
            <p>星期二</p>
        </c:when>
        <c:when test="${num2 == 3}">
            <p>星期三</p>
        </c:when>
        <c:otherwise>
            <p>怎麼可能是${num2}</p>
        </c:otherwise>
    </c:choose>


    <%--jstl jsp:include--%>
    <%--http://www.runoob.com/jsp/jstl-core-import-tag.html--%>
    <c:import url="WEB-INF/views/global/header.jsp" var="headerDom" />
    <%--貼上HTML--%>
    ${headerDom}
    <%--打印HTML源碼--%>
    <c:out value="${headerDom}" />


    <%--jstl forEach--%>
    <c:forEach var="i" begin="0" end="10" step="2">
        Item <c:out value="${i}"/><br>
    </c:forEach>

    <c:forTokens items="cool,awesome,good" delims="," var="name">
        <c:out value="${name}" /><br>
    </c:forTokens>


    <%--jstl parse url with properties--%>
    <c:url var="myUrl" value="/doSetCookie">
        <c:param name="name" value="root" />
        <c:param name="url" value="url" />
    </c:url>
    <a href="${myUrl}">link to doSetCookie</a>
    <br>


    <%--jstl redirection--%>
    <%--<c:redirect url="http://www.google.com.tw" />--%>

    <%--jstl url--%>
    <a href="<c:url value="http://www.google.com"/>">該標籤由 c:url 生成</a>

    <jsp:element name="${username}">
        <jsp:attribute name="v:if">
            asp.net
        </jsp:attribute>
    </jsp:element>

    <%--EL 表達式--%>
    <%--若要看到結果須傳入 get 數值--%>
    <table border="1">
        <thead>
            <tr>
                <td>名稱</td>
                <td>數值</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= "${param[\"name\"]}" %></td>
                <td>${param['name']}</td>
            </tr>
            <tr>
                <td><%= "${paramValues[\"name\"][0]}" %></td>
                <td>${paramValues["name"][0]}</td>
            </tr>
            <tr>
                <td><%= "${pageContext.request.parameterMap['name'][0]}" %></td>
                <td>${pageContext.request.parameterMap['name'][0]}</td>
            </tr>
            <tr>
                <td><%= "${header[\"user-agent\"]}" %></td>
                <td>${header["user-agent"]}</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>


</body>
</html>
