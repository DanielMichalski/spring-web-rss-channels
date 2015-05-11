<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <div id="start" class="container content">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">

                <c:forEach items="${items}" var="item">
                    <article class="clearfix">
                        <div class="post-date">
                            <fmt:formatDate value="${item.publishedDate}" pattern="dd-MM-yyyy HH:mm:ss" />
                            <span><a href="#">11 komentarzy</a></span>
                        </div>
                        <h2>
                            <a href="<c:out value="${item.link}"/>" target="_blank">${item.title}</a>
                        </h2>
                        <p> ${item.description}
                            <a href="<c:out value="${item.link}"/>" target="_blank">Czytaj całość</a>
                        </p>
                    </article>
                </c:forEach>

                <div class="post-popular">
                    <div class="row hidden-xs">
                        <div class="col-sm-4 col-md-4">
                            <a href="post-video.html"><img src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg" class="img-responsive" alt="img2"></a>
                            <h4 class="text-center"><a href="post-video.html">But I've never been to the moon!</a></h4>
                            <p class="post-date text-center">MAY 10, 2014</p>
                        </div>
                        <div class="col-sm-4 col-md-4">
                            <a href="post-typography.html"><img src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg" class="img-responsive" alt="img1"></a>
                            <h4 class="text-center"><a href="post-typography.html">We don't have a brig</a></h4>
                            <p class="post-date text-center">september 27, 2014</p>

                        </div>
                        <div class="col-sm-4 col-md-4">
                            <a href="post-image.html"><img  src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg" class="img-responsive" alt="img3"></a>
                            <h4 class="text-center"><a href="post-image.html">Every other day it's food, food, food.</a></h4>
                            <p class="post-date text-center">april 2, 2014</p>

                        </div>
                    </div>
                    <div class="row visible-xs">
                        <div class="col-sm-12">
                            <div class="media">
                                <a class="pull-left" href="post-video.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg" width="100" alt=""></a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="post-video.html">But I've never been to the moon!</a></h4>
                                    <p class="post-date">may 10, 2014</p>
                                </div>
                            </div>
                            <div class="media">
                                <a class="pull-left" href="post-typography.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg" width="100" alt=""></a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="post-typography.html">We don't have a brig</a></h4>
                                    <p class="post-date">september 27, 2014</p>
                                </div>
                            </div>
                            <div class="media">
                                <a class="pull-left" href="post-image.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg" width="100" alt=""></a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="post-image.html">Every other day it's food, food, food.</a></h4>
                                    <p class="post-date">april 2, 2014</p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="paging clearfix">
                    <a class="btn pull-left" href="#"><i class="icon-arrow-left2 left"></i><span>Older</span><span class="hidden-xs"> Posts</span></a>
                    <a class="btn pull-right" href="#"><span>Newer</span><span class="hidden-xs"> Posts</span><i class="icon-arrow-right2 right"></i></a>
                </div>

            </div>
        </div>
    </div>



