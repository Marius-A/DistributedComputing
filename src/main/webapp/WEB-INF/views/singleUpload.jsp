<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Single File Upload</h1>
<sf:form method="POST" modelAttribute="code"
         action="./add_task?${_csrf.parameterName}=${_csrf.token}"
         enctype="multipart/form-data">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <th><label >Image (in JPEG format only):</label></th>
                <td><input name="code" type="file" accept=".js"/>
            </tr>
            <tr>
                <th><input type="Submit" value="Submit"/></th>
                <td></td>
            </tr>
        </table>
    </fieldset>
</sf:form>
</body>
</html>