<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--<nav class="navbar navbar-default" role="navigation">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
                    <%--aria-expanded="false" aria-controls="navbar">--%>
                <%--<span class="sr-only">Toggle navigation</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<a class="navbar-brand" href='<spring:url value="/"/>'>JBA</a>--%>
        <%--</div>--%>
        <%--<div id="navbar" class="navbar-collapse collapse">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"/>'>Home</a></li>--%>
                <%--<security:authorize access="hasRole('ROLE_ADMIN')">--%>
                    <%--<li class="${current == 'users' ? 'active' : ''}"><a--%>
                            <%--href="<spring:url value="/admin/users"/>">Users</a></li>--%>
                <%--</security:authorize>--%>
            <%--</ul>--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li class="${current == 'register' ? 'active' : ''}"><a--%>
                        <%--href="<spring:url value="/register"/>">Register</a></li>--%>
                <%--<security:authorize access="!isAuthenticated()">--%>
                    <%--<li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login"/>">Login</a>--%>
                    <%--</li>--%>
                <%--</security:authorize>--%>
                <%--<security:authorize access="isAuthenticated()">--%>
                    <%--<li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account"/>">My--%>
                        <%--account</a></li>--%>
                    <%--<li><a href="<spring:url value="/logout"/>">Logout</a></li>--%>
                <%--</security:authorize>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>


<%--<div id="menu" class="menu-right">--%>
    <%--<ul>--%>
        <%--<form class="menu-search" >--%>
            <%--<div class="form-group header">--%>
                <%--<i class="icon-search searchico"></i>--%>
                <%--<input type="text" placeholder="Blog Search">--%>
                <%--<a href="#" class="close-menu"><i class="icon-close"></i></a>--%>
            <%--</div>--%>
        <%--</form>--%>
        <%--<li><a href="index.html"><i class="icon-lime"></i>Home</a></li>--%>
        <%--<li><a href="about.html"><i class="icon-user"></i>About</a></li>--%>
        <%--<li class="submenu">--%>
            <%--<a href="#"><i class="icon-books"></i>Categories<b class="caret"></b></a>--%>
            <%--<ul class="submenu-list">--%>
                <%--<li><a href="category.html">Blogroll <span class="badge golden">2</span></a></li>--%>
                <%--<li><a href="category.html">Quotes<span class="badge">4</span></a></li>--%>
                <%--<li><a href="category.html">Travel<span class="badge red">12</span></a></li>--%>
                <%--<li><a href="category.html">Writing<span class="badge blue">7</span></a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li class="submenu submenu-open">--%>
            <%--<a href="#"><i class="icon-file"></i>Pages<b class="caret"></b></a>--%>
            <%--<ul class="submenu-list">--%>
                <%--<li><a href="post-image.html">Post Image</a></li>--%>
                <%--<li><a href="post-audio.html">Post Audio</a></li>--%>
                <%--<li><a href="post-video.html">Post Video</a></li>--%>
                <%--<li><a href="post-typography.html">Typography</a></li>--%>
                <%--<li><a href="author.html">Author</a></li>--%>
                <%--<li><a href="search.html">Search</a></li>--%>
                <%--<li><a href="404.html">404 Error</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li class="submenu">--%>
            <%--<a href="#"><i class="icon-calendar"></i>Archives <b class="caret"></b></a>--%>
            <%--<ul class="submenu-list">--%>
                <%--<li><a href="archives.html">June<span>2014</span></a></li>--%>
                <%--<li><a href="archives.html">May<span>2014</span></a></li>--%>
                <%--<li><a href="archives.html">January<span>2014</span></a></li>--%>
                <%--<li><a href="archives.html">October<span>2013</span></a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="contact.html"><i class="icon-envelope"></i>Contact</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>
<%--<div id="wrap">--%>
    <%--<div id="main-nav" class="">--%>
        <%--<div class="container">--%>
            <%--<div class="nav-header">--%>
                <%--<a class="nav-brand" href="index.html"><i class="icon-lime"></i>RSS Reader</a>--%>
                <%--<a class="menu-link nav-icon" href="#"><i class="icon-menu2"></i></a>--%>
                <%--<a class="btn btn-blog outline-white pull-right" href="#" data-toggle="modal" data-target="#loginModal">Zaloguj</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<section id="hero" class="light-typo">--%>
        <%--<div id="cover-image" class="image-bg animated fadeIn"></div>--%>
        <%--<div class="container welcome-content">--%>
            <%--<div class="middle-text">--%>
                <%--<h1>Najnowsze wiadomości ze świata</h1>--%>
                <%--<h2><b>RSS Reader</b> jest witryną, która wyświetla wiadomości </h2>--%>
                <%--<a class="btn smooth-scroll" href="#start">Zaczynamy</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</section>--%>

<div id="menu" class="menu-right">
    <ul>
        <form class="menu-search" >
            <div class="form-group header">
                <i class="icon-search searchico"></i>
                <input type="text" placeholder="Blog Search">
                <a href="#" class="close-menu"><i class="icon-close"></i></a>
            </div>
        </form>
        <li><a href="index.html"><i class="icon-lime"></i>Home</a></li>
        <li><a href="about.html"><i class="icon-user"></i>About</a></li>
        <li class="submenu">
            <a href="#"><i class="icon-books"></i>Categories<b class="caret"></b></a>
            <ul class="submenu-list">
                <li><a href="category.html">Blogroll <span class="badge golden">2</span></a></li>
                <li><a href="category.html">Quotes<span class="badge">4</span></a></li>
                <li><a href="category.html">Travel<span class="badge red">12</span></a></li>
                <li><a href="category.html">Writing<span class="badge blue">7</span></a></li>
            </ul>
        </li>
        <li class="submenu submenu-open">
            <a href="#"><i class="icon-file"></i>Pages<b class="caret"></b></a>
            <ul class="submenu-list">
                <li><a href="post-image.html">Post Image</a></li>
                <li><a href="post-audio.html">Post Audio</a></li>
                <li><a href="post-video.html">Post Video</a></li>
                <li><a href="post-typography.html">Typography</a></li>
                <li><a href="author.html">Author</a></li>
                <li><a href="search.html">Search</a></li>
                <li><a href="404.html">404 Error</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#"><i class="icon-calendar"></i>Archives <b class="caret"></b></a>
            <ul class="submenu-list">
                <li><a href="archives.html">June<span>2014</span></a></li>
                <li><a href="archives.html">May<span>2014</span></a></li>
                <li><a href="archives.html">January<span>2014</span></a></li>
                <li><a href="archives.html">October<span>2013</span></a></li>
            </ul>
        </li>
        <li><a href="contact.html"><i class="icon-envelope"></i>Contact</a></li>
    </ul>
</div>

<div id="wrap">
    <div id="main-nav" class="">
        <div class="container">
            <div class="nav-header">
                <a class="nav-brand" href="index.html"><i class="icon-lime"></i>RSS Reader</a>
                <a class="menu-link nav-icon" href="#"><i class="icon-menu2"></i></a>
                <a class="btn btn-blog outline-white pull-right" href="#" data-toggle="modal" data-target="#loginModal">Zaloguj</a>
            </div>
        </div>
    </div>

    <section id="hero" class="light-typo">
        <div id="cover-image" class="image-bg animated fadeIn"></div>
        <div class="container welcome-content">
            <div class="middle-text">
                <h1>Najnowsze wiadomości ze świata</h1>
                <h2><b>RSS Reader</b> jest witryną, która wyświetla wiadomości </h2>
                <a class="btn smooth-scroll" href="#start">Zaczynamy</a>
            </div>
        </div>
    </section>