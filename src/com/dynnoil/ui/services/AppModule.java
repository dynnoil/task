package com.dynnoil.ui.services;

import com.dynnoil.sc.NumericValidator;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.Validator;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Value;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.FieldValidatorSource;
import org.apache.tapestry5.services.messages.ComponentMessagesSource;

/**
 * Created by krukov on 20.10.2015.
 */
public class AppModule {

    @Contribute(SymbolProvider.class)
    @ApplicationDefaults
    public static void provideApplicationDefaults(
            MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES,
                "en,de,ru,iw");
    }

    @Contribute(FieldValidatorSource.class)
    public static void addValidators(
            MappedConfiguration<String, Validator> configuration) {
        configuration.add("numeric", new NumericValidator());
    }

    @Contribute(ComponentMessagesSource.class)
    public static void provideMessages(
            @Value("/com/dynnoil/ui/Messages.properties")
            Resource resource,
            OrderedConfiguration<Resource> configuration) {
        configuration.add("Messages", resource);
    }

}
