package com.dynnoil.ui.pages;

import com.dynnoil.sc.Film;
import com.dynnoil.sc.DateOfShow;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница с информацией о показах фильма
 * <p/>
 * Created by krukov on 23.10.2015.
 */
@Import(library = {"validators.js", "jquery-1.11.3.js"}, stylesheet = "style.css")
public class TimePage {

    /**
     * SesstionState объект
     * для информации о фильме
     */
    @SessionState
    @Property
    private Film film;

    /**
     * Cortege for grid table
     */
    @Property
    private DateOfShow dateOfShow;

    /**
     * List of corteges
     */
    @Property
    private List<DateOfShow> showDates;

    /**
     * Service for checking request
     */
    @Inject
    private Request request;

    /**
     * Компонент зона
     */
    @InjectComponent
    private Zone dialogZone;

    /**
     * Время бронирования
     */
    @Property
    private String bookTime;

    public TimePage() {
        dateOfShow = new DateOfShow();
        showDates = new ArrayList<DateOfShow>();
    }

    /**
     * Событие, обрабатываемое при загрузке
     * страницы (создании)
     */
    private void pageLoaded() {
        for (int i = 0; i < 14; i++) {
            showDates.add(new DateOfShow(film.getMovieRental() + i));
        }
    }

    /**
     * Событие, происходящее при нажатии на
     * ссылку (в нашем случае при нажатии на время показа
     * в таблице Grid)
     *
     * @param context -контекст
     * @return -тело зоны
     */
    private Object onClickTime(Integer context) {
        switch (context) {
            case 0:
                this.bookTime = DateOfShow.SHOW_TIME_FIRST;
                break;
            case 1:
                this.bookTime = DateOfShow.SHOW_TIME_SECOND;
                break;
            case 2:
                this.bookTime = DateOfShow.SHOW_TIME_THIRD;
                break;
            case 3:
                this.bookTime = DateOfShow.SHOW_TIME_FOURTH;
                break;
            case 4:
                this.bookTime = DateOfShow.SHOW_TIME_FIFTH;
                break;
            default:
                break;
        }
        return dialogZone.getBody();
    }
}