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
     * �������� ������ �� �������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String filmNameRu;

    /**
     * ������������ �������� ������
     */
    @Parameter(value = "", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String filmNameOrig;

    /**
     * ������ 3D
     */
    @Parameter(value = "false", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private boolean is3D;

    /**
     * ����
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private Genres genre;

    /**
     * ����������������� (������)
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private int duration;

    /**
     * ���������� �����������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private Rates rateMark;

    /**
     * �����.����� ������ �������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private float movieRental;

    /**
     * ������-�������������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String country;

    /**
     * ��� �������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private int year;

    /**
     * ��������
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String director;

    /**
     * ��������� ������ (��������)
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String actors;

    /**
     * �������� ������
     */
    @Parameter(required = true, defaultPrefix = "literal")
    @Property
    private String aboutFilm;

    /**
     * ������ ����������� � ������
     */
    @Parameter(value = "https://im1-tub-ru.yandex.net/i?id=4070294ddfc24e67d971a1b39253a93d&n=33&h=190&w=254", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String imageAddress;


    @Property
    private String format;

    @SessionState
    private Film film;

    void setupRender() {
        this.film = new Film(filmNameRu, duration, movieRental, country, year, imageAddress);
        format = "2D";
    }

    void onActivate() {
        if (is3D) {
            format= "2D 3D";
        }
    }

}