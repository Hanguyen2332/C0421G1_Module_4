function getData(id) {
    return document.getElementById(id).value;
}
//set message:
function setMess(id) {
    return document.getElementById(id);
}
//---------------valiadte---------------//
//checkForm:
function validateForm() {
    let check = true;

    let name = getData("name");
    let code = getData("code");
    let area = getData("area");
    let floors = getData("floor");
    let poolArea = getData("poolArea");
    let maxPeople = getData("maxPeople");
    let price = getData("price");

    //name
    if (name === '') {
        setMess("nameMess").innerText = "Vui lòng nhập tên dịch vụ"
        check = false;
    }
    //code
    if (code === '') {
        setMess("codeMess").innerText = "Không để trống trường này";
        check = false;
    } else if (!/DV-\d{4}/.test(code)) {
        setMess("codeMess").innerText = "Vui lòng nhập đúng định dạng: 'DV-XXXX' (Với X: 0-9)"
        check = false;
    }
    //area
    if (area == 0.0) {
        setMess("areaMess").innerText = "Không để trống trường này";
        check = false;
    } else if (area < 0 || isNaN(area)) {
        setMess("areaMess").innerText = "Vui lòng nhập số dương";
        check = false;
    }

    //floor
    if ((floors < 0 || isNaN(floors)) && floors !==0) {
        setMess("floorMess").innerText = "Vui lòng nhập số nguyên dương";
        check = false;
    }
    //poolArea
    if (poolArea != 0.0 && (poolArea < 0 || isNaN(poolArea))) {
        setMess("poolAreaMess").innerText = "Vui lòng nhập số dương";
        check = false;
    }
    //maxPeople
    if (maxPeople == 0) {
        setMess("maxPeopleMess").innerText = "Không để trống trường này";
        check = false;
    }else if (maxPeople < 0 || isNaN(maxPeople)) {
        setMess("maxPeopleMess").innerText = "Vui lòng nhập số nguyên dương";
        check = false;
    }
    //price
    if (price == 0.0) {
        setMess("priceMess").innerText = "Không để trống trường này";
        check = false;
    }else if (price < 0 || isNaN(price)) {
        setMess("priceMess").innerText = "Vui lòng nhập số dương";
        check = false;
    }
    return check
}
