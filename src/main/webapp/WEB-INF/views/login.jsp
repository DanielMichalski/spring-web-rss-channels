<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="start">
    <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check"/>" method="POST">
        <h2 class="form-signin-heading"><spring:message code="page.login.title"/></h2>
        <input type="text" name="j_username" class="form-control"
               placeholder="<spring:message code="page.login.login"/>" required autofocus>
        <input type="password" name="j_password" class="form-control"
               placeholder="<spring:message code="page.login.password"/>" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <spring:message code="page.login.buttonSubmit"/>
        </button>
    </form>
</div>