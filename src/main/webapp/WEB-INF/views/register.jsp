<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="start" class="container">
    <div class="row">
        <c:if test="${param.registered eq true}">
            <div id="register-info" class="alert alert-success">
                <spring:message code="page.register.registrationSuccessful"/>
                <a data-toggle="modal" data-target="#loginModal"><spring:message code="page.register.login"/></a>
            </div>
        </c:if>
    </div>
</div>

<div class="form-register">
    <div class="panel panel-success">
        <div class="panel-heading"><spring:message code="page.register.header.title"/></div>
        <div class="panel-body">
            <form:form commandName="aUser" cssClass="registrationForm">
                <div id="register-data" class="container">
                    <div class="form-group">
                        <label for="name" class=""><spring:message code="page.register.name"/></label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <label for="email" class=""><spring:message code="page.register.email"/></label>
                        <form:input path="email" cssClass="form-control"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="form-group">
                        <label for="password" class=""><spring:message
                                code="page.register.password"/></label>
                        <form:password path="password" id="chpw" name="chpw" cssClass="form-control"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="form-group">
                        <label for="chpw2" class=""><spring:message
                                code="page.register.confirmPassword"/></label>
                        <input type="password" id="chpw2" name="chpw2" class="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-default"><spring:message
                            code="page.register.submit"/></button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".registrationForm").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3,
                            remote: {
                                url: "<spring:url value='/register/is-available' />",
                                type: "get",
                                data: {
                                    username: function () {
                                        return $("#name").val();
                                    }
                                }
                            }
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        chpw: {
                            required: true,
                            minlength: 5
                        },
                        chpw2: {
                            required: true,
                            minlength: 5,
                            equalTo: "#chpw"
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    },
                    messages: {
                        name: {
                            remote: "Such username already exists!"
                        }
                    }
                }
        );
    });
</script>