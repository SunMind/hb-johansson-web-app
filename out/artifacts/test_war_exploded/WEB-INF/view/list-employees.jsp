<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Viliu
  Date: 7/31/2020
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>

    <!--reference stylesheet-->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
           <!--use proper app name-->
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2 style="color: black">Employees Manager</h2>
    </div>
</div>


<div id="container">

    <div id="content">

        <!-- put new button: Add Employee-->
        <input type="button" value="Add Employee"
               onclick="window.location.href='showFormForAdd';return false;"
               class="add-button"
        />
        <!--class - css style -->
        <!--showFormForAdd  - call spring Controller mapping-->

        <!--  add html table here-->
        <table>
            <tr>
                <!--Table headings-->
                <th>First Name</th>
                <th>Last Name</th>
                <th>Personal ID</th>
                <th>Email</th>
                <th>Phone Number</th>
            </tr>

            <!--loop over and print employees-->
            <!--employee is added atribute in model, EmployeeController class-->
            <c:forEach var="tempEmployee" items="${employees}">

                <!--tr - table row-->
                <!--construct an "update" link with employee id-->
                <c:url var="updateLink" value="/employee/showFormForUpdate">
                    <c:param name="employeeId" value="${tempEmployee.personId}"/>
                </c:url>

                <!--construct an "delete" link with employee id-->
                <c:url var="deleteLink" value="/employee/delete">
                    <c:param name="employeeId" value="${tempEmployee.personId}"/>
                </c:url>

                <!--"hours table" link with employee id-->
                <c:url var="hoursTableLink" value="/employee/hoursTable">
                    <c:param name="employeeId" value="${tempEmployee.personId}"/>
                </c:url>

                <tr>
                    <!--td - table data-->
                    <td>${tempEmployee.firstName}</td>
                    <td>${tempEmployee.lastName}</td>
                    <td>${tempEmployee.personId}</td>
                    <td>${tempEmployee.email}</td>
                    <td>${tempEmployee.phoneNumber}</td>
                    <td>
                        <!-- display the update link-->
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
                        |
                        <a href="${hoursTableLink}">Hours Table</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>
</div>

</body>
</html>
