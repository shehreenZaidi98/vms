package com.vms.activeEmergencies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ActiveEmergencies {
    @Id
    private String id;
    private String name;
    private String whom_to_meet;
    private String check_in_date_time;
    private String marked_by;
    private String status;
    private String date;


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

    public String getWhom_to_meet() {
        return whom_to_meet;
    }

    public void setWhom_to_meet(String whom_to_meet) {
        this.whom_to_meet = whom_to_meet;
    }

    public String getCheck_in_date_time() {
        return check_in_date_time;
    }

    public void setCheck_in_date_time(String check_in_date_time) {
        this.check_in_date_time = check_in_date_time;
    }

    public String getMarked_by() {
        return marked_by;
    }

    public void setMarked_by(String marked_by) {
        this.marked_by = marked_by;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
