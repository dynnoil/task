package com.dynnoil.ui.components;


import com.dynnoil.sc.ShowTime;
import org.apache.tapestry5.annotations.Property;

import java.util.*;

/**
 * Created by krukov on 22.10.2015.
 */
public class TimeWindow {

    @Property
    private List<ShowTime> times;

    void setupRender() {
        times = new LinkedList<ShowTime>();
        for (int i = 0; i < 10; i++) {
            times.add(new ShowTime());
        }
    }

    void beginRender() {

    }
}