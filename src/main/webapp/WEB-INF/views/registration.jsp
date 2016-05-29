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

    <title>Create an account</title>

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
    <div  class="wrap">
        <div class="Regisration">
            <div class="Regisration-head">
                <h2><span></span>Register</h2>
            </div>
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <h2 class="form-signin-heading">Create your account</h2>
                <spring:bind path="username">
                    <div class="form-group"${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username"
                                    autofocus="true"
                                    value="User Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}"
                        ></form:input>
                        <br>
                        <form:errors style="color:red" path="username"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="email">
                    <div class="form-group"${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="email"
                                    value="Email Address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}"
                                    autofocus="true"></form:input>
                        <br>
                        <form:errors  style="color:red" path="email"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group"${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password"
                                    value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"
                        ></form:input>
                         <br>
                        <form:errors  style="color:red;" path="password"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="form-group"${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="passwordConfirm"
                                    value=" Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = ' Confirm Password';}"
                        ></form:input>
                        <br>
                        <form:errors  style="color:red;" path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>
                <div class="submit">
                    <input type="submit" value="Sign Me Up >" >
                </div>
                <div class = "clear"></div>
                <h4><a href="${contextPath}/login">Go back to login page</a></h4>
            </form:form>
        </div>
    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
