<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Viliu
  Date: 8/9/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Employee</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Employees Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Employee</h3>

    <form:form action="saveEmployee" modelAttribute="employee" method="POST">

        <!-- need to associate this data with a given employee id-->
        <!--Add the employee id-->
        <!--????-->


        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>

            <tr>
                <td><label>Last Name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>

            <tr>
                <td><label>Personal ID:</label></td>
                <td><form:input path="personId"/></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label>Phone Number:</label></td>
                <td><form:input path="phoneNumber"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>


            </tbody>
        </table>

    </form:form>

    <div style="clear: both"></div>

    <p>
        <a href="${pageContext.request.contextPath}/employee/list">Back To List</a>
    </p>
</div>


</body>
</html>
