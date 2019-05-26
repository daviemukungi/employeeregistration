<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Davie
  Date: 5/26/2019
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <title>Employee Lists</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>


    <div class="panel">
        <!-- Default panel contents -->
        <div class="panel-heading" style="align-content: center"><span class="lead">LIST OF EMPLOYEE </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th><span class="small">FIRST NAME: </span></th>
                    <th>MIDDLE NAME</th>
                    <th>SURNAME</th>
                    <th>DOB</th>
                    <th>ADDRESS</th>
                    <th>CONTRACT TYPE</th>
                    <th>CONTRACT SIGN DATE</th>
                    <th>Work ID</th>
                    <th>ACTION</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                             <td></td>
                             <td>${employee.name}</td>
                             <td>${employee.middle}</td>
                             <td>${employee.surname}</td>
                             <td>${employee.joiningDate}</td>
                             <td>${employee.address}</td>
                             <td>${employee.contracttype}</td>
                             <td>${employee.contractSignDate}</td>
                            <td><a href="<c:url value='/edit-${employee.employmentnumber}-employee' />">${employee.employmentnumber}</a></td>
                            <td><a href="<c:url value='/delete-${employee.employmentnumber}-employee' />">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

<br/>
<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>