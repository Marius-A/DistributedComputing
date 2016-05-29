<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
    <!--webfonts-->
</head>

<body>

<div class="main">
    <div class="login-head">
        <h1>Distributed computing</h1>
    </div>
    <div  class="wrap">
        <div class="Login">
            <div class="Login-head">
                <h3>LOGIN</h3>
            </div>
            <form method="POST" action="${contextPath}/login" class="form-signin">

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <div class="ticker">
                        <p>${message}</p>
                        <h4>Username</h4>
                        <input name="username" type="text"
                               autofocus="true"
                               value="MYusername" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'MYusername';}"/>
                        <div class="clear"> </div>
                    </div>

                    <div>
                        <p>${error}</p>
                        <h4>Password</h4>
                        <input name="password" type="password"
                               value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" />
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="submit-button">
                        <input type="submit" value="LOGIN  >" >
                    </div>
                    <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                    <div class="clear"> </div>
                </div>

            </form>
        </div>
    </div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
