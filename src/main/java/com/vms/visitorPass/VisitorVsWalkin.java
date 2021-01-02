package com.vms.visitorPass;

import org.springframework.data.mongodb.core.mapping.Document;


public class VisitorVsWalkin {
int visitor;
int walkin;

    public int getVisitor() {
        return visitor;
    }

    public void setVisitor(int visitor) {
        this.visitor = visitor;
    }

    public int getWalkin() {
        return walkin;
    }

    public void setWalkin(int walkin) {
        this.walkin = walkin;
    }

    public VisitorVsWalkin(int visitor, int walkin) {
        this.visitor = visitor;
        this.walkin = walkin;
    }
}
