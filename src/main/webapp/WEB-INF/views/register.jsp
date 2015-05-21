<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="start" class="container">
    <div class="row">
        <h1><spring:message code="page.register.header.title"/></h1>

        <c:if test="${param.registered eq true}">
            <div class="alert alert-success">
                <spring:message code="page.register.registrationSuccessful"/>
                <a data-toggle="modal" data-target="#loginModal"><spring:message code="page.register.login"/></a>
            </div>
        </c:if>
    </div>
</div>

<form:form commandName="aUser">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <div class="col-md-4 column">
                    </div>
                    <div class="col-md-4 column">
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
                            <label for="password" class=""><spring:message code="page.register.password"/></label>
                            <form:password path="password" cssClass="form-control"/>
                            <form:errors path="password"/>
                        </div>
                        <button type="submit" class="btn btn-default"><spring:message code="page.register.submit"/></button>
                    </div>
                    <div class="col-md-4 column">
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>

<script type="text/javascript">
    $(document).ready(function () {
        $(".form-register").validate(
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
                        password: {
                            required: true,
                            minlength: 5
                        },
                        password_again: {
                            required: true,
                            minlength: 5,
                            equalTo: "#password"
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
        )
    });
</script>