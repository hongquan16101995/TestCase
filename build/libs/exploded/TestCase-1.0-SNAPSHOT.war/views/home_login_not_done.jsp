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
                <button type="button" class="btn btn-link1" data-toggle="modal" data-target=".bs-example-modal-lg">
                    Đăng ký
                </button>
                <button type="button" class="btn btn-link2" data-toggle="modal"
                        data-target=".bs-example-modal-md-login">
                    Đăng nhập
                </button>
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
                        <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/home?action=shirt&type=Áo">Áo</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/home?action=trousers&type=Quần">Quần</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/home?action=shoes&type=Giày">Giày</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/home?action=search" method="post">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="regex">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</div>
<!--đây là menu-->

<!--đây là section-->
<div class="container">
    <div class="row">
        <jsp:useBean id="listAllProduct" scope="request" type="java.util.List"/>
        <c:forEach items="${listAllProduct}" var="products">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-3 col-xl-3 product" style="border: solid 1px lightgrey">
                <div class="block-status-product" style="height: 30px; text-align: center">
                    <c:if test='${products.getAmount() == 0}'>
                        <span style="color: red">Tạm hết hàng</span>
                    </c:if>
                </div>
                <div class="block-image-product">
                    <img src="${products.getImageUrl()}" class="img-responsive img-thumbnail" alt="không có"
                         width="300px" height="300px">
                </div>
                <div class="block-name-product" style="text-align: center; margin-top: 10px">
                        ${products.getName()}
                </div>
                <div class="block-price-product" style="text-align: center">
                        ${products.getPrice()}
                </div>
            </div>
        </c:forEach>
    </div>
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

<!--đây là đăng nhập-->
<div class="modal fade bs-example-modal-md-login" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-dialog-centered modal-md" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-lg-1 col-xl-1 empty-block"></div>
                <div class="col-lg-10 col-xl-10 block-login">
                    <h3 style="text-align: center">Đăng nhập</h3>
                    <form action="${pageContext.request.contextPath}/login?action=login" method="post">
                        <table>
                            <tr>
                                <td><label><span>Tài khoản:&nbsp;</span></label></td>
                                <td><label>
                                    <input type="text" class="form-control" placeholder="Enter your account"
                                           name="customer-account" size="35" required="">
                                </label></td>
                            </tr>
                            <tr>
                                <td><label><span>Mật khẩu:&nbsp;</span></label></td>
                                <td><label>
                                    <input type="password" class="form-control" placeholder="Enter your password"
                                           name="customer-password" size="35" required="">
                                </label></td>
                            </tr>
                        </table>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" class="btn btn-primary" value="Đăng nhập">
                        </div>
                        <label>
                            <span>Bạn chưa có tài khoản?&nbsp;</span>
                            <button type="button" class="btn btn-link" data-toggle="modal"
                                    data-target=".bs-example-modal-lg">
                                Tạo tài khoản
                            </button>
                        </label>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--đây là đăng nhập-->

<!--đây là đăng ký-->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-lg-5 col-xl-5 block-image">
                    <img src="image/logo.png" alt="Lỗi hiển thị" class="img-responsive"
                         width="300px" height="500px" style="margin: 20px">
                </div>
                <div class="col-lg-6 col-xl-6 block-contact">
                    <h3 style="text-align: center">Đăng ký</h3>
                    <form action="${pageContext.request.contextPath}/login?action=registration" method="post">
                        <div class="form-group">
                            <label>
                                <input type="text" class="form-control" placeholder="Enter your name"
                                       required="" name="customer-name" size="50">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="number" class="form-control" placeholder="Enter your age"
                                       required="" name="customer-age">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="text" class="form-control" required=""
                                       placeholder="Enter your phone-number" name="customer-phone"
                                       size="50">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="email" class="form-control" required=""
                                       placeholder="Enter your email" name="customer-email" size="50">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="text" class="form-control" required=""
                                       placeholder="Enter your address" name="customer-address" size="50">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="radio" id="male" name="customer-gender" value="male" required="">
                                <label for="male">Male</label>
                                <input type="radio" id="female" name="customer-gender" value="female" required="">
                                <label for="female">Female</label>
                                <input type="radio" id="other" name="customer-gender" value="other" required="">
                                <label for="other">Other</label>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="text" class="form-control" required=""
                                       placeholder="Enter your account" name="customer-acc" size="50">
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="password" class="form-control" required=""
                                       placeholder="Enter your password" name="customer-pass" size="50">
                            </label>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" class="btn btn-primary" value="Tạo tài khoản">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--đây là đăng ký-->

<%--thông báo đăng nhập không thành công--%>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Thông báo</h4>
            </div>
            <div class="modal-body">
                <p>Đăng nhập thất bại do tài khoản không tồn tại hoặc sai mật khẩu!</p>
                <p>Bạn muốn đăng nhập lại?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-link1" data-toggle="modal" data-target=".bs-example-modal-md-login" data-dismiss="modal">
                    Đăng nhập
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(window).on('load',function(){
        $('#myModal').modal('show');
    });
</script>
<%--thông báo đăng nhập không thành công--%>
</body>
</html>