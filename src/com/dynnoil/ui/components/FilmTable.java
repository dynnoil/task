package com.dynnoil.ui.components;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.Genres;
import com.dynnoil.sc.Rates;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.runtime.RenderCommand;
import org.apache.tapestry5.runtime.RenderQueue;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import java.util.Date;

/**
 * Created by krukov on 20.10.2015.
 */
@Import(stylesheet = "style.css")
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
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private Genres genre;

    /**
     * Продолжительность (минуты)
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private int duration;

    /**
     * Рейтинг
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private Rates rateMark;

    /**
     * Начало проката
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private float movieRental;

    /**
     * Страна производитель
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String country;

    /**
     * Год
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
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
    FilmTable() {
        this.film = new Film(filmNameRu, duration, movieRental, country, year, imageAddress);
        this.format="2D";
    }

    /**
     * Событие, обрабатываемое перед
     * рендерингом кмпонента
     */
    void setupRender() {
        if (is3D) {
            format = "2D 3D";
        }
    }
}