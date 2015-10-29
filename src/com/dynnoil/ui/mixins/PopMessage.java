package com.dynnoil.ui.mixins;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 29.10.2015.
 */
@Import(library = "jquery/jquery-1.11.3.js",
        stylesheet = "css/dnmessage.css")
@MixinAfter
public class PopMessage {

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Persist(PersistenceConstants.FLASH)
    private boolean isSuccess;

    void beforeRenderTemplate(MarkupWriter writer) {
        //starting popupMessage div
        writer.element("div", "id", "popupMessage");
        //starting Header div
        writer.element("div", "id", "messageHeader");
        //starting Header sign
        writer.element("p", "id", "headerSign");
        writer.write("Success");
        //closing Header sign
        writer.end();
        //closing Header div
        writer.end();
        //starting and closing Close button
        writer.element("div", "id", "closeIt");
        writer.end();
        //starting TextBlock div
        writer.element("div", "id", "textBlock");
        //starting text inside div
        writer.element("p", "id", "blockText", "align", "center");
        writer.element("b");
        writer.write("You book ticket successfully!");
        writer.end();
        //closing text inside div
        writer.end();
        //closing TextBlock div
        writer.end();
        writer.end();

        if (!isSuccess) {
            javaScriptSupport.addScript(
                    "$j('div #closeIt').click(function() {" +
                    "$j('#popupMessage').hide();});" +
                    "$j('div #popup').show(function() {" +
                    "$j('#popupMessage').hide();});");
        } else {
            javaScriptSupport.addScript("$j('#popupMessage').show();" +
                    "$j('div #closeIt').click(function() {" +
                    "$j('#popupMessage').hide();});");
        }
    }

    void onSuccess() {
        this.isSuccess = true;
    }
}
