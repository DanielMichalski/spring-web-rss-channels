<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="start">
    <div class="form-contact">
        <div class="panel panel-success">
            <div class="panel-heading"><spring:message code="page.contact.header.title"/></div>
            <div class="panel-body">
                <c:choose>
                    <c:when test="${param.sent eq true}">
                        <div id="email-info" class="alert alert-success">
                            <spring:message code="page.contact.mailHasBeenSent"/>
                        </div>
                    </c:when>
                    <c:when test="${param.sent eq false}">
                        <div id="email-info" class="alert alert-danger">
                            <spring:message code="page.contact.mailHasNotBeenSent"/>
                        </div>
                    </c:when>
                </c:choose>
                <form:form commandName="contactForm" class="form-horizontal">
                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label"><spring:message
                                code="page.contact.name"/></label>

                        <div class="col-sm-8">
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mail" class="col-sm-4 control-label"><spring:message
                                code="page.contact.mail"/></label>

                        <div class="col-sm-8">
                            <form:input path="mail" cssClass="form-control"/>
                            <form:errors path="mail"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="message" class="col-sm-4 control-label"><spring:message
                                code="page.contact.message"/></label>

                        <div class="col-sm-8">
                            <form:textarea path="message" cssClass="form-control" rows="8"/>
                            <form:errors path="message"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <button type="submit" class="btn btn-primary pull-right"><spring:message
                                    code="page.contact.button.send"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
