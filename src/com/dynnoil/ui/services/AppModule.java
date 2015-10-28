package com.dynnoil.ui.services;

import com.dynnoil.sc.Genres;
import com.dynnoil.sc.Rates;
import com.dynnoil.sc.RatesEncoder;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.apache.tapestry5.services.ValueEncoderSource;

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
}
