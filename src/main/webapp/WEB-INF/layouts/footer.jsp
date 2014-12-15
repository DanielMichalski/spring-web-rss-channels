<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

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
            <div class="modal-footer">
                <div class="forgot login-footer">
                    <span>Czy chcesz <a href="#">utworzyć konto</a>?</span>
                </div>
            </div>
        </div>
    </div>
</div>