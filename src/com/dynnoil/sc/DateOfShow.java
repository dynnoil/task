package com.dynnoil.sc;

import java.io.Serializable;

/**
 * Класс, представляющий один день показа
 * какого-либо кино с временем показов
 *
 * Created by krukov on 22.10.2015.
 */
public class DateOfShow implements Serializable {

    /**
     * Дата показа
     */
    private String showDate;

    /**
     * Время первого показа
     */
    private String showTimeFirst;

    /**
     * Время второго показа
     */
    private String showTimeSecond;

    /**
     * Время третьего показа
     */
    private String showTimeThird;

    /**
     * Время четвертого показа
     */
    private String showTimeFourth;

    /**
     * Время пятого показа
     */
    private String showTimeFifth;

    /**
     * Конструктор по умолчанию
     */
    public DateOfShow() {}

    /**
     * Конструктор класса
     *
     * @param movieRental - число.месяц начала показа
     */
    public DateOfShow(float movieRental) {
        showDate = String.valueOf(movieRental) + ".2015";
        showTimeFirst = "12:00";
        showTimeSecond = "14:45";
        showTimeThird = "16:00";
        showTimeFourth = "18:30";
        showTimeFifth = "20:45";
    }


    public String getShowDate() {
        return this.showDate;
    }

    public String getShowTimeFirst() {
        return this.showTimeFirst;
    }

    public String getShowTimeSecond() {
        return this.showTimeSecond;
    }

    public String getShowTimeThird() {
        return this.showTimeThird;
    }

    public String getShowTimeFourth() {
        return this.showTimeFourth;
    }

    public String getShowTimeFifth() {
        return this.showTimeFifth;
    }

}
