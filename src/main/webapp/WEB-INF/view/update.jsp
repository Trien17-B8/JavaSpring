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
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Section-->
<section class="py-5">
    <h1> Quản Lý Sản Phẩm</h1>
    <form action="/product/shop-trien/update" method="Post" enctype="multipart/form-data">
        ID : <input type="text" class="form-control" name="id" style="width: 500px" value="${listSanPham.id}" > <br>
        Tên SP : <input type="text" class="form-control" name="tenSP" style="width: 500px" value="${listSanPham.tenSP}" required> <br>
        Nhà Sản Xuất : <input type="text" class="form-control" name="nhaSanXuat" style="width: 500px" value="${listSanPham.nhaSanXuat}" required > <br>
        Mô Tả : <input type="text" class="form-control" name="moTa" style="width: 500px" value="${listSanPham.moTa}" required> <br>
        Số Lượng Tồn : <input type="text" class="form-control" name="soLuongTon" style="width: 500px" value="${listSanPham.soLuongTon}" required> <br>
<%--        Image: <input name="img" type="file" id="formFileMultiple" value="${listSanPham.img}"> <br>--%>
        Giá Bán: <input type="text" class="form-control" name="giaBan" style="width: 500px" value="${listSanPham.giaBan}" required> <br>
        <button type="submit" class="btn btn-secondary" onclick="return confirm('Are you sure you want to update?')">Update</button>
    </form>
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
