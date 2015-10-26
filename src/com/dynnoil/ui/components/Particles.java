package com.dynnoil.ui.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 26.10.2015.
 */
@Import(library = "particles/particles.js")
public class Particles implements ClientElement {

    @Parameter(value = "prop:componentResources.id",
            defaultPrefix = BindingConstants.LITERAL)
    private String clientId;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Path("particles/demo/particles.json")
    private Asset json;

    @Override
    public String getClientId() {
        return clientId;
    }

    private void afterRender() {
        javaScriptSupport.addScript("particlesJS.load( '%s' , '%s');"
                , getClientId(), json.toClientURL());
    }
}