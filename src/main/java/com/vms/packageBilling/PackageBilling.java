package com.vms.packageBilling;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PackageBilling {
@Id
    private String id;
    private String card_no;
    private String card_holder;
    private String cvv;
    private String expiry;
    private String billing_address;
    private String company_name;
    private String billing_contact;
    private String vat_tin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getBilling_contact() {
        return billing_contact;
    }

    public void setBilling_contact(String billing_contact) {
        this.billing_contact = billing_contact;
    }

    public String getVat_tin() {
        return vat_tin;
    }

    public void setVat_tin(String vat_tin) {
        this.vat_tin = vat_tin;
    }
}
