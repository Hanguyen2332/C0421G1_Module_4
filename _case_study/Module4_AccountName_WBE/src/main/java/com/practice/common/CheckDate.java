package com.practice.common;

import java.sql.Date;
import java.time.LocalDate;


public class CheckDate {
    //Date
    public static boolean checkAge(Date birthDay) {
        //lấy số tuổi:
        LocalDate date = birthDay.toLocalDate();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        LocalDate today = LocalDate.now();
        //tính khoang cach tuoi:
        int years_gap = today.getYear() - year;
        int month_gap = today.getMonthValue() - month;
        int day_gap = today.getDayOfMonth() - day;

        if (years_gap < 18) {
            return false;
        } else if (years_gap == 18 && month_gap < 0) {
            return false;
        } else if (years_gap == 18 && month_gap == 0 && day_gap < 0) {
            return false;
        }
        return true;
    }

    public static boolean checkStartDate(Date beginDate) { //ok
        LocalDate date = beginDate.toLocalDate();
        LocalDate currentDate = LocalDate.now();

        if (date.isEqual(currentDate) || currentDate.isBefore(date)) {  //cú pháp: date1.isBefore(ngày_lớn_hơn)
            return true;
        }
        return false;
    }

    //
    public static boolean checkEndDate(Date endDate, Date startDate) { //ok
        LocalDate date1 = endDate.toLocalDate();
        LocalDate date2 = startDate.toLocalDate();

        if (date2.isEqual(date1) || date2.isBefore(date1)) {
            return true;
        }
        return false;
    }
}
