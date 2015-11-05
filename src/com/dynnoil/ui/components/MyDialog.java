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
@Import(stylesheet = "css/dndialog.css")
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
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String title;

    /**
     * Сообщение, передаваемое в окно
     */
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String mainMessage;

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
    private String customerName;

    /**
     * Номер мобильного телефона заказчика
     */
    @Property
    @Persist(PersistenceConstants.FLASH)
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