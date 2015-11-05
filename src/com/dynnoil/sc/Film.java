package com.dynnoil.sc;

import java.io.Serializable;

/**
 * Класс, описывающий фильм
 *
 * Created by krukov on 23.10.2015.
 */
public class Film implements Serializable {

    /**
     * Название фильма
     */
    private String filmNameRu;

    /**
     * Продолжительность (минуты)
     */
    private int duration;

    /**
     * Начало проката (число.месяц)
     */
    private double movieRental;

    /**
     * Страна-произдодитель
     */
    private String country;

    /**
     * Год
     */
    private int year;

    /**
     * URL- адрес изображения к фильму
     */
    private String imageAddress;

    public Film() {}

    /**
     * Конструктор класса
     *
     * @param filmNameRu -название фильма
     * @param duration -продолжительность (минуты)
     * @param movieRental -начало проката (число.месяц)
     * @param country -страна
     * @param year -год
     * @param imageAddress -URL-адрес изображения к фильму
     */
    public Film(String filmNameRu, int duration, double movieRental,
                String country, int year, String imageAddress) {
        this.filmNameRu = filmNameRu;
        this.duration = duration;
        this.movieRental = movieRental;
        this.country = country;
        this.year = year;
        this.imageAddress = imageAddress;
    }

    public String getFilmNameRu() {
        return filmNameRu;
    }

    public void setFilmNameRu(String filmNameRu) {
        this.filmNameRu = filmNameRu;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getMovieRental() {
        return movieRental;
    }

    public void setMovieRental(double movieRental) {
        this.movieRental = movieRental;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

}
