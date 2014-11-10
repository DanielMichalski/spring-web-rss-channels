<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>${user.name}</h1>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Add new blog
</button>

<form:form commandName="blog" cssClass="form-horizontal blogForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">New blog</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">URL:</label>
                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control" />
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save" />
                </div>
            </div>
        </div>
    </div>
</form:form>

<c:forEach items="${user.blogs}" var="blog">
    <h1>${blog.name}</h1>

    <h1>${blog.url}</h1>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blog.items}" var="item">
            <tr>
                <td>${item.title}</td>
                <td>${item.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>