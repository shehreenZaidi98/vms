package com.vms.visitorPass;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VisitorPass {
@Id
    private String id;
    private String name;
    private String phone_no;
    private String email;

    private String purpose_of_visit;
    private String whom_to_meet;
    private String date;
    private String status;
    private Binary photo;
    private String check_in;
    private String check_out;
    private String gender;
    private String profession;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Binary getPhoto() {
        return photo;
    }

    public void setPhoto(Binary photo) {
        this.photo = photo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
