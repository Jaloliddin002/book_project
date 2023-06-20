<%--
  Created by IntelliJ IDEA.
  User: jalol
  Date: 6/19/2023
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form action="http://localhost:8080/book/create" method="post">
                        <legend>Add book</legend>
                        <div class="mb-3">
                            <label for="disabledTextInput" class="form-label">Title</label>
                            <input type="text" id="disabledTextInput" class="form-control" placeholder="Enter title" name="title">
                        </div>
                        <div class="mb-3">
                            <label for="author" class="form-label">Author</label>
                            <input type="text" id="author" class="form-control" placeholder="Enter Author" name="author">
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <input type="text" id="description" class="form-control" placeholder="Enter Description" name="description">
                        </div>
                        <div class="mb-3">
                        <label for="f" class="form-label">File</label>
                        <input type="file" id="f" class="form-control" placeholder="Enter Description" name="File">
                        </div>
                        <button type="submit" class ="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/fragments/js.jsp" />
</body>
</html>
