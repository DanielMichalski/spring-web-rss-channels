<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="<spring:url value="resources/css/style.css"/>"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<tilesx:useAttribute name="current"/>
<div class="container">

    <!-- Static navbar -->
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
                        <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users"/>">Users</a>
                    </security:authorize>
                    <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value="/register"/>">Register</a>
                    <security:authorize access="!isAuthenticated()">
                        <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login"/>">Login</a></li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account"/>">My account</a>
                         <li><a href="<spring:url value="/logout"/>">Logout</a></li>
                    </security:authorize>
                </ul>
            </div>
        </div>
    </nav>
    <tiles:insertAttribute name="body"/>
</div>
    <tiles:insertAttribute name="footer"/>
</body>
</html>
