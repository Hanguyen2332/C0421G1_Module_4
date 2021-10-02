function checkForm() {
    let check = true;
    let date = document.getElementById("dayOfBirth").value;
    if (date == '') {
        document.getElementById("dayMess").innerText = "Không bỏ trống trường này"
        check = false;
    }
    return check;
}
