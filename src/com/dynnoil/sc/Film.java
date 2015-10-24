package com.dynnoil.sc;

import java.io.Serializable;

/**
 * Created by krukov on 23.10.2015.
 */
public class Film implements Serializable {

    /**
     * Название фильма на русском
     */
    private String filmNameRu;

    /**
     * Продолжительность (минуты)
     */
    private int duration;

    /**
     * Число.месяц начала проката
     */
    private float movieRental;

    /**
     * Страна-производитель
     */
    private String country;

    /**
     * Год выпуска
     */
    private int year;

    /**
     * Адрес изображения к фильму
     */
    private String imageAddress;

    public Film(String filmNameRu, int duration, float movieRental,
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

    public float getMovieRental() {
        return movieRental;
    }

    public void setMovieRental(float movieRental) {
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
