<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<h1>Latest news from the Java world:</h1>--%>

<%--<table class="table table-bordered table-hover table-striped">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>Name</th>--%>
        <%--<th>Date</th>--%>
        <%--<th>Item</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<c:forEach items="${items}" var="item">--%>
        <%--<tr>--%>
            <%--<td class="col-md-1">--%>
                <%--<c:out value="${item.rssFeedEntity.name}"/>--%>
            <%--</td>--%>
            <%--<td class="col-md-1">--%>
                <%--<c:out value="${item.publishedDate}"/>--%>
            <%--</td>--%>
            <%--<td class="col-md-10">--%>
                <%--<strong>--%>
                    <%--<a href="<c:out value="${item.link}"/>" target="_blank">--%>
                        <%--<c:out value="${item.title}"/>--%>
                    <%--</a>--%>
                <%--</strong>--%>
                <%--<br/>--%>
                    <%--${item.description}--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>





    <div id="start" class="container content">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <article class="clearfix">
                    <div class="post-date">
                        26 listopad 2014 <span><a href="">11 komentarzy</a></span>
                    </div>
                    <h2><a href="post-typography.html">Jeżeli uda się zgromadzić poparcie lewicy, będę gotowy wystartować</a></h2>
                    <p>Leszek Miller zaproponował, by Ryszard Kalisz został kandydatem SLD w przyszłorocznych wyborach prezydenckich. -
                        Jeżeli się uda zgromadzić poparcie lewicy od alternatywnej po liberalną, wtedy będę gotowy wystartować - zadeklarował
                        na antenie TVN24 Ryszard Kalisz.
                        <a class="" href="post-typography.html">Czytaj całość</a>
                    </p>
                </article>
                <article class="clearfix">
                    <div class="post-date">
                        24 listopad 2014<span><a href="">42 komentarze</a></span>
                    </div>
                    <h2><a href="post-image.html">"Fakty po Faktach" o kandydaturze Kalisza na prezydenta RP</a></h2>
                    <p>Na dzisiejszym posiedzeniu Rady Krajowej SLD Leszek Miller zgłosił kandydaturę byłego polityka Sojuszu
                        Ryszarda Kalisza na prezydenta, ale ostatecznie ustalono, że kandydat zostanie wskazany na konwencji SLD na
                        przełomie stycznia i lutego.
                        <a class="" href="post-image.html">Czytaj całość</a>
                    </p>
                </article>
                <article class="clearfix">
                    <div class="post-date">
                        20 listopad 2014 <span><a href="">2 komentarze</a></span>
                    </div>
                    <h2><a href="post-audio.html">Rosja udusi Ukrainę? "Tranzyt zostanie sprowadzony do zera"</a></h2>
                    <p> Prezes Gazpromu Aleksiej Miller oświadczył w sobotę, że po ułożeniu nowego gazociągu z Rosji przez Morze Czarne do Turcji,
                        rola Ukrainy jako kraju tranzytowego przy dostawach rosyjskiego gazu do Europy "zostanie sprowadzona do zera".
                        <a class="" href="post-audio.html">Czytaj całość</a>
                    </p>
                </article>
                <article class="clearfix last">
                    <div class="post-date">
                        18 listopad 2014 <span><a href="">23 komentarzy</a></span>
                    </div>
                    <h2><a href="post-video.html">"Mieszkańcy ugasili jednego z mężczyzn"</a></h2>
                    <p>Dwie osoby zostały ranne w wybuchu na stacji kontroli pojazdów w Zabrzu (woj. śląskie). Jak poinformowała nas policja,
                        do eksplozji doszło w trakcie wymiany instalacji gazowej w samochodzie.
                        <a class="" href="post-video.html">Czytaj całość</a>
                    </p>
                </article>

                <div class="post-popular">
                    <div class="row hidden-xs">
                        <div class="col-sm-4 col-md-4">
                            <a href="post-video.html"><img src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg" class="img-responsive" alt="img2"></a>
                            <h4 class="text-center"><a href="post-video.html">But I've never been to the moon!</a></h4>
                            <p class="post-date text-center">MAY 10, 2014</p>
                        </div>
                        <div class="col-sm-4 col-md-4">
                            <a href="post-typography.html"><img  src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg" class="img-responsive" alt="img1"></a>
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
        </div><!-- end row -->
    </div>
    <footer>
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-md-4 footer-widget">
                        <h3>Statistics</h3>

                        <span>We can't compete with Mom! Her company is big and evil! </span>

                        <div class="stats">
                            <div class="line">
                                <span class="counter">27</span>
                                <span class="caption">Articles</span>
                            </div>
                            <div class="line">
                                <span class="counter">208</span>
                                <span class="caption">Comments</span>
                            </div>
                            <div class="line">
                                <span class="counter">2</span>
                                <span class="caption">Authors</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 footer-widget">
                        <h3>Recent posts</h3>
                        <div class="post-recent-widget">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="media">
                                        <a class="pull-left" href="post-video.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img2.jpg" width="80" alt=""></a>
                                        <div class="media-body">
                                            <h4 class="media-heading"><a href="post-video.html">But I've never been to the moon!</a></h4>
                                            <p class="post-date">may 10, 2014</p>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <a class="pull-left" href="post-typography.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img1.jpg" width="80" alt=""></a>
                                        <div class="media-body">
                                            <h4 class="media-heading"><a href="post-typography.html">We don't have a brig</a></h4>
                                            <p class="post-date">september 27, 2014</p>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <a class="pull-left" href="post-image.html"><img class="media-object" src="${pageContext.servletContext.contextPath}/resources/img/img3.jpg" width="80" alt=""></a>
                                        <div class="media-body">
                                            <h4 class="media-heading"><a href="post-image.html">Every other day it's food, food, food.</a></h4>
                                            <p class="post-date">april 2, 2014</p>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 footer-widget clearfix">
                        <h3>Tagi</h3>
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
                    <li><a href="#link"><i class="icon-twitter"></i></a></li>
                    <li><a href="#link"><i class="icon-facebook"></i></a></li>
                    <li><a href="#link"><i class="icon-googleplus"></i></a></li>
                </ul>
            </div>
        </div>
    </footer>
</div>

<div class="modal fade login" id="loginModal" aria-hidden="true">
    <div class="modal-dialog login">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">Logowanie</h4>
            </div>
            <div class="modal-body">
                <div class="box">
                    <div class="form loginBox">
                        <form class="myform" method="post" action="/login" accept-charset="UTF-8">
                            <div class="form-group">
                                <label class="control-label">Email</label>
                                <div class="controls">
                                    <input id="email" class="form-control" type="text" placeholder="E-mail" name="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label">password</label>
                                <div class="controls">
                                    <input id="password" class="form-control" type="password" placeholder="Hasło" name="password">
                                </div>
                            </div>
                            <p class="text-center"><a href="">Zapomniałeś hasła?</a></p>
                            <input class="btn btn-block" type="button" value="Zaloguj" >
                        </form>
                    </div>
                </div>
            </div>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/placeholders.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/wow.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
