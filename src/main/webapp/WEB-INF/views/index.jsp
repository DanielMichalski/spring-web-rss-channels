<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Latest news from the Java world:</h1>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td class="col-md-1">
                <c:out value="${item.blogEntity.name}"/>
            </td>
            <td class="col-md-1">
                <c:out value="${item.publishedDate}"/>
            </td>
            <td class="col-md-10">
                <strong>
                    <a href="<c:out value="${item.link}"/>" target="_blank">
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