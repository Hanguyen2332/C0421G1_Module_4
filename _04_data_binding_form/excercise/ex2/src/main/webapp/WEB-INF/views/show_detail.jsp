<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Tờ khai y tế </title>
    <style>
        #title {
            text-align: center;
            display: block;
        }

        label {
            font-weight: bold;
        }
    </style>
    <link rel="stylesheet" href="/assert/css/bootstrap.min.css">
<body>
<div class="container">
    <div class="row" id="title">
<%--        Thông báo--%>
        <c:if test="${medicalDeclaration == null}">
            <h4>Bạn chưa khai báo y tế!</h4>
            <button class="bg-primary"><a href="/medical_declaration" style="color: white">Khai báo ngay</a></button>
        </c:if>
<%--Thong bao: success/--%>
    <c:if test="${message != null}">
        <p style="color: red">${message}</p>
    </c:if>

    </div>
    <c:if test="${object != null}">

        <%--    /body:--%>
    <div class="row mt-5" style="display: block">
            <%--            HỌ tên (Ghi chữ IN HOA) --%>
            <div class="form-group">
                <label>HỌ tên</label>
                <input type="text" value="${object.fullName}" class="form-control" readonly="true"/>
            </div>

            <%--            Năm sinh -giới tính - quốc tịch--%>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label >Năm sinh</label>
                    <input value="${object.yearOfBirth}" class="form-control" readonly="true"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Giới tính</label>
                    <input value="${object.gender}" class="form-control" readonly="true"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Quốc Tịch</label>
                    <input value="${object.nationality}" class="form-control" readonly="true"/>
                </div>
            </div>
            <%--           số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác--%>
            <div class="form-group">
                <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
                <input value="${object.idCard}" class="form-control" readonly="true"/>
            </div>
            <%--           Thông tin đi lại: radiobuttons--%>
            <div class="form-check form-check-inline" style="display: block">
                <label>Thông tin đi lại </label>
                <input value="${object.transportation}" readonly="true"/>
            </div>
            <%--           Số hiệu phương tiện - Số ghế--%>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label >Số hiệu phương tiện</label>
                    <input value="${object.transportNumber}" class="form-control" readonly="true"/>
                </div>

                <div class="form-group col-md-6">
                    <label >Số ghế</label>
                    <input value="${object.seatNumber}" class="form-control" readonly="true"/>
                </div>
            </div>

            <%--           Ngày khởi hành - Ngày kết thúc--%>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Ngày khởi hành</label>
                    <input value="${object.departureDay}" class="form-control" readonly="true"/>
                </div>

                <div class="form-group col-md-6">
                    <label>Ngày kết thúc</label>
                    <input value="${object.endDate}" class="form-control" readonly="true"/>
                </div>
            </div>

            <%--           Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?--%>
            <div class="form-group">
                <label >Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố :</label>
                <input value="${object.visitedLocation}" class="form-control" readonly="true"/>
            </div>

            <%--           Địa chỉ liên lạc : Tỉnh/thành   -  Quận/huyện  - Phường-xã --%>

            <div class="form-row">
                <label class="col-md-12">Địa chỉ liên lạc</label>
                <div class="form-group col-md-4">
                    <label >Tỉnh/thành</label>
                    <input value="${object.province}" class="form-control" readonly="true"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Quận/huyện</label>
                    <input value="${object.district}" class="form-control" readonly="true"/>
                </div>
                <div class="form-group col-md-4">
                    <label >Phường-xã</label>
                    <input value="${object.town}" class="form-control" readonly="true"/>
                </div>
            </div>

            <%--           Địa chỉ nơi ở --%>

            <div class="form-group">
                <label >Địa chỉ nơi ở</label>
                <input value="${object.address}" class="form-control" readonly="true"/>
            </div>

            <%--           Điện thoại  - Email --%>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label >Điện thoại</label>
                    <input value="${object.phone}" class="form-control" readonly="true"/>
                </div>

                <div class="form-group col-md-6">
                    <label >Email</label>
                    <input value="${object.email}" class="form-control" readonly="true"/>
                </div>
            </div>

            <%--            Triệu chứng--%>
            <div class="form-check form-check-inline" style="display: block">
                <label>Trong vòng 14 ngày qua, Anh chị có xuất hiện triệu chứng : </label>
                <c:forEach items="${object.diseaseSymptoms}" var="item">
                    <span>${item}</span>
                </c:forEach>
            </div>

            <%--           Lịch sử phơi nhiễm--%>
            <div class="form-check form-check-inline" style="display: block">
                <label class="col-md-12">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh chị có</label>
                <c:forEach items="${object.exposureHistory}" var="item">
                    <span>${item}</span>
                </c:forEach>
<%--                <form:checkboxes path="exposureHistory" items="${exposureHistory}"/>--%>
            </div>

            <div class="col-md-12 mt-5">
                <h6 STYLE="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho công tác phòng chống
                    dịch </h6>
            </div>

        </c:if>
    </div>
</div>

    <script src="/assert/js/bootstrap.min.js"></script>
</body>
</html>