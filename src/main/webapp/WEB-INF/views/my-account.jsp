<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#removeChannel .removeBtn").attr("href", $(this).attr("href"));
            $("#removeChannel").modal();
        });
        $(".blogForm").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3
                        },
                        url: {
                            required: true,
                            url: true
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>

<div id="start" class="container">
    <div class="site-body">
        <div class="panel panel-success">
            <div class="panel-heading"><spring:message code="page.myAccount.header.account"/></div>
            <div class="panel-body">
                <div class="row">
                    <div class="channels">
                        <!-- Button trigger modal -->
                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newChannelModal">
                            <spring:message code="page.myAccount.newChannel"/>
                        </button>

                        <div class="space"></div>

                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs">
                            <c:forEach items="${user.blogEntities}" var="blog">
                                <li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a></li>
                            </c:forEach>
                        </ul>

                        <div class="space"></div>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <c:forEach items="${user.blogEntities}" var="blog">
                                <div class="tab-pane" id="blog_${blog.id}">
                                    <h1>${blog.name}</h1>

                                    <p>
                                        <a href="<spring:url value="/blog/remove/${blog.id}"/>"
                                           class="btn btn-danger triggerRemove">Remove</a>
                                            ${blog.url}
                                    </p>

                                    <div class="space"></div>

                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th><spring:message code="page.myAccount.table.date"/></th>
                                            <th><spring:message code="page.myAccount.table.news"/></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${blog.itemEntities}" var="item">
                                            <tr>
                                                <td>${item.publishedDate}</td>
                                                <td>
                                                    <strong>
                                                        <a href="<c:out  value="${item.link}" />" target="_blank">
                                                            <c:out value="${item.title}"/>
                                                        </a>
                                                    </strong>
                                                    <br/>
                                                        ${item.description}
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>

<form:form commandName="blog" cssClass="form-horizontal blogForm">
    <!-- Modal -->
    <div class="modal fade" id="newChannelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel"><spring:message
                            code="page.myAccount.newChannelModal.newChannel"/></h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message
                                code="page.myAccount.newChannelModal.name"/></label>

                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message
                                code="page.myAccount.newChannelModal.url"/></label>

                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control"/>
                            <form:errors path="url"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message
                            code="page.myAccount.newChannelModal.close"/></button>
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message code="page.myAccount.newChannelModal.save"/>"/>
                </div>
            </div>
        </div>
    </div>
</form:form>
