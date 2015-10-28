package com.dynnoil.ui.pages;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.ShowTime;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Grid;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import java.util.LinkedList;

/**
 * Created by krukov on 23.10.2015.
 */
@Import(library = "jquery-1.11.3.js",
        stylesheet = "style.css")
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

    /**
     * Address of film's image (poster)
     */
    @Property
    private String imageAddress;

    /**
     * Session state object to
     * keep beetwen sessions
     */
    @SessionState
    private Film film;

    /**
     * Cortege for grid table
     */
    @Property
    private ShowTime showTime;


    /**
     * List of corteges
     */
    @Property
    private LinkedList<ShowTime> times;

    /**
     * Service for checking request
     */
    @Inject
    private Request request;

    @InjectComponent
    private Zone myZone;

    /**
     * Время бронирования
     */
    @Property
    private String bookTime;

    /**
     * Дата бронирования
     */
    @Property
    private String bookDate;

    void pageLoaded() {
        filmNameRu = film.getFilmNameRu();
        duration = film.getDuration();
        movieRental = film.getMovieRental();
        country = film.getCountry();
        year = film.getYear();
        imageAddress = film.getImageAddress();
        times = new LinkedList<ShowTime>();
    }

    void onActivate() {
        times.clear();
        for (int i = 0; i < 14; i++) {
            showTime = new ShowTime(movieRental + i);
            times.add(showTime);
        }
    }


    Object onClickTime(Integer context) {
        switch (context) {
            case 0:
                this.bookTime = showTime.getShow1();
                break;
            case 1:
                this.bookTime = showTime.getShow2();
                break;
            case 2:
                this.bookTime = showTime.getShow3();
                break;
            case 3:
                this.bookTime = showTime.getShow4();
                break;
            case 4:
                this.bookTime = showTime.getShow5();
                break;
            default:
                break;
        }
        return myZone.getBody();
    }

}