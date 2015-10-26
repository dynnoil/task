package com.dynnoil.ui.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created by krukov on 26.10.2015.
 */
@SupportsInformalParameters
@Events({TawusAddonsEventConstants.SHOW_DIALOG})
@Import(library = {"modalbox/modalbox.particles", "modalwindow.particles"},
        stylesheet = "modalbox/modalbox.css")
public class ModalDialog implements ClientElement {

    /**
     * Javascript id, if not supplied is auto-generated
     */
    @Parameter(value = "prop:componentResources.id", defaultPrefix = BindingConstants.LITERAL, allowNull = false)
    private String clientId;

    /**
     * Client event that will trigger the modal dialog
     */
    @Parameter(value = "click", defaultPrefix = BindingConstants.LITERAL, allowNull = false)
    private String clientEvent;

    /**
     * Zone to update when dialog is closed
     */
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String zone;

    /**
     * Context to be passed to the page
     */
    @Parameter
    private Object[] context;

    @Environmental
    private JavaScriptSupport javaScriptSupport;

    @Inject
    private ComponentResources resources;

    private String assignedClientId;

    public ModalDialog() {
    }

    ModalDialog(JavaScriptSupport javaScriptSupport,
                ComponentResources resources) {
        this.javaScriptSupport = javaScriptSupport;
        this.resources = resources;
    }

    void setupRender() {
        assignedClientId = javaScriptSupport.allocateClientId(clientId);
    }

    void beginRender(MarkupWriter writer) {
        writer.element("a", "href", "#", "id", getClientId());
    }

    void afterRender(MarkupWriter writer) {
        writer.end();
    }

    @AfterRender
    void addJavaScript() {

        JSONObject params = new JSONObject();

        params.put("id", getClientId());
        params.put("event", clientEvent);
        params.put("openLink", getPageLink());
        params.put("closeLink", getCloseLink());
        params.put("zone", zone);
        params.put("options", getInformalParametersAsJSON());
        javaScriptSupport.addInitializerCall("setupModalDialog", params);
    }

    private JSONObject getInformalParametersAsJSON() {
        JSONObject modalBoxOptions = new JSONObject();
        for (String parameter : resources.getInformalParameterNames()) {
            modalBoxOptions.put(parameter,
                    resources.getInformalParameter(parameter, String.class));
        }
        return modalBoxOptions;
    }

    private Object getPageLink() {
        Link link = resources.createEventLink(TawusAddonsEventConstants.SHOW_DIALOG, context);
        return link.toAbsoluteURI();
    }

    private String getCloseLink() {
        return resources.createEventLink(
                TawusAddonsEventConstants.CLOSE_DIALOG).toAbsoluteURI();
    }

    public String getClientId() {
        return assignedClientId;
    }

}

class TawusAddonsEventConstants {
    public static final String SHOW_DIALOG = "showDialog";
    public static final String CLOSE_DIALOG = "closeDialog";
}