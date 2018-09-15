<%--
  Created by IntelliJ IDEA.
  User: surge
  Date: 2018/8/31
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>請登入系統</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" />

    <style>
        #login img{
            margin: 10px 0;
        }
        #login .center {
            text-align: center;
        }

        #login .login {
            max-width: 300px;
            margin: 35px auto;
        }

        #login .login-form{
            padding:0px 25px;
        }
    </style>
</head>
<body>
    <div id="login" class="container">
        <div class="row-fluid">
            <div class="span12">
                <div class="login well well-small">
                    <div class="center">
                        <img src="http://placehold.it/250x100&text=Logo" alt="logo">
                    </div>
                    <form action="/login" style="" class="login-form" id="UserLoginForm" method="post" accept-charset="utf-8">
                        <div class="control-group">
                            <div class="input-prepend">
                                <span class="add-on"><i class="icon-user"></i></span>
                                <input name="username" required="required" placeholder="Username" maxlength="255" type="text" id="UserUsername">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="input-prepend">
                                <span class="add-on"><i class="icon-lock"></i></span>
                                <input name="password" required="required" placeholder="Password" type="password" id="UserPassword">
                            </div>
                        </div>
                        <div class="control-group">
                            <label id="remember-me">
                                <input type="checkbox" name="remember" value="1" id="UserRememberMe"> Remember Me?</label>
                        </div>
                        <div class="control-group">
                            <input class="btn btn-primary btn-large btn-block" type="submit" value="Sign in">
                        </div>
                    </form>
                </div><!--/.login-->
            </div><!--/.span12-->
        </div><!--/.row-fluid-->
    </div><!--/.container-->
</body>
</html>
