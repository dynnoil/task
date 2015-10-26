package com.dynnoil.ui.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 26.10.2015.
 */

@Import(library = {"bootstrap/particles/bootstrap.particles", "jquery-ui/external/jquery.particles"},
        stylesheet = "bootstrap/css/bootstrap.css")
public class Dialog implements ClientElement {

    @Parameter(value = "prop:componentResources.id",
            defaultPrefix = BindingConstants.LITERAL)
    private String clientId;

    @Property
    @Parameter(required = true)
    private Block content;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Override
    public String getClientId() {
        return clientId;
    }

    private void afterRender() {
        javaScriptSupport.addScript("$('#%s').modal()", getClientId());
    }
}