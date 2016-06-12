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
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainStyle/modal.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainStyle/waitModal.css" />
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
          <li><a href="add_task">Add task</a></li>
          <li><a href="my_tasks">My tasks</a></li>
          <li class="tab_selected"><a href="res_task">Resolve task</a></li>
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
            <c:if test="${empty tlistx}">
                You don't have any task
            </c:if>
            <c:if test="${ not empty tlistx}">
                <table id="myTable" class="table table-hover">
                    <thead>
                    <tr>
                        <th>#Task ID</th>
                        <th>Dificulty Level</th>
                        <th>Status</th>
                        <th>Date added</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="task" items="${tlistx}">
                        <tr>
                            <td>${task.taskId}</td>
                            <td>${task.dificultyLevel}</td>
                            <td>${task.status}</td>
                            <td>${task.dateAdded}</td>

                            <td>
                                <button type="button"
                                        onclick="loadDoc('${contextPath}/resources/uploads/code${task.taskId}.js', myFunction,${task.taskId})"
                                        class = "viewCodeBtn">View Code
                                </button>
                            </td>
                            <td>
                                <button type="button"
                                        onclick="loadDoc('${contextPath}/resources/uploads/code${task.taskId}.js', evalTask,${task.taskId})"
                                        class = "viewCodeBtn">Resolve task
                                </button>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <br/>
            <c:if test="${empty tlisth}">

            </c:if>
            <c:if test="${ not empty tlisth}">
                <h1 id = "toglehead">Complex Tasks</h1>
                <br>
            </c:if>

            <div id = "complextasktable">
                <c:if test="${ not empty tlisth}">
                    <table id="myTable2" class="table table-hover">
                        <thead>
                        <tr>
                            <th>#Task ID</th>
                            <th>Dificulty Level</th>
                            <th>Status</th>
                            <th>Date added</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="task" items="${tlisth}">
                            <tr>
                                <td>${task.taskId}</td>
                                <td>${task.dificultyLevel}</td>
                                <td>${task.status}</td>
                                <td>${task.dateAdded}</td>

                                <td>
                                    <button type="button"
                                            onclick="loadDoc('${contextPath}/resources/uploads/code${task.taskId}.js', myFunction,${task.taskId})"
                                            class = "viewCodeBtn">View Code
                                    </button>
                                </td>
                                <td>
                                    <button type="button"
                                            onclick="loadDoc('${contextPath}/resources/uploads/code${task.taskId}.js', evalTask,${task.taskId})"
                                            class = "viewCodeBtn">Resolve task
                                    </button>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <br/>
            </div>
        </div>
        <div id="content_base"></div>
      </div>
    </div>
    <div id="footer">Copyright &copy; Company Name. All Rights Reserved. | <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a href="http://www.dcarter.co.uk">dcarter website templates</a></div>
  </div>

  <!-- The Modal -->
  <div id="myModal" class="modal">

      <!-- Modal content -->
      <div class="modal-content">
          <div class="modal-header">
              <span class="close">x</span>
              <h3>Code</h3>
          </div>
          <div class="modal-body">
             <textarea id = "codedis" style="resize: none; height: 100%;width: 100%" readonly>
             </textarea>
          </div>

          <div class="modal-footer">
          </div>
      </div>

  </div>

  <div class="waitModal">
      <form id="taskresultform" method="POST" action="${pageContext.request.contextPath}/res_task?${_csrf.parameterName}=${_csrf.token}" >
          <input id= "taskid_i" type="hiden" name="taskid"><br>
          <input id= "taskresult_i" type="hidden" name="result">
      </form>
  </div>

  <div class="modal" id="pleaseWaitDialog">
      <div class="modal-body">
          <h1  style="font-size: 250%; text-align: center">Wait</h1>
          <img src="http://www.aits.ua/images/loading-x.gif" alt="HTML5 Icon" style=" width: 200px; height: 200px; display: block;margin: 0 auto;">
      </div>
  </div>

  <script src="${contextPath}/resources/js/hideTable.js"></script>
  <script src="${contextPath}/resources/js/modal.js"></script>
  <script src="${contextPath}/resources/js/evalTask.js"></script>
</body>
</html>
