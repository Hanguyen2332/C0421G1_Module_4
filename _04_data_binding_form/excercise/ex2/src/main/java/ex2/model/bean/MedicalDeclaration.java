package ex2.model.bean;

import java.util.Date;

public class MedicalDeclaration {
    private String fullName;
    private int yearOfBirth;  //date
    private String gender;      //options
    private String nationality;   //options
    private String idCard;
    private String transportation;  //radiobuttons
    private String transportNumber;
    private String seatNumber;
    private Date departureDay;  //date
    private Date endDate;  //date
    private String visitedLocation;
    private String province;  //options
    private String district;   //options
    private String town;    //options
    private String address;
    private String phone;
    private String email;
    private String[] diseaseSymptoms; //checkboxes - TRIỆU CHỨNG BỆNH
    private String[] exposureHistory;  // checkboxes - Lịch sử phơi nhiễm

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName, int yearOfBirth, String gender, String nationality, String idCard, String transportation, String transportNumber, String seatNumber, Date departureDay, Date endDate, String visitedLocation, String province, String district, String town, String address, String phone, String email, String[] diseaseSymptoms, String[] exposureHistory) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transportation = transportation;
        this.transportNumber = transportNumber;
        this.seatNumber = seatNumber;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.visitedLocation = visitedLocation;
        this.province = province;
        this.district = district;
        this.town = town;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.diseaseSymptoms = diseaseSymptoms;
        this.exposureHistory = exposureHistory;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVisitedLocation() {
        return visitedLocation;
    }

    public void setVisitedLocation(String visitedLocation) {
        this.visitedLocation = visitedLocation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getDiseaseSymptoms() {
        return diseaseSymptoms;
    }

    public void setDiseaseSymptoms(String[] diseaseSymptoms) {
        this.diseaseSymptoms = diseaseSymptoms;
    }

    public String[] getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String[] exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
