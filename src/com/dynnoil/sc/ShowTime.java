package com.dynnoil.sc;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by krukov on 22.10.2015.
 */
public class ShowTime implements Serializable {

    private String date;

    private String show1;

    private String show2;

    private String show3;

    private String show4;

    private String show5;

    public ShowTime(float movieRental) {
        date = String.valueOf(movieRental) + ".2015";
        show1 = "12:00";
        show2 = "14:45";
        show3 = "16:00";
        show4 = "18:30";
        show5 = "20:45";
    }

    public String getDate() {
        return this.date;
    }

    public String getShow1() {
        return show1;
    }

    public String getShow2() {
        return show2;
    }

    public String getShow3() {
        return show3;
    }

    public String getShow4() {
        return show4;
    }

    public String getShow5() {
        return show5;
    }

}
