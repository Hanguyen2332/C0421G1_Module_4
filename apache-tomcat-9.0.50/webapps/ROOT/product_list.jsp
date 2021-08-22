<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <style>
        .mess-red {
            color: red;
        }

        th {
            text-align: center !important;
            margin: auto !important;
        }

        .deleteId {
            width: 15px;
            height: 15px;
        }

        #deleteCheckbox {
            width: 15px;
            height: 15px;
        }
    </style>
    <link rel="stylesheet" href="/assert/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<%--<jsp:include page="/layout/navbar.jsp"></jsp:include>--%>

<div class="container-fluid">
    <div class="row p-0">

        <%--        thong bao --%>
        <div class="col-sm-12 col-md-12 col-lg-12 text-center">
            <h2 style="color: blue">Product List</h2>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-12 mess-red">
            <p>${message}</p> <%-- create/edit - message --%>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-12">
            <c:if test="${empty productList}">
                <p class="mess-red">Product List is EMPTY!</p>  <%-- List empty - message --%>
            </c:if>
        </div>
    </div>


    <%--    botton create new + search --%>
    <nav class="navbar">
        <%--        <a class="navbar-brand btn btn-success my-3">Navbar</a>--%>
        <a class="btn btn-success my-3 col-sm-12 col-md-3" href="/product?action=create_product" role="button"
           style="max-width: 11%">Create Product</a>

        <%--search by name--%>
        <form method="post" class="form-inline col-sm-12 col-md-9 align-items-stretch my-auto" action="/product"
              style="padding-left: 400px">
            <input type="text" name="action" value="search_by_name_division" hidden>
            <input class="form-control mr-sm-2" type="search" placeholder="Search by name" name="nameSearch"
                   value="${charName}" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search by price" name="divisionSearch"
                   value="${division}" aria-label="Search">
            <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div class="col-sm-12 col-md-12 text-end">
            <c:if test='${!charName.equals("") || !division.equals("")}'>
                <p class="mess-red" style="padding-left: 70%;">${messSearch}</p>
            </c:if>
        </div>

    </nav>

    <div class="row p-0">
        <%--    Hien thi list--%>
        <div class="col-sm-12 col-md-12 col-lg-12">
            <c:if test="${not empty productList}">
                    <input type="text" name="action" value="deleteByCheckbox" hidden>
                    <table class="table table-bordered table-striped" id="tableEmployee"
                           style="max-width: 100%;display: inline-block;overflow-x: scroll">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Color</th>
                            <th>Quantity</th>
                            <th colspan="2">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="productObj" items="${requestScope['productList']}">
                            <tr style="text-align: center">
                                <td>${productObj.productId}</td>
                                <td>${productObj.productName}</td>
                                <td>${productObj.price}</td>
                                <td>${productObj.categoryName}</td>
                                <td>${productObj.colorName}</td>
                                <td>${productObj.quantity}</td>

                                <td>
                                    <a class="btn btn-outline-success"
                                       href="/product?action=edit&id=${productObj.productId}"
                                       role="button">Update </a>
                                </td>
                                <td>
                                    <button onclick="onDelete('${productObj.productId}','${productObj.productName}')"
                                            type="button"
                                            class="btn btn-danger" data-target="#modalId" data-toggle="modal">Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </c:if>
        </div>
    </div>
</div>

<%--delete-modal: 1item--%>
<div class="modal fade" id="modalId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận xóa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/product">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="idUserDel">
                <div class="modal-body">
                    Ban co muon xoa
                    <span style="color:red;" id="nameUserDel"></span>
                    <%--   ??????????????   --%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/jquery/popper.min.js"></script>
<script src="/assert/js/bootstrap.min.js"></script>
<%--break page--%>
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>


<script>
    function onDelete(id, name) {
        document.getElementById("idUserDel").value = id;
        document.getElementById("nameUserDel").innerHTML = name;
    }
</script>

</body>
</html>