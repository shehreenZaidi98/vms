package com.vms.walkin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Walkin {
    @Id
    private String id;
    private String phone_no;
    private String meeting_date;
    private String meeting_time;
    private String designation;
    private String gender;
    private String purpose;
    private String expected_check_out;
    private String business_name;
    private String no_of_person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getMeeting_date() {
        return meeting_date;
    }

    public void setMeeting_date(String meeting_date) {
        this.meeting_date = meeting_date;
    }

    public String getMeeting_time() {
        return meeting_time;
    }

    public void setMeeting_time(String meeting_time) {
        this.meeting_time = meeting_time;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getExpected_check_out() {
        return expected_check_out;
    }

    public void setExpected_check_out(String expected_check_out) {
        this.expected_check_out = expected_check_out;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getNo_of_person() {
        return no_of_person;
    }

    public void setNo_of_person(String no_of_person) {
        this.no_of_person = no_of_person;
    }
}
