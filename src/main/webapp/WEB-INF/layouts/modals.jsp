<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<!-- Change language Modal -->
<div class="modal fade" id="changeLanguageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">
          <spring:message code="page.header.changeLanguage.title"/>
        </h4>
      </div>
      <div class="modal-body">
        <a href="?lang=pl"><img src="${pageContext.servletContext.contextPath}/resources/img/flags/poland.gif" alt="Poland"></a>
        <a href="?lang=en"><img src="${pageContext.servletContext.contextPath}/resources/img/flags/england.gif" alt="England"></a>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
          <spring:message code="page.header.changeLanguage.btnCloseLbl"/>
        </button>
      </div>
    </div>
  </div>
</div>

<!-- Remove channel modal -->
<div class="modal fade" id="removeChannel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                class="sr-only">Close</span></button>
        <h4 class="modal-title">RemoveBlog</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

<!-- Login modal -->
<div class="modal fade login" id="loginModal" aria-hidden="true">
  <div class="modal-dialog login">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title"><spring:message code="page.login.modal.title"/></h4>
      </div>
      <div class="modal-body">
        <div class="box">
          <div class="form loginBox">
            <form class="myform" method="post" action="<spring:url value="/j_spring_security_check"/>" accept-charset="UTF-8">
              <div class="form-group">
                <div class="controls">
                  <input id="login" class="form-control" type="text"
                         placeholder="<spring:message code="page.login.modal.login"/>" name="j_username" required="true">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label">password</label>
                <div class="controls">
                  <input id="password" class="form-control" type="password"
                         placeholder="<spring:message code="page.login.modal.password"/>" name="j_password" required="true">
                </div>
              </div>
              <input class="btn btn-block" type="submit" value="<spring:message code="page.login.modal.title"/>" >
            </form>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <div class="forgot login-footer">
                    <span><spring:message code="page.login.modal.createAccount1"/>
                        <a href="<spring:url value="/register"/>"><spring:message code="page.login.modal.createAccount2"/></a>?</span>
        </div>
      </div>
    </div>
  </div>
</div>