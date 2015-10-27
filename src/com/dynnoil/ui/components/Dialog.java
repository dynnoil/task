package com.dynnoil.ui.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 26.10.2015.
 */
@Import(library = {"bootstrap/js/bootstrap.js", "jquery/jquery-1.11.3.js"},
        stylesheet = "bootstrap/css/bootstrap.css")
public class Dialog {


    @Inject
    private JavaScriptSupport js;

    private void afterRender() {
        js.addScript("$(window).load(function() {" +
                "$(div #myModal).modal('show');});");
    }
}