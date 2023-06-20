<%--
  Created by IntelliJ IDEA.
  User: jalol
  Date: 6/19/2023
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Home page</title>
    <jsp:include page="/fragments/css.jsp" />
</head>
<body>
    <jsp:include page="/fragments/navbar.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
            <h1>Login</h1>
        <form action="http://localhost:8080/login" method="post">
            <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
            <c:if test="${email_error != null}">
                <snap>
                        ${email_error}
                </snap>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
            <c:if test="${password_error != null}">
                <snap>
                    ${password_error}
                </snap>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <h1>
        <a href="/register">Register</a>
    </h1>
            </div>
        </div>
    </div>
    <jsp:include page="/fragments/js.jsp" />
</body>
</html>
