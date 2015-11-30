<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        })
    });
</script>

<div id="start" class="container">
    <div class="row">
        <h1>${user.name}</h1>
        <br/><br/>

        <!-- Nav tabs -->
        <ul class="nav nav-tabs">
            <c:forEach items="${user.blogEntities}" var="blog">
                <li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a></li>
            </c:forEach>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <c:forEach items="${user.blogEntities}" var="blog">
                <div class="tab-pane" id="blog_${blog.id}">
                    <h1>${blog.name}</h1>

                    <p>
                        <a href="<spring:url value="/blog/remove/${blog.id}"/>" class="btn btn-danger triggerRemove">Remove</a>
                            ${blog.url}
                    </p>

                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th>Title</th>
                            <th>Link</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${blog.itemEntities}" var="item">
                            <tr>
                                <td>${item.title}</td>
                                <td>${item.link}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- Modal window -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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

