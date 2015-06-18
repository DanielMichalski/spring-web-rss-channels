<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
    <div class="site-body">
        <div class="panel panel-success">
            <div class="panel-heading"><spring:message code="page.users.header.title"/></div>
            <div class="panel-body">
                <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                        <th><spring:message code="page.users.table.username"/></th>
                        <th><spring:message code="page.users.table.operation"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <security:authentication property="principal.username" var="logged_username"/>
                    <c:forEach items="${usersList}" var="user">
                        <tr>
                            <td>
                                <a href="<spring:url value="/admin/users/${user.id}"/>">
                                        ${user.name}
                                </a>
                            </td>
                            <td>
                                <a <c:if test="${user.name.equals(logged_username)}"> disabled="true" </c:if>
                                        href="<spring:url value="/admin/users/remove-user/${user.id}"/>"
                                        class="btn btn-danger triggerRemove">
                                    <spring:message code="page.users.table.delete"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>