<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/31/2020
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<section>
    <div class="container">
        <div class="row">
            <button type="button" class="btn btn-link" data-toggle="modal" data-target=".bs-example-modal-lg">
                Đăng ký
            </button>
            <button type="button" class="btn btn-link" data-toggle="modal" data-target=".bs-example-modal-lg">
                Đăng nhập
            </button>
            <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <h1>Modal</h1>
                            <div class="row">
                                <div class="col-md-5 col-lg-5 block-image">
                                    <img src="../../Resource/Image/logo.png" alt="Lỗi hiển thị" class="img-responsive"
                                         width="300px" height="500px">
                                </div>
                                <div class="col-md-6 col-lg-6 block-contact">
                                    <h3 style="text-align: center">Registration</h3>
                                    <form action="/Registration" method="post">
                                        <div class="form-group">
                                            <label>
                                                <input type="text" class="form-control" placeholder="Enter your name"
                                                       name="customer-name" size="50">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="number" class="form-control" placeholder="Enter your age" name="customer-age">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter your phone-number" name="customer-phone" size="50">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter your email" name="customer-email" size="50">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter your address" name="customer-address" size="50">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="radio" id="male" name="customer-gender" value="male">
                                                <label for="male">Male</label>
                                                <input type="radio" id="female" name="customer-gender" value="female">
                                                <label for="female">Female</label>
                                                <input type="radio" id="other" name="customer-gender" value="other">
                                                <label for="other">Other</label>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter your account" name="customer-acc" size="50">
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <input type="password" class="form-control"
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
            </div>
        </div>
    </div>
</section>
</body>
</html>
