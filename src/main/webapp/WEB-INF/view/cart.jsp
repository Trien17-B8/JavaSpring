<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Shop Triển</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" type="text/css" href="../css/custom/cart.css"/>
</head>
<style>
    <%@include file="../css/custom/cart.css"%>
<%--    <%@include file="../css/custom/session.css"%>--%>
</style>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Section-->
<section class="section-products">
<%--    <div class="container">--%>

    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
<%--                        <div class="col"><h4><b>Shopping Cart</b></h4></div>--%>
<%--                        <div class="col align-self-center text-right text-muted">3 items</div>--%>
                    </div>
                </div>
    <c:forEach items="${sanPhamTrongGio}" var="sanPham">
                <div class="row border-bottom">
                    <div class="row main align-items-center">
                        <div class="col-2"><img class="img-fluid" src="http://localhost:8080/image/${sanPham.key.img}"></div>
                        <div class="col">
                            <div class="row text-muted"><h6>${sanPham.key.tenSP}</h6></div>
<%--                            <div class="row">${sanPham.value}</div>--%>
                        </div>
                        <div class="col">
                            <h6>${sanPham.value}</h6>
                        </div>
                        <div class="col"><h6>${sanPham.key.giaBan*sanPham.value}$</h6></div>
                    </div>
                </div>
    </c:forEach>
            </div>

        <%--            Tính tổng--%>
            <div class="col-md-4 summary">
                <form action="/product/shop-trien/add-bill" method="post">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <input name="tenNguoiNhan" class="form-control" placeholder="Tên" type="text">
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="diaChi" class="form-control" placeholder="Địa Chỉ" type="text">
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                        </div>
                        <input name="sdt" class="form-control" placeholder="Phone number" type="text">
                    </div> <!-- form-group// -->
                    <div class="row" style="">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right"><h3>${tongTienHang}.00$</h3></div>
                    </div>
                    <button class="btn2" type="submit">CHECKOUT</button>
                </form>

            </div>

        </div>

    </div>
<%--    </div>--%>
</section>
<jsp:include page="../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
</body>
</html>
