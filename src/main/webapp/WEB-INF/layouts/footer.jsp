<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>

<footer>
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-md-4 footer-widget">
                    <h3><string:message code="page.footer.left.statistics"/></h3>

                    <span><string:message code="page.footer.left.text"/></span>

                    <div class="stats">
                        <div class="line">
                            <span class="counter">27</span>
                            <span class="caption"><string:message code="page.footer.left.articles"/></span>
                        </div>
                        <div class="line">
                            <span class="counter">208</span>
                            <span class="caption"><string:message code="page.footer.left.comments"/></span>
                        </div>
                        <div class="line">
                            <span class="counter">2</span>
                            <span class="caption"><string:message code="page.footer.left.authors"/></span>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 footer-widget">
                    <h3><string:message code="page.footer.center.posts"/></h3>

                    <div class="post-recent-widget">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg" width="80" alt=""></a>

                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="post-video.html">
                                            <string:message code="page.footer.center.text1"/></a></h4>
                                        <p class="post-date">may 10, 2014</p>
                                    </div>
                                </div>
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg" width="80" alt=""></a>

                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="post-typography.html"><string:message
                                                code="page.footer.center.text2"/></a></h4>
                                        <p class="post-date">september 27, 2014</p>
                                    </div>
                                </div>
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object"src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg" width="80" alt=""></a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="post-image.html"><string:message
                                                code="page.footer.center.text3"/></a></h4>

                                        <p class="post-date">april 2, 2014</p>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 footer-widget clearfix">
                    <h3><string:message code="page.footer.right.tags"/></h3>
                    <ul class="tags">
                        <li><a href="#">OpenPGP</a></li>
                        <li><a href="#">Django</a></li>
                        <li><a href="#">Bitcoin</a></li>
                        <li><a href="#">Security</a></li>
                        <li><a href="#">GNU/Linux</a></li>
                        <li><a href="#">Git</a></li>
                        <li><a href="#">Homebrew</a></li>
                        <li><a href="#">Debian</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="container">
            <p class="pull-left">RSS Reader</p>
            <ul class="social-links pull-right">
                <li><a href="https://twitter.com/d__michalski"><i class="icon-twitter"></i></a></li>
                <li><a href="https://www.facebook.com/daniel.michalski.142"><i class="icon-facebook"></i></a></li>
                <li><a href="https://plus.google.com/u/0/106191107038382924525/posts"><i
                        class="icon-googleplus"></i></a></li>
            </ul>
        </div>
    </div>
</footer>

</div>