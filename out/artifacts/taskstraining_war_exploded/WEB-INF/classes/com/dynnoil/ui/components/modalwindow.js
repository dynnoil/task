/**
 * Created by krukov on 26.10.2015.
 */
Tapestry.Initializer.setupModalDialog = function(params)
{
    // Setup zone
    var element = $(params.id);
    $T(element).zoneId = params.zone;

    var showModalbox = function()
    {
        var loadContentWithScripts = function(transport)
        {
            var node = new Element('div').update(transport.responseJSON.content);
            params.options.onContentLoaded = function()
            {
                Tapestry.loadScriptsInReply(transport.responseJSON, function() {});
            };

            params.options.afterHide = function()
            {
                if(params.zone)
                {
                    var zoneManager = Tapestry.findZoneManager(element);
                    zoneManager.updateFromURL(params.closeLink);
                }
            };

            Modalbox.show(node, params.options);
        };

        Tapestry.ajaxRequest(params.openLink, {
            method : 'get',
            onSuccess : loadContentWithScripts
        });
    };

    Event.observe($(params.id), params.event, showModalbox);

};