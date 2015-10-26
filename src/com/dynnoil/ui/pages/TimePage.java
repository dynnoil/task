package com.dynnoil.ui.pages;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.ShowTime;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;

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

    /**
     * HTML code for rendering
     * div block with info
     */
    private String codeForBlock = "<div id=\"popup\"> %s" +
            "  <a href=\"http://ya.ru\">\n" +
            "       <div id=\"bookButton\"><p id=\"bookButtonText\">Book</p></div>\n" +
            "     </a></div>";


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

    Object onClickTime(String context) {
        JSONObject json = new JSONObject();
        json.put("content", String.format(codeForBlock, context));
        return request.isXHR()
                ? json
                : this;
    }



}