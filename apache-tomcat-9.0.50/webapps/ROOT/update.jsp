<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee </title>
    <style>
        .mesRed {
            color: red;
        }
        form {
            width: 40%;
        }
    </style>
    <link rel="stylesheet" href="/assert/css/bootstrap.min.css">

</head>
<body>

<div class="container align-items-center">
    <%--    <div class="row p-0">--%>

    <%--        thong bao --%>
    <div class="row mb-2">
        <h3 class="col-sm-12 col-md-12 col-lg-12 text-sm-center text-md-center text-lg-center mt-3"
            style="color: blue">Update Product</h3>
        <p class="col-sm-12 col-md-12 col-lg-12"
           style="color: red">${message}</p> <%--        create/edit - message: success/fail? --%>
    </div>

    <form action="" method="post" class="mx-auto">

        <div class="row mb-1">
            <%--            Name: validate Name (khong number)--%>
            <label for="inputEmail3" class="col-sm-4 col-md-4 col-lg-4 px-0 col-form-label mb-1">Product
                Name</label>
            <div class="col-sm-8 col-md-8 col-lg-8 mb-1">
                <input type="text" class="form-control" name="name" id="inputEmail3"
                       value="${productObj.productName}" required>
                <%--                the validate--%>
                <p class="mesRed">
                    ${validateMesMap.get("checkName")}
                </p>
            </div>

            <%--  salary: validate (number+so duong)--%>
            <label for="price" class="col-sm-4 col-md-4 col-lg-4 px-0 col-form-label mb-1">price</label>
            <div class="col-sm-8 col-md-8 col-lg-8 mb-1">
                <input type="text" class="form-control" name="price" id="price" value="${productObj.price}" required>
            </div>

            <%--: --%>
            <div class="class=col-sm-4 col-md-4 col-lg-4 px-0 mb-1">Category</div>
            <div class="col-sm-8 col-md-8 col-lg-8 mb-1">
                <select class="form-select form-select-lg w-100" aria-label=".form-select-lg example"
                        name="Category" style="height: 40px">
                    <c:forEach var="categoryObj" items="${requestScope['categories']}">
                        <option value="${categoryObj.categoryId}" selected>${categoryObj.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <%--    EduDegree--%>
            <div class="class=col-sm-4 col-md-4 col-lg-4 px-0 mb-1">Color</div>
            <div class="col-sm-8 col-md-8 col-lg-8 mb-1">
                <select class="form-select form-select-lg w-100" aria-label=".form-select-lg example"
                        name="Color" style="height: 40px">
                    <c:forEach var="colorObj" items="${requestScope['colors']}">
                        <option value="${colorObj.colorId}" selected>${colorObj.colorName}</option>
                    </c:forEach>
                </select>
            </div>


            <%--user: NO NEED Validate--%>
            <label for="userName" class="col-sm-4 col-md-4 col-lg-4 px-0 col-form-label mb-1">Quantity</label>
            <div class="col-sm-8 col-md-8 col-lg-8 mb-1">
                <input type="text" class="form-control" name="Quantity" id="userName" value="${productObj.quantity}">
            </div>
            <button type="submit" class="btn btn-primary m-auto mt-1">Create</button>
        </div>
    </form>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/jquery/popper.min.js"></script>
<script src="/assert/js/bootstrap.min.js"></script>
</body>
</html>

