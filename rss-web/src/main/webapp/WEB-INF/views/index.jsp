<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>

<div id="start" class="container content">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">

            <c:choose>
                <c:when test="${items == null || items.size() == 0}">
                    <div id="post-alert" class="alert alert-warning" role="alert">
                        <spring:message code="page.index.alert.noMessages"/>
                    </div>
                </c:when>
            </c:choose>
            <c:forEach items="${items}" var="item">
                <article class="clearfix">
                    <div class="post-date">
                        <fmt:formatDate value="${item.publishedDate}" pattern="dd-MM-yyyy HH:mm:ss"/>
                    </div>
                    <h2>
                        <a href="<c:out value="${item.link}"/>" target="_blank">${item.title}</a>
                    </h2>

                    <p> ${item.description}
                        <a href="<c:out value="${item.link}"/>" target="_blank"><spring:message code="page.index.readMore"/></a>
                    </p>
                </article>
            </c:forEach>

            <div class="post-popular">
                <div class="row hidden-xs">
                    <div class="col-sm-4 col-md-4">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg"
                                         class="img-responsive" alt="img2"></a>
                        <h4 class="text-center"><a href="#"><string:message code="page.footer.center.text1"/></a></h4>

                        <p class="post-date text-center">MAY 10, 2014</p>
                    </div>
                    <div class="col-sm-4 col-md-4">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg"
                                         class="img-responsive" alt="img1"></a>
                        <h4 class="text-center"><a href="#"><string:message code="page.footer.center.text2"/></a></h4>

                        <p class="post-date text-center">september 27, 2014</p>

                    </div>
                    <div class="col-sm-4 col-md-4">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg"
                                         class="img-responsive" alt="img3"></a>
                        <h4 class="text-center"><a href="#"><string:message code="page.footer.center.text3"/></a></h4>

                        <p class="post-date text-center">april 2, 2014</p>

                    </div>
                </div>
                <div class="row visible-xs">
                    <div class="col-sm-12">
                        <div class="media">
                            <a class="pull-left" href="#"><img class="media-object"
                                                               src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg"
                                                               width="100" alt=""></a>

                            <div class="media-body">
                                <h4 class="media-heading"><a href="#"><string:message
                                        code="page.footer.center.text1"/></a></h4>

                                <p class="post-date">may 10, 2014</p>
                            </div>
                        </div>
                        <div class="media">
                            <a class="pull-left" href="#"><img class="media-object"
                                                               src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg"
                                                               width="100" alt=""></a>

                            <div class="media-body">
                                <h4 class="media-heading"><a href="#"><string:message
                                        code="page.footer.center.text2"/></a></h4>

                                <p class="post-date">september 27, 2014</p>
                            </div>
                        </div>
                        <div class="media">
                            <a class="pull-left" href="#"><img class="media-object"
                                                               src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg"
                                                               width="100" alt=""></a>

                            <div class="media-body">
                                <h4 class="media-heading"><a href="#"><string:message
                                        code="page.footer.center.text3"/></a></h4>

                                <p class="post-date">april 2, 2014</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="paging clearfix">
                <a class="btn pull-left" href="#"><i class="icon-arrow-left2 left"></i><span><string:message
                        code="page.footer.olderPosts"/></span></a>
                <a class="btn pull-right" href="#"><span><string:message code="page.footer.newerPosts"/></span><i
                        class="icon-arrow-right2 right"></i></a>
            </div>

        </div>
    </div>
</div>



