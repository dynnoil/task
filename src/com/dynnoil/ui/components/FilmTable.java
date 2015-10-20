package com.dynnoil.ui.components;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Created by krukov on 20.10.2015.
 */

@Import(stylesheet = "style.css")
public class FilmTable {

    @Parameter(required = true, defaultPrefix = "literal")
    private String filmNameRu;

    @Parameter(required = true , defaultPrefix = "literal")
    private String filmNameOrig;


    @Parameter(required = true, value = "false", defaultPrefix = "literal")
    private boolean is3D;


    @Parameter(required = true, defaultPrefix = "literal")
    private String genre;

    @Parameter(required = true, defaultPrefix = "literal")
    private int duration;

    @Parameter(required = true, defaultPrefix = "literal")
    private int rateMark;

    @Parameter(required = true, defaultPrefix = "literal")
    private String movieRental;

    @Parameter(required = true, defaultPrefix = "literal")
    private String country;

    @Parameter(required = true, defaultPrefix = "literal")
    private String year;

    //
    @Parameter(required = true)
    private String director;

    @Parameter(required = true)
    private String actors;

    @Parameter(required = true)
    private String aboutFilm;


    @Inject
    @Path("noimage.jpg")
    @Parameter
    private Asset poster;

    public String getFilmNameRu() {
        return this.filmNameRu;
    }

    public String getFilmNameOrig() {
        return this.filmNameOrig;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getRateMark() {
        return this.rateMark;
    }

    public String getMovieRental() {
        return movieRental;
    }

    public String getCountry() {
        return this.country;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public String getActors() {
        return this.actors;
    }

    public String getAboutFilm() {
        return this.aboutFilm;
    }

    public Asset getPoster() {
        return this.poster;
    }
}