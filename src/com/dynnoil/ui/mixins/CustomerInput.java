package com.dynnoil.ui.mixins;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Mixin;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 28.10.2015.
 */
@MixinAfter
public class CustomerInput {

    @Inject
    private JavaScriptSupport js;

    void beginRender(MarkupWriter writer) {
        writer.element("div", "xmlns:t", "http://tapestry.apache.org/schema/tapestry_5_1_0.xsd");
        writer.element("t:form");
        writer.element("div");
        writer.element("input", "t:type", "submit");
        writer.end();
        writer.end();
    }

    void beforeRenderTemplate(MarkupWriter writer) {
        writer.end();
    }

    void afterRender(MarkupWriter writer) {
        writer.end();
    }

}
