package com.dynnoil.sc;

import java.io.Serializable;
import java.util.Date;

/**
 * Класс, представляющий один день показа
 * какого-либо кино с временем показов
 * <p/>
 * Created by krukov on 22.10.2015.
 */
public class DateOfShow implements Serializable {

    /**
     * Дата показа
     */
    private Date showDate;

    /**
     * Время первого показа
     */
    public static final String SHOW_TIME_FIRST = "12:00";

    /**
     * Время второго показа
     */
    public static final String SHOW_TIME_SECOND = "14:45";

    /**
     * Время третьего показа
     */
    public static final String SHOW_TIME_THIRD = "16:00";

    /**
     * Время четвертого показа
     */
    public static final String SHOW_TIME_FOURTH = "18:30";

    /**
     * Время пятого показа
     */
    public static final String SHOW_TIME_FIFTH = "20:45";

    /**
     * Конструктор по умолчанию
     */
    public DateOfShow() {
    }

    /**
     * Конструктор класса
     *
     * @param movieRental - число.месяц начала показа
     */
    public DateOfShow(double movieRental) {
        int day = (int) movieRental;
        double month = (movieRental - day);
        showDate = new Date(new Date().getYear(),
                (month < 1.0) ? (int) (month * 9.9) : (int) (month * 99.9),
                day);
    }

    public Date getShowDate() {
        return this.showDate;
    }

    public String getShowTimeFirst() {
        return this.SHOW_TIME_FIRST;
    }

    public String getShowTimeSecond() {
        return this.SHOW_TIME_SECOND;
    }

    public String getShowTimeThird() {
        return this.SHOW_TIME_THIRD;
    }

    public String getShowTimeFourth() {
        return this.SHOW_TIME_FOURTH;
    }

    public String getShowTimeFifth() {
        return this.SHOW_TIME_FIFTH;
    }

}
