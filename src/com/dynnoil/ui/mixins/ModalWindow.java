package com.dynnoil.ui.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 27.10.2015.
 */
@Import(library = "jquery-1.11.3.js")
public class ModalWindow implements ClientElement {

    @Parameter(value = "prop:componentResources.id",
    defaultPrefix = BindingConstants.LITERAL, allowNull = false)
    private String clientId;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Override
    public String getClientId() {
        return this.clientId;
    }
}
