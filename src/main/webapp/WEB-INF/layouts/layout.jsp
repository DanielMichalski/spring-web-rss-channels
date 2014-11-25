<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/3.1.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/3.1.1/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/3.1.1/css/style.css"/>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery.validate/1.13.1/jquery.validate.min.js"></script>
</head>

<body>
    <tilesx:useAttribute name="current"/>
    <div class="container">
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer"/>
    </div>
</body>
</html>
