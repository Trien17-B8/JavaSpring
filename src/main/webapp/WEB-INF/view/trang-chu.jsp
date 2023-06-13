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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
    <%@include file="../css/custom/session.css"%>

</style>
<body>

<jsp:include page="../layout/header.jsp"/>
    <section class="section-products">
        <div class="container">
            <form class="form-inline" style="display: flex" method="get" action="/product/shop-trien/trang-chu/tim-kiem">
                <input class="form-control mr-sm-2" placeholder="Search" name="tenSP" value="${param.tenSP}">
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"/>
            </form>
            <form class="form-inline" style="display: flex; float: right" method="get" action="/product/shop-trien/trang-chu/tim-kiem-price">
                <label><input class="form-control mr-sm-2" placeholder="Min Price" name="min" required></label>
                <label><input class="form-control mr-sm-2" placeholder="Max Price" name="max" required></label>
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"/>
            </form>
            <br>
            <br>
            <br>
            <div class="row justify-content-center text-center">
                <div class="col-md-8 col-lg-6">
                    <div class="header">
                        <h3>ADIDAS FOOTBALL</h3>
                        <h2>Popular Products</h2>
                    </div>
                </div>
            </div>
            <h1>${soLuongSP}</h1>

            <div class="row">
                <!-- Single Product -->
                <c:forEach items="${listSanPham}" var="p">

                <div class="col-md-6 col-lg-4 col-xl-3">
                    <div id="product-1" class="single-product">
                        <div class="part-1">
                            <img src="http://localhost:8080/image/${p.img}" alt="" style="width: 290px; height: 290px">
                            <ul>
                                <li><a href="/product/shop-trien/add/${p.id}"><i class="fa fa-cart-plus" style="font-size:18px"></i></a></li>
                                <li><a href="/product/shop-trien/detail/${p.id}"><i class="fa fa-search-plus" style="font-size:18px"></i></a></li>
                            </ul>
                        </div>
                        <div class="part-2">
                            <h2 class="product-title">${p.tenSP}</h2>
<%--                            <h4 class="product-old-price">$79.99</h4>--%>
                            <h4 class="product-price">${p.giaBan}$</h4>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <div >
                <nav aria-label="Page navigation example" style="text-align: center">
                    <ul class="pagination justify-content-center">
                        <c:if test="${currentPage > 1}">
                            <li class="page-item">
                                <a class="page-link" href="/product/shop-trien/trang-chu/page/${currentPage -1}">Previous</a>
                            </li>
                        </c:if>
                        <c:forEach var="pageNumber" begin="1" end="${totalPages}">
                            <li class="page-item" style="color: #0a53be">
                                <a class="page-link" href="/product/shop-trien/trang-chu/page/${pageNumber}">
                                        ${pageNumber}
                                </a>
                            </li>
                        </c:forEach>
                        <c:if test="${currentPage < totalPages}">
                            <li class="page-item">
                                <a class="page-link" href="/product/shop-trien/trang-chu/page/${currentPage + 1}">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>

    </section>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
