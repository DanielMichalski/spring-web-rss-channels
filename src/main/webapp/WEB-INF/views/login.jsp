<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="start" class="form-login">
    <div class="panel panel-success">
        <div class="panel-heading">
            <spring:message code="page.login.header.title"/>
        </div>
        <div class="panel-body">
            <form class="form-signin" role="form" method="POST"
                  action="<spring:url value="/j_spring_security_check"/>">
                <label for="j_username"><spring:message code="page.login.login"/></label>
                <input type="text" id="j_username" name="j_username" class="form-control"
                       placeholder="<spring:message code="page.login.login"/>" required autofocus>
                <label for="j_password"><spring:message code="page.login.password"/></label>
                <input type="password" id="j_password" name="j_password" class="form-control"
                       placeholder="<spring:message code="page.login.password"/>" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    <spring:message code="page.login.buttonSubmit"/>
                </button>
            </form>
        </div>
    </div>
</div>