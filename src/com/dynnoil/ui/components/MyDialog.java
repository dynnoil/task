package com.dynnoil.ui.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Класс-компонент, представляющий
 * собой модальное окно
 *
 * Created by krukov on 27.10.2015.
 */
@Import(library = "jquery/jquery-1.11.3.js",stylesheet = "css/dndialog.css")
public class MyDialog implements ClientElement {

    /**
     * ИД-блока, в котором будет использоваться
     * компонент
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "prop:componentResources.id")
    private String cliendId;

    /**
     * Название заголовка окна
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Message")
    @Property
    private String title;

    /**
     * Сообщение, передаваемое в окно
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Empty message!")
    @Property
    private String message;

    /**
     * Подпись к перному полю ввода
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Введите ваше имя:")
    @Property
    private String fieldOneSign;

    /**
     * Подпись ко второму полю ввода
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "Введите ваш номер телефона:")
    @Property
    private String fieldTwoSign;

    /**
     * Подпись к кнопке
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL, value = "OK")
    @Property
    private String buttonSign;

    /**
     * Внедрение услуги
     */
    @Inject
    private JavaScriptSupport javaScriptSupport;

    /**
     * Внедрение компонента
     */
    @InjectComponent
    private Form userData;

    /**
     * Имя заказчика
     */
    @Property
    @Persist(PersistenceConstants.FLASH)
    @Validate("required")
    private String customerName;

    /**
     * Номер мобильного телефона заказчика
     */
    @Property
    @Persist(PersistenceConstants.FLASH)
    @Validate("maxlength=12, minlength=10, required")
    private String numberPhone;

    /**
     * End of rendering (writing) div element started
     * at begin render method and adding of jQuery code
     */
    void beginRender() {
        javaScriptSupport.addScript("$j(window).load(function() {" +
                "$j('div #popup').hide();});" +
                "$j('div div div #closeIt').click(function() {" +
                "$j('div #popup').hide();});");
    }

    @Override
    public String getClientId() {
        return this.cliendId;
    }
}