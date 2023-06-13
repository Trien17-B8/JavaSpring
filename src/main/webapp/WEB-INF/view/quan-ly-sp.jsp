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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Section-->
<section class="py-5">
    <h1> Quản Lý Sản Phẩm</h1>
    <form method="get" action="/product/shop-trien/product-manager/tim-kiem">
        Enter somthing: <input name="tenSP" value="${param.tenSP}" >
        <input type="submit" value="search">
    </form>
    <form action="/product/shop-trien/new" method="Post" enctype="multipart/form-data">
        Tên SP : <input type="text" class="form-control" name="tenSP" style="width: 500px" required > <br>
        Nhà Sản Xuất : <input type="text" class="form-control" name="nhaSanXuat" style="width: 500px" required> <br>
        Mô Tả : <input type="text" class="form-control" name="moTa" style="width: 500px" required> <br>
        Số Lượng Tồn : <input type="text" class="form-control" name="soLuongTon" style="width: 500px" required> <br>
        Image: <input name="img" type="file" id="formFileMultiple" required> <br>
        Giá Bán: <input type="text" class="form-control" name="giaBan" style="width: 500px" required> <br>
        <button type="submit" class="btn btn-secondary" onclick="return confirm('Are you sure you want add product?')">Thêm</button>
    </form>
    <table class="table" >
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Tên SP</th>
            <th scope="col">NSX</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Image</th>
            <th scope="col">Số Lượng Tồn</th>
            <th scope="col">Giá Bán</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSanPham}" var="sanpham" varStatus="i">
            <tr>
                <td><h6>${i.index}</h6></td>
                <td>${sanpham.id}</td>
                <td>${sanpham.tenSP}</td>
                <td>${sanpham.nhaSanXuat}</td>
                <td>${sanpham.moTa}</td>
                <td><img src="http://localhost:8080/image/${sanpham.img}" alt="" width="50px" height="50px"></td>
                <td>${sanpham.soLuongTon}</td>
                <td>${sanpham.giaBan}$</td>
                <td>
                    <a href="/product/shop-trien/delete/${sanpham.id}" onclick="return confirm('Are you sure you want to delete?')"><i class="fa fa-trash" style="font-size:18px"></i></a>
                    <a href="/product/shop-trien/update/${sanpham.id}"><i class="fa fa-arrow-right" style="font-size:18px"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
