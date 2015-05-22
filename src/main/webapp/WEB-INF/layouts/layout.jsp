<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <c:set var="titleKey">
        <tiles:insertAttribute name="title" ignore="true" />
    </c:set>
    <title><spring:message code="${titleKey}"/></title>
    <meta charset="utf-8">
    <meta name="description" content="Key Lime Responsive HTML5/CSS3 Template from angelostudio.net">
    <meta name="author" content="ANGELOSTUDIO.NET">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,700|Merriweather:400,400italic,700italic"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/own-style.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/icons.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/animate.min.css"/>
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/img/ico/32.png" sizes="32x32" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" href="${pageContext.servletContext.contextPath}/resources/img/ico/60.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.servletContext.contextPath}/resources/img/ico/72.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="120x120" href="${pageContext.servletContext.contextPath}/resources/img/ico/120.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" sizes="152x152" href="${pageContext.servletContext.contextPath}/resources/img/ico/152.png" type="image/png"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="home">
    <tilesx:useAttribute name="current"/>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>

    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/placeholders.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
</body>
</html>
