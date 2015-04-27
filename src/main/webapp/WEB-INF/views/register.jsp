<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="start" class="container">
    <div class="row">
        <h1><spring:message code="page.register.header.title"/></h1>

        <form:form commandName="aUser">

        </form:form>
    </div>
</div>


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