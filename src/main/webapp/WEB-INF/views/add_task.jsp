<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <title>Distributed Computing</title>
    <meta name="description" content="website description" />
    <meta name="keywords" content="website keywords, website keywords" />
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainStyle/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>

<body>

<div id="main">
    <div id="links"></div>
    <div id="header">
        <div style="position: relative; float: right " >
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <span class="logo_colour">Welcome <b>${loggedInUser.username}</b></span>
                <span><button onclick="document.forms['logoutForm'].submit()" style="color: white">Logout</button></span>

            </c:if>
        </div>
        <div id="logo">
            <div id="logo_text">
                <!-- class="logo_colour", allows you to change the colour of the logo text -->
                <h1>distributed_<span class="logo_colour">computing</span></h1>
                <h2>A simple, web application for  DNAD project</h2>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <!-- put class="tab_selected" in the li tag for the selected page - to highlight which page you're on -->
                <li><a href="home">Home</a></li>
                <li class="tab_selected"><a href="add_task">Add task</a></li>
                <li><a href="my_tasks">My task</a></li>
                <li><a href="res_task">Resolve task</a></li>
                <li><a href="view_r_tasks">View resolved tasks</a></li>
                <li><a href="contact">Contact Us</a></li>
            </ul>
        </div>
    </div>
    <div id="site_content">
        <div id="sidebar_container">
            <!-- insert your sidebar items here -->
            <div class="sidebar">
                <div class="sidebar_top"></div>
                <div class="sidebar_item">
                    <h1>Tip'</h1>
                    <h4>Here you can add a new task that can be resolved by other people</h4>
                </div>
                <div class="sidebar_base"></div>
            </div>
            <div class="sidebar">
                <div class="sidebar_top"></div>
                <div class="sidebar_item">
                    <h1>Useful Links</h1>
                    <ul>
                        <li><a href="#">link 1</a></li>
                        <li><a href="#">link 2</a></li>
                        <li><a href="#">link 3</a></li>
                        <li><a href="#">link 4</a></li>
                    </ul>
                </div>
                <div class="sidebar_base"></div>
            </div>
            <div class="sidebar">
                <div class="sidebar_top"></div>
                <div class="sidebar_item">
                    <h1>Useful Info</h1>
                    <p>You can put anything you like in the sidebar. Latest news, useful links, images etc.</p>
                </div>
                <div class="sidebar_base"></div>
            </div>
        </div>
        <div id="content_container">
            <div id="content_top"></div>
            <div id="content">
                <h3 id = "toggle">
                    <span style="color: #203500">   Paste code    -</span>


                    <span style="color: #203500">-   Upload file   </span>
                </h3>
                <div id="pastefile">
                    <sf:form method="POST" modelAttribute="code"
                             action="./add_task_code?${_csrf.parameterName}=${_csrf.token}"
                             enctype="multipart/form-data">
                        <h1>Place your code here</h1>
                        <br/>
                        <div id='container' style='width:600px; border:1px solid black;'>
                            <textarea name="code"
                                      class="input" rows=50
                                      style='border-style:none none dashed none; border-color:black; width:100%; display:block;box-sizing:border-box;border-width:1px; margin-bottom:1px;'
                                      required></textarea>
                            <div style='width:100%; box-sizing:border-box; height:45px;padding:5px;'>
                                <input type="submit" class="button" style='float:right' value="Post">

                                <label >Dificulty level betwen 1 and 10</label>
                                <input name="dificultyc" type="number" min="1" step="1" max="10"required/>
                            </div>
                        </div>
                    </sf:form>
                </div>
                <div id = "upfile">
                    <sf:form method="POST" modelAttribute="code"
                             action="./add_task_file?${_csrf.parameterName}=${_csrf.token}"
                             enctype="multipart/form-data">
                        <fieldset>
                            <table cellspacing="0">
                                <tr>
                                    <th><label >JS format only :</label></th>
                                    <td><input name="file" type="file" accept=".js"  class="button" required/>
                                            <form:errors path="errfile" />
                                </tr>
                                <tr>
                                    <th><label >Dificulty level betwen 1 and 10</label></th>
                                    <td><input name="dificulty" type="number" min="1" step="1" max="10" required/>
                                </tr>
                                <tr>
                                    <th><input type="Submit" value="Post"  class="button" /></th>
                                    <td></td>
                                </tr>
                            </table>
                        </fieldset>
                    </sf:form>
                </div>
            </div>
            <div id="content_base"></div>
        </div>
    </div>
</div>
<div id="footer">Copyright &copy; Company Name. All Rights Reserved. | <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a href="http://www.dcarter.co.uk">dcarter website templates</a></div>
</div>

<script src="${contextPath}/resources/js/modal.js"></script>
<script>
    $('#toggle > span').click(function() {
        var ix = $(this).index();

        $('#pastefile').toggle( ix === 0 );
        $('#upfile').toggle( ix === 1 );
    });
</script>
</body>
</html>