<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/21
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>上傳範例</title>
</head>
<body>
<form action="uploadFiles" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile" id=""><br>
    <button type="submit">upload</button>
</form>
</body>
</html>
