<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <title>Employee Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>


    <div class="panel">
        <div class="panel-heading"> <span class="lead"> Registration </span></div>

        <form:form method="POST" modelAttribute="employee">
            <form:input type="hidden" path="id" id="id"/>

            <table>
                <tr>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="name">First Name</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                                    <div class="has-error">
                                        <form:errors path="name" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="middle"> MIDDLE: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="middle" id="middle" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="middle" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="Surname"> SURNAME: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="Surname" id="Surname" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="Surname" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="joiningDate"> Date Of Birth:</label>
                            <div class="col-md-7">
                                <form:input type="text" path="joiningDate" id="joiningDate" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="joiningDate" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="employmentnumber"> Work Id: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="employmentnumber" id="employmentnumber" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="employmentnumber" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="address"> ADDRESS: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="address" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="contracttype"> CONTRACT TYPE: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="contracttype" id="contracttype" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="contracttype" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="contractSignDate"> CONTRACT SIGN DATE: </label>
                            <div class="col-md-7">
                                <form:input type="text" path="contractSignDate" id="contractSignDate" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="contractSignDate" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
                <tr>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Update"/>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Register"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
<br/>
<br/>
Go back to <a href="<c:url value='/list' />">List of All Employees</a>



</body>
</html>