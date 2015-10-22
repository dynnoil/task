package com.dynnoil.ui.mixins;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;

/**
 * Created by krukov on 21.10.2015.
 */

@Import(stylesheet = "style.css")
public class TimePanel {



    @AfterRender
    void after(MarkupWriter writer) {
        writer.element("div", "id", "timetable");
        writer.end();
    }

}