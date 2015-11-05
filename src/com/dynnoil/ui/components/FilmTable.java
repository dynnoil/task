package com.dynnoil.ui.components;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.Genres;
import com.dynnoil.sc.Rates;
import com.dynnoil.ui.pages.TimePage;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.*;

/**
 * Created by krukov on 20.10.2015.
 */
@Import(stylesheet = "css/style.css")
public class FilmTable {

    /**
     * Название фильма
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String filmNameRu;

    /**
     * Доступность в 3D
     */
    @Parameter(value = "false", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private boolean is3D;

    /**
     * Жанр
     */
    @Parameter(required = true)
    @Property
    private Genres genre;

    /**
     * Продолжительность (минуты)
     */
    @Parameter(required = true)
    @Property
    private int duration;

    /**
     * Рейтинг
     */
    @Parameter(required = true)
    @Property
    private Rates rateMark;

    /**
     * Начало проката
     */
    @Parameter(required = true)
    @Property
    private double movieRental;

    /**
     * Страна производитель
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String country;

    /**
     * Год
     */
    @Parameter(required = true)
    @Property
    private int year;

    /**
     * Режиссер
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String director;

    /**
     * Актерский состав
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String actors;

    /**
     * Информация о фильме
     */
    @Parameter(required = true, defaultPrefix = "literal")
    @Property
    private String aboutFilm;

    /**
     * URL-адрес изображения к фильму
     */
    @Parameter(value = "https://im1-tub-ru.yandex.net/i?id=4070294ddfc24e67d971a1b39253a93d&n=33&h=190&w=254", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String imageAddress;

    /**
     * Формат (2D, 3D)
     */
    @Property
    private String format;

    /**
     * Session state объект для
     * хранения и передачи информации о фильме
     */
    @SessionState
    private Film film;

    /**
     * Конструктор
     */
    public FilmTable() {}

    private Object onGoTimePage() {
        this.film = new Film(filmNameRu, duration, movieRental, country, year, imageAddress);
        return TimePage.class;
    }

    /**
     * Событие, обрабатываемое перед
     * рендерингом компонента
     */
    void setupRender() {
         this.film = new Film(filmNameRu, duration, movieRental, country, year, imageAddress);
         if (is3D) {
             format="3D";
         } else {
             format="2D";
         }
    }
}