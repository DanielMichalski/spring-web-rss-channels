<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="menu" class="menu-right">
    <ul>
        <form class="menu-search">
            <div class="form-group header">
                <i class="icon-search searchico"></i>
                <input type="text" placeholder="Blog Search">
                <a href="#" class="close-menu"><i class="icon-close"></i></a>
            </div>
        </form>
        <li><a href="<spring:url value="/"/>"><i class="icon-lime"></i>
            <spring:message code="page.header.right.home"/>
        </a></li>
        <security:authorize access="!isAuthenticated()">
            <li><a href="<spring:url value="/register"/>"><i class="glyphicon-user"></i>
                <spring:message code="page.header.right.register"/>
            </a></li>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="<spring:url value="/admin/users"/>"><i class="icon-user"></i>
                <spring:message code="page.header.right.users"/>
            </a></li>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <li><a href="<spring:url value="/account"/>"><i class="icon-menu2"></i>
                <spring:message code="page.header.right.myAccount"/>
            </a></li>
        </security:authorize>
        <li><a href="<spring:url value="/contact"/>"><i class="icon-envelope"></i>
            <spring:message code="page.header.right.contact"/>
        </a></li>
        <li><a href="#" data-toggle="modal" data-target="#changeLanguageModal"><i class="icon-envelope"></i>
            <spring:message code="page.header.right.changeLanguage"/>
        </a></li>
        <li class="submenu">
            <a href="#"><i class="icon-books"></i><spring:message code="page.header.right.changeLanguage"/>
                <b class="caret"></b></a>
            <ul class="submenu-list">
                <li><a href="?lang=pl">Polish<span class="badge">1</span></a></li>
                <li><a href="?lang=en">English <span class="badge golden">2</span></a></li>
            </ul>
        </li>
    </ul>
</div>

<div id="wrap">
    <div id="main-nav" class="">
        <div class="container">
            <div class="nav-header">
                <a class="nav-brand" href="<spring:url value="/"/>"><i class="icon-lime"></i>
                    <spring:message code="page.header.appTitle"/>
                </a>
                <a class="menu-link nav-icon" href="#"><i class="icon-menu2"></i></a>
                <security:authorize access="isAuthenticated()">
                    <a class="btn btn-blog outline-white pull-right" href="<spring:url value="/logout"/>">
                        <spring:message code="page.header.logout"/>
                    </a>
                </security:authorize>
                <security:authorize access="!isAuthenticated()">
                    <a class="btn btn-blog outline-white pull-right" href="<spring:url value="/register"/>">
                        <spring:message code="page.header.register"/>
                    </a>
                    <a class="btn btn-blog outline-white pull-right" href="#" data-toggle="modal"
                       data-target="#loginModal">
                        <spring:message code="page.header.login"/>
                    </a>
                </security:authorize>
            </div>
        </div>
    </div>

    <section id="hero" class="light-typo">
        <div id="cover-image" class="image-bg animated fadeIn"></div>
        <div class="container welcome-content">
            <div class="middle-text">
                <h1><spring:message code="page.header.header1Text"/></h1>
                <h2><spring:message code="page.header.header2Text"/></h2>
                <a class="btn smooth-scroll" href="#start">
                    <spring:message code="page.header.startBtnLbl"/>
                </a>
            </div>
        </div>
    </section>

