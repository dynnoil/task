package com.dynnoil.sc;

import org.apache.tapestry5.annotations.Property;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by krukov on 22.10.2015.
 */
public class ShowTime implements Serializable {

    private Date showDate;

    private String show1;

    private String show2;

    private String show3;

    private String show4;

    private String show5;

    public ShowTime() {
        showDate = new Date();
        show1 = String.valueOf(showDate.getHours()) + ":" + String.valueOf(showDate.getMinutes());
        show2 = String.valueOf(showDate.getHours() + 5) + ":" + String.valueOf(showDate.getMinutes() + 30);
        show3 = String.valueOf(showDate.getHours() + 7) + ":" + String.valueOf(showDate.getMinutes() + 30);
    }

    public Date getShowDate() {
        return this.showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public String getShow1() {
        return this.show1;
    }

    public void setShow1(String show1) {
        this.show1 = show1;
    }


    public String getShow2() {
        return this.show2;
    }

    public void setShow2(String show2) {
        this.show2 = show2;
    }

    public String getShow3() {
        return this.show3;
    }

    public void setShow3(String show3) {
        this.show3 = show3;
    }
}
