package com.dynnoil.sc;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * @param movieRentalDate - число.месяц начала показа
     */
    public DateOfShow(String movieRentalDate, int add) throws ParseException {
        int dot = movieRentalDate.indexOf('.');
        String onlyDay = movieRentalDate.substring(0, dot);
        String withoutDay = movieRentalDate.substring(dot, movieRentalDate.length());
        int day = Integer.parseInt(onlyDay) + add;
        movieRentalDate = String.valueOf(day) + withoutDay;
        showDate = new SimpleDateFormat("dd.MM.yyyy").parse(movieRentalDate);
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
