<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/31/2020
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
</head>
<body>

<!--đây là header-->
<header>
    <div class="container-fluid header" id="header">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-lg-2 col-xl-2 block-image">
                <img src="image/logo.png" class="img-responsive img-logo" alt="Lỗi hiển thị">
            </div>
            <div class="col-xs-12 col-sm-12 col-lg-8 col-xl-8 block-background">
                <h1 class="name-shop">Shop HQ</h1>
            </div>
            <div class="col-xs-12 col-sm-12 col-lg-2 col-xl-2 block-login">
                <c:if test='${requestScope["account"] != null}'>
                    <a href="${pageContext.request.contextPath}/customer?action=customer&account=${requestScope["account"]}"
                       class="customer-link"><span>${requestScope["account"]}</span></a>
                    <span>&ensp;|&ensp;</span>
                </c:if>
                <a href="${pageContext.request.contextPath}/home" class="customer-link">Thoát</a>
            </div>
        </div>
    </div>
</header>
<!--đây là header-->

<!--đây là menu-->
<div class="container-fluid menu-navbar">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a href="${pageContext.request.contextPath}/customer?account=${requestScope["account"]}">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customer?action=repassword&account=${requestScope["account"]}">Đổi mật khẩu</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customer?action=historycart&account=${requestScope["account"]}">Lịch sử mua hàng</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0"
                      action="${pageContext.request.contextPath}/customer?action=search&account=${requestScope["account"]}"
                      method="post">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                           name="regex">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</div>
<!--đây là menu-->

<!--đây là section-->
<div class="container">
    <c:if test='${requestScope["customer"] != null}'>
    <form action="${pageContext.request.contextPath}/control?action=updateCustomer&account=${requestScope["account"]}" method="post">
        <div class="form-group">
            <label>Full name:&ensp;</label>
            <input type="text" class="form-control" name="customer-name" value="${requestScope["customer"].getName()}">
        </div>
        <div class="form-group">
            <label>Age:&ensp;</label>
            <input type="number" class="form-control" name="customer-age" value="${requestScope["customer"].getAge()}">
        </div>
        <div class="form-group">
            <label>Render:&ensp;</label>
            <input type="text" class="form-control" name="customer-render" value="${requestScope["customer"].getRender()}">
        </div>
        <div class="form-group">
            <label>Email:&ensp;</label>
            <input type="text" class="form-control" name="customer-email" value="${requestScope["customer"].getEmail()}">
        </div>
        <div class="form-group">
            <label>Address:&ensp;</label>
            <input type="text" class="form-control" name="customer-address" value="${requestScope["customer"].getAddress()}">
        </div>
        <div class="form-group">
            <label>Phone:&ensp;</label>
            <input type="text" class="form-control" name="customer-phone" value="${requestScope["customer"].getPhone()}">
        </div>
        <button type="submit" class="btn btn-primary">Cập nhât</button>
    </form>
    </c:if>
</div>
<!--đây là section-->

<!--đây là footer-->
<div class="container-fluid footer">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-12 col-xl-12 footer">
            <h1>Footer</h1>
        </div>
    </div>
</div>
<!--đây là footer-->

<!--hiệu ứng-->
<div class="back-to-header">
    <a href="#header">Về đầu trang</a>
</div>
<!--hiệu ứng-->
</body>
</html>