package com.dynnoil.ui.pages;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.ShowTime;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import java.util.LinkedList;

/**
 * Created by krukov on 23.10.2015.
 */
@Import(stylesheet = "style.css")
public class TimePage {

    /**
     * Название фильма на русском
     */
    @Property(write = false)
    private String filmNameRu;

    /**
     * Продолжительность (минуты)
     */
    @Property(write = false)
    private int duration;

    /**
     * Число.месяц начала проката
     */
    @Property(write = false)
    private float movieRental;

    /**
     * Страна-производитель
     */
    @Property(write = false)
    private String country;

    /**
     * Год выпуска
     */
    @Property(write = false)
    private int year;

    @SessionState
    private Film film;

    @Property
    private LinkedList<ShowTime> times;

    void pageLoaded() {
        filmNameRu = film.getFilmNameRu();
        duration = film.getDuration();
        movieRental = film.getMovieRental();
        country = film.getCountry();
        year = film.getYear();
        times = new LinkedList<ShowTime>();
    }

    void onActivate() {
        for (int i = 0; i < 14; i++) {
            times.add(new ShowTime(movieRental + i));
        }
    }

    void onPassivate() {
        times.clear();
    }
}