package com.dynnoil.ui.components;

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
     * Название фильма на русском
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String filmNameRu;

    /**
     * Оригинальное название фильма
     */
    @Parameter(value = "", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String filmNameOrig;

    /**
     * Формат 3D
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
     * Возрастное ограничение
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private Rates rateMark;

    /**
     * Время проката с такого-то числа по
     * такое
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private int movieRental;

    /**
     * Страна-производитель
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String country;

    /**
     * Год выпуска
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private int year;

    /**
     * Режиссео
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String director;

    /**
     * Актерский состав (основные)
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String actors;

    /**
     * Описание фильма
     */
    @Parameter(required = true, defaultPrefix = "literal")
    @Property
    private String aboutFilm;

    /**
     * Адресс изображения к фильму
     */
    @Parameter(value = "https://im1-tub-ru.yandex.net/i?id=4070294ddfc24e67d971a1b39253a93d&n=33&h=190&w=254", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String imageAddress;


    @Property
    private String format;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    void setupRender() {
        format = "2D";
    }

    void beginRender() {
        if (is3D) {
            format= "2D 3D";
        }
    }

    void clearupRender() {
    }

    void onShow() {

        RenderCommand command = new RenderCommand() {
            @Override
            public void render(MarkupWriter markupWriter, RenderQueue renderQueue) {
                markupWriter.element("div","id", "zone");
                markupWriter.write("SHIT");
                markupWriter.end();
            }

        };

        ajaxResponseRenderer.addRender("myZone", command);

    }

}