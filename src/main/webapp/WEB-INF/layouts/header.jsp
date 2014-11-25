<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"/>'>Home</a></li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="${current == 'users' ? 'active' : ''}"><a
                            href="<spring:url value="/admin/users"/>">Users</a></li>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="${current == 'register' ? 'active' : ''}"><a
                        href="<spring:url value="/register"/>">Register</a></li>
                <security:authorize access="!isAuthenticated()">
                    <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login"/>">Login</a>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account"/>">My
                        account</a></li>
                    <li><a href="<spring:url value="/logout"/>">Logout</a></li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>