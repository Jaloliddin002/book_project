<%--
  Created by IntelliJ IDEA.
  User: jalol
  Date: 6/19/2023
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Home page</title>
    <jsp:include page="/fragments/css.jsp" />
</head>
<body>
    <jsp:include page="/fragments/navbar.jsp" />
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <th scope="row">${user.getId()}</th>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/fragments/js.jsp" />
</body>
</html>
