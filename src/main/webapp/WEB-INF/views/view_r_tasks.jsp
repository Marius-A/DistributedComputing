<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
  <title>Distributed Computing</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainStyle/style.css" />
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
          <li><a href="add_task">Add task</a></li>
          <li><a href="my_tasks">My tasks</a></li>
          <li><a href="res_task">Resolve task</a></li>
          <li class="tab_selected"><a href="view_r_tasks">View resolved tasks</a></li>
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
            <h1>Latest News</h1>
            <h4>New Website Launched</h4>
            <p>We've redesigned our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
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
          <br/>
          <c:if test="${empty loggedInUser.resolvedTaskList}">
            You don't have any resolved tasks
          </c:if>
          <c:if test="${ not empty loggedInUser.resolvedTaskList}">
            <table id="myTable" class="table table-hover">
              <thead>
              <tr>
                <th>#Task ID</th>
                <th>Dificulty Level</th>
                <th>Owner</th>
                <th>Date Solved</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="task" items="${loggedInUser.resolvedTaskList}">
                <tr>
                  <td>${task.taskId}</td>
                  <td>${task.dificultyLevel}</td>
                  <c:choose>
                    <c:when test="${empty task.owner }" >
                      <td>None</td>
                    </c:when>
                    <c:otherwise>
                      <td>${task.owner.username}</td>
                    </c:otherwise>
                  </c:choose>
                  <c:choose>
                    <c:when test="${empty task.dateSolved }" >
                      <td>-</td>
                    </c:when>
                    <c:otherwise>
                        <td>${task.dateSolved}</td>
                    </c:otherwise>
                  </c:choose>
                </tr>

              </c:forEach>
              </tbody>
            </table>
          </c:if>
          <br/>
        </div>
        <div id="content_base"></div>
      </div>
    </div>
    <div id="footer">Copyright &copy; Company Name. All Rights Reserved. | <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a href="http://www.dcarter.co.uk">dcarter website templates</a></div>
  </div>

</body>
</html>
