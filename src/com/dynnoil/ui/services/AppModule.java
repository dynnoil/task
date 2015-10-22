package com.dynnoil.ui.services;

import com.dynnoil.sc.Genres;
import com.dynnoil.sc.Rates;
import com.dynnoil.sc.RatesEncoder;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.apache.tapestry5.services.ValueEncoderSource;

/**
 * Created by krukov on 20.10.2015.
 */
public class AppModule {

    @Contribute(ValueEncoderSource.class)
    public static void privideEncoders(MappedConfiguration<Class, ValueEncoderFactory>
                                       configuration) {
        ValueEncoderFactory<Rates> factory = new ValueEncoderFactory<Rates>() {
            @Override
            public ValueEncoder<Rates> create(Class<Rates> aClass) {
                return new RatesEncoder();
            }
        };
        configuration.add(Rates.class, factory);
    }
}
