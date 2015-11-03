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
@Import(stylesheet = "style.css")
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
        showDates = new ArrayList<DateOfShow>();
    }

    /**
     * Событие, обрабатываемое при загрузке
     * страницы (создании)
     */
    private void pageLoaded() {
        for (int i = 0; i < 14; i++) {
            dateOfShow = new DateOfShow(film.getMovieRental() + i);
            showDates.add(dateOfShow);
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
                this.bookTime = dateOfShow.getShowTimeFirst();
                break;
            case 1:
                this.bookTime = dateOfShow.getShowTimeSecond();
                break;
            case 2:
                this.bookTime = dateOfShow.getShowTimeThird();
                break;
            case 3:
                this.bookTime = dateOfShow.getShowTimeFourth();
                break;
            case 4:
                this.bookTime = dateOfShow.getShowTimeFifth();
                break;
            default:
                break;
        }
        return dialogZone.getBody();
    }
}