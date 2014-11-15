<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form:form commandName="user" cssClass="form-horizonal form-register">
    <div class="form-register">
        <c:if test="${param.success eq true}">
            <div class="alert alert-success">Registration successfull!</div>
        </c:if>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name:</label>

            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email:</label>

            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password:</label>

            <div class="col-sm-10">
                <form:password path="password" cssClass="form-control"/>
                <form:errors path="password"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-2">
                <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
            </div>
        </div>
    </div>
</form:form>