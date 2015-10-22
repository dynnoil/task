package com.dynnoil.sc;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.services.ValueEncoderFactory;

/**
 * Created by krukov on 22.10.2015.
 */
public class RatesEncoder implements ValueEncoder<Rates> {

    @Override
    public String toClient(Rates rates) {
        String result = "";
        switch (rates) {
            case PLUS_0:
                result = "0+";
        }
        return result;
    }

    @Override
    public Rates toValue(String s) {
        int value = Integer.parseInt(s);
        Rates result = Rates.PLUS_0;
        switch (value) {
            case 0:
                result = Rates.PLUS_0;
                break;
        }
        return result;
    }
}
