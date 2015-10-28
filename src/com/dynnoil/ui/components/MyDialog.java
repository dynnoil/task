package com.dynnoil.ui.components;

import com.dynnoil.ui.pages.ModalTest;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 27.10.2015.
 */
@Import(library = "jquery/jquery-1.11.3.js",stylesheet = "dndialog.css")
public class MyDialog {

    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Message")
    @Property
    private String title;

    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Empty message!")
    @Property
    private String message;

    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Введите ваше имя:")
    @Property
    private String fieldOneSign;

    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Введите ваш номер телефона:")
    @Property
    private String fieldTwoSign;

    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "OK")
    @Property
    private String buttonSign;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @InjectComponent
    private Form userData;

    @Property
    @Persist
    private String customerName;

    @Property
    @Persist
    private String numberPhone;

    /**
     * End of rendering (writing) div element started
     * at begin render method
     * and
     * adding of jQuery code
     *
     * @param writer
     */
    void afterRender(MarkupWriter writer) {
        javaScriptSupport.addScript("$j(window).load(function() {" +
                "$j('div #popup').hide();});" +
                "$j('div div #okButton').click(function() {" +
                "$j('div #popup').hide();}); +" +
                "$j('div div div #closeIt').click(function() {" +
                "$j('div #popup').hide();});");
    }

}