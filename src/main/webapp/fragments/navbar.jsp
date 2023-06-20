<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080/book/list">Book list</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="http://localhost:8080/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/register">Register</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Book Menu
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="http://localhost:8080/book/create">Create book</a></li>
                        <li><a class="dropdown-item" href="http://localhost:8080/book/delete">Delete book</a></li>
                        <li><a class="dropdown-item" href="http://localhost:8080/book/update">Update book</a></li>
                        <li><a class="dropdown-item" href="http://localhost:8080/user/list">User list</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>