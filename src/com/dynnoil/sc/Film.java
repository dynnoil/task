package com.dynnoil.sc;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

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

    public Film(String filmNameRu, int duration, float movieRental,
                String country, int year) {
        this.filmNameRu = filmNameRu;
        this.duration = duration;
        this.movieRental = movieRental;
        this.country =country;
        this.year = year;
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

}
