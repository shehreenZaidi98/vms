package com.vms.carrier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Carrier {
    @Id
    private String id;
    private String driver_name;
    private String mobile_no;
    private String vehicle;
    private String date;
    private String status;
    private String check_in;
    private String check_out;
    private String vehicle_no;
    private String lic_no;
    private String email;
    private String location;
    private String purpose_of_visit;
    private String whom_to_meet;
    private String gender;
    private String department;
    private String nationality;
    private String pass_no;
    private String id_type;
    private String id_no;
    private String no_of_visitors;
    private String address;
    private String item_carried;
    private String serial_no;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getLic_no() {
        return lic_no;
    }

    public void setLic_no(String lic_no) {
        this.lic_no = lic_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPurpose_of_visit() {
        return purpose_of_visit;
    }

    public void setPurpose_of_visit(String purpose_of_visit) {
        this.purpose_of_visit = purpose_of_visit;
    }

    public String getWhom_to_meet() {
        return whom_to_meet;
    }

    public void setWhom_to_meet(String whom_to_meet) {
        this.whom_to_meet = whom_to_meet;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPass_no() {
        return pass_no;
    }

    public void setPass_no(String pass_no) {
        this.pass_no = pass_no;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getNo_of_visitors() {
        return no_of_visitors;
    }

    public void setNo_of_visitors(String no_of_visitors) {
        this.no_of_visitors = no_of_visitors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItem_carried() {
        return item_carried;
    }

    public void setItem_carried(String item_carried) {
        this.item_carried = item_carried;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }


}
