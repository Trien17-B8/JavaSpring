<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    @import url('https://fonts.googleapis.com/css2?family=Allerta+Stencil&display=swap');

    body {
        background: #cecece
    }

    header {
        background: #000;
        color: #fff
    }

    .left-side,
    .right-side {
        /*height: 100vh*/
    }

    .cart_count
    {
        position: absolute;
        bottom: 8px;
        width: 23px;
        height: 23px;
        background: #0e8ce4;
        border-radius: 50%;
        text-align: center;
    }
    .cart_count span
    {
        display: block;
        line-height: 23px;
        font-size: 12px;
        color: #FFFFFF;
        -webkit-transform: translateY(1px);
        -moz-transform: translateY(1px);
        -ms-transform: translateY(1px);
        -o-transform: translateY(1px);
        transform: translateY(1px);
    }
    .cart_icon img
    {
        width: 100%;
    }
    .cart_content
    {
        margin-left: 28px;
    }
    .cart_text a
    {
        font-size: 18px;
        font-weight: 400;
        color: #000000;
        -webkit-transition: all 200ms ease;
        -moz-transition: all 200ms ease;
        -ms-transition: all 200ms ease;
        -o-transition: all 200ms ease;
        transition: all 200ms ease;
    }
    .cart_text a:hover
    {
        color: #0e8ce4;
    }
    .cart_price
    {
        font-size: 14px;
        color: #a3a3a3;
        margin-top: -2px;
    }

    .navbar-transparent {
        background: transparent
    }

    .navbar-nav>li>a {
        color: #fff
    }

    .text{
        font-family: Tahoma;
    }

    .navbar-nav>li:hover {
        border-bottom: 1px solid #fff
    }

    .navbar-nav>.active {
        border-bottom: 1px solid #fff
    }

    .navbar-brand {
        font-family: 'Allerta Stencil', sans-serif;
        color: #83ff00
    }

    .navbar-brand:hover {
        color: #fff
    }

    .left-side img {
        padding-top: 100px
    }

    .shape {
        width: 100%;
        height: 100vh;
        background: linear-gradient(to bottom, #ce0000, #7A0800 20%);
        position: absolute;
        -webkit-clip-path: ellipse(500px 100px at 10% 3%)
    }

    .right-side {
        padding-top: 150px
    }

    .right-side h1 {
        font-family: 'Allerta Stencil', sans-serif;
        font-size: 2.4em;
        text-align: center
    }

    .right-side p {
        font-size: 1.5em;
        text-align: center;
        font-weight: bold
    }

    .btn.order-button {
        background: transparent;
        border: 2px solid #83ff00;
        color: #83ff00;
        border-radius: 30%;
        transition: 0.7s
    }

    .btn.order-button:hover {
        border: 2px solid #ce0000;
        color: #ce0000
    }
</style>
<div class="container-fluid px-0">
    <header>
    <div class="shape"></div>	<!-- Navbar -->
    <nav class="navbar  navbar-expand-lg navbar-transparent">
        <a class="navbar-brand" href="/product/shop-trien/trang-chu">TRIỂN ADIDAS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button> <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto"> <li class="nav-item active">
            <a class="nav-link" href="/product/shop-trien/trang-chu">HOME </a> </li>
            <li class="nav-item"> <a class="nav-link" href="#">Adidas</a> </li>
            <c:choose>
                <c:when test="${sessionScope.account!=null}">
                <li class="nav-item"> <a class="nav-link" href="/product/shop-trien/product-manager">Manager</a> </li>
                <li class="nav-item"> <a class="nav-link" href="/product/shop-trien/manager/hoa-don">Hoa Don</a> </li>
                <li class="nav-item"> <a class="nav-link" href="/product/shop-trien/thong-ke/san-pham">Thong Ke</a> </li>
                </c:when>
            </c:choose>
        </ul>
    </div>
            <div class="cart">
            <div class="cart_container d-flex flex-row align-items-center justify-content-end">
                <div class="cart_icon">
                    <a href="/product/shop-trien/cart-all"><i class="fa fa-cart-plus" style="font-size:40px;color:red"></i>
                    <c:choose>
                        <c:when test="${soSPGH>=1}">
                            <div class="cart_count"><span>${soSPGH}</span></div>
                        </c:when>
                    </c:choose>
                    </a>
                </div>
        <c:choose>
            <c:when test="${sessionScope.account!=null}">
                <a class="nav-link" href="#" style="margin-left: 25px; margin-right: 25px; font-size: 20px">${sessionScope.account.hoTen}</a>
                <a class="nav-link" href="/product/shop-trien/logout" style="font-size: 10px">Logout</a>
            </c:when>
        <c:otherwise>
            <a class="nav-link" href="/product/shop-trien/login" style="margin-left: 25px; margin-right: 25px; font-size: 20px">Login</a>
        </c:otherwise>
        </c:choose>

            </div>
        </div>
    </nav>	<!-- ./ end of navbar -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 left-side">
                <img src="https://kenh14cdn.com/thumb_w/640/pr/2022/photo1664195164791-1664195165334509341445-63799861194547.png" class="w-100">
            </div>	<div class="col-md-6 right-side">
            <h1>TRIỂN ADIDAS</h1>
            <p>FREE DELIVERY</p>
            <div class="text-center">
                <button class="btn order-button">ORDER NOW</button>	</div>
        </div>
        </div>
    </div>
</header>
</div>
<%--<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>--%>