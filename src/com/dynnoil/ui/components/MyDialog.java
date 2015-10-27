package com.dynnoil.ui.components;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 27.10.2015.
 */
@Import(library = "jquery/jquery-1.11.3.js",stylesheet = "dndialog.css")
public class MyDialog {

    @Inject
    private JavaScriptSupport javaScriptSupport;

    /**
     * Starting render of div element
     *
     * @param writer
     */
    void beginRender(MarkupWriter writer) {
        writer.element("div");
    }

    /**
     * Rendering button element (or any if I want add it by parameter)
     *
     * @param writer
     */
    void afterRenderTemplate(MarkupWriter writer) {
       // writer.element("button", "id", "openButton");
        //writer.write("Open Dialog");
        //writer.end();
    }

    /**
     * End of rendering (writing) div element started
     * at begin render method
     * and
     * adding of jQuery code
     *
     * @param writer
     */
    void afterRender(MarkupWriter writer) {
        writer.end();
        javaScriptSupport.addScript("$j(window).load(function() {" +
                "$j('div #popup').hide();});" +
                "$j('div #openButton').click(function() {" +
                "$j('div #popup').show();}); +" +
                "$j('div div div #closeIt').click(function() {" +
                "$j('div #popup').hide();});");
    }


}