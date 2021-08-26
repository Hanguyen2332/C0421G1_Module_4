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
        <h3>TỜ KHAI Y TẾ</h3>
        <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Ý TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM </h4>
        <h6 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
            sự</h6>
    </div>
    <%--    /body:--%>
    <div class="row mt-5" style="display: block">
        <form:form modelAttribute="medicalDeclaration" action="/save_infor" method="post">
            <%--            HỌ tên (Ghi chữ IN HOA) --%>
            <div class="form-group">
                <label for="inputAddress">Họ tên (ghi chứ IN HOA)</label>
                <form:input path="fullName" class="form-control" id="inputAddress"/>
            </div>

            <%--            Năm sinh -giới tính - quốc tịch--%>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputEmail4">Năm sinh</label>
                    <form:input path="yearOfBirth" class="form-control" id="inputEmail4"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="exampleFormControlSelect1">Giới tính</label>
                    <form:select path="gender" class="form-control" id="exampleFormControlSelect1">
                        <form:option label="-Chọn-" value="NONE"/>
                        <form:options items="${gender}"/>
                    </form:select>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPassword5">Quốc Tịch</label>
                    <form:select path="nationality" class="form-control" id="inputPassword5">
                        <%--                        <form:option value = "NONE" label = "Select"/>--%>
                        <form:options items="${nationality}"/>
                    </form:select>
                </div>
            </div>
            <%--           số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác--%>
            <div class="form-group">
                <label for="inputAddress">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
                <form:input path="idCard" class="form-control" id="inputAddress"/>
            </div>
            <%--           Thông tin đi lại: radiobuttons--%>
            <div class="form-check form-check-inline" style="display: block">
                <label><form:label path="transportation">Thông tin đi lại</form:label></label>
                <p><form:radiobuttons path="transportation" items="${transportations}"/></p>
            </div>
            <%--           Số hiệu phương tiện - Số ghế--%>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Số hiệu phương tiện</label>
                    <form:input path="transportNumber" class="form-control" id="inputEmail4"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputEmail4">Số ghế</label>
                    <form:input path="seatNumber" class="form-control" id="inputEmail4"/>
                </div>
            </div>


            <%--           Ngày khởi hành - Ngày kết thúc--%>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="departureDay">Ngày khởi hành</label>
                    <form:input path="departureDay" class="form-control" id="departureDay"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputEmail4">Ngày kết thúc</label>
                    <form:input path="endDate" class="form-control" id="inputEmail4"/>
                </div>
            </div>

            <%--           Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?--%>
            <div class="form-group">
                <label for="visitedLocation">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</label>
                <form:input path="visitedLocation" class="form-control" id="visitedLocation"/>
            </div>

            <%--           Địa chỉ liên lạc : Tỉnh/thành   -  Quận/huyện  - Phường-xã --%>

            <div class="form-row">
                <label class="col-md-12">Địa chỉ liên lạc</label>
                <div class="form-group col-md-4">
                    <label for="province">Tỉnh/thành</label>
                    <form:select path="province" class="form-control" id="province">
                        <form:option label="-Chọn-" value="NONE"/>
                        <form:options items="${provinces}"/>
                    </form:select>
                </div>
                <div class="form-group col-md-4">
                    <label for="district">Quận/huyện</label>
                    <form:select path="district" class="form-control" id="district">
                        <form:option label="-Chọn-" value="NONE"/>
                        <form:options items="${districts}"/>
                    </form:select>
                </div>
                <div class="form-group col-md-4">
                    <label for="town">Phường-xã</label>
                    <form:select path="town" class="form-control" id="town">
                        <form:option label="-Chọn-" value="NONE"/>
                        <form:options items="${towns}"/>
                    </form:select>
                </div>
            </div>

            <%--           Địa chỉ nơi ở --%>

            <div class="form-group">
                <label for="address">Địa chỉ nơi ở</label>
                <form:input path="address" class="form-control" id="address"/>
            </div>

            <%--           Điện thoại  - Email --%>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="phone">Điện thoại</label>
                    <form:input path="phone" class="form-control" id="phone"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <form:input path="email" class="form-control" id="email"/>
                </div>
            </div>

            <%--            Triệu chứng--%>
            <div class="form-check form-check-inline" style="display: block">
                <label for="inputAddress">Trong vòng 14 ngày qua, Anh chị có xuất hiện triệu chứng nào sau đây không?</label>
                <form:checkboxes path="diseaseSymptoms" items="${diseaseSymptoms}"/>
            </div>

            <%--           Lịch sử phơi nhiễm--%>
            <div class="form-check form-check-inline" style="display: block">
                <label class="col-md-12">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh chị có</label>
                <form:checkboxes path="exposureHistory" items="${exposureHistory}"/>
            </div>

            <div class="col-md-12 mt-5">
                <h6 STYLE="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho công tác phòng chống dịch
                Khi bạn nhấn nút "Gửi", là bạn đã hiểu và đồng ý
                </h6>
            </div>

            <button type="submit" class="btn btn-success mx-auto" >GỬI TỜ KHAI</button>
        </form:form>
    </div>
</div>

<script src="/assert/js/bootstrap.min.js"></script>
</body>
</html>