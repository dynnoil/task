package com.dynnoil.sc;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.ioc.MessageFormatter;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.validator.AbstractValidator;

/**
 * Created by krukov on 03.11.2015.
 */
public class NumericValidator extends AbstractValidator<Void, String> {

    public NumericValidator() {
        super(null, String.class, "non-numeric");
    }

    @Override
    public void validate(Field field, Void aVoid, MessageFormatter formatter, String s)
            throws ValidationException {
        if (!s.matches("[+0-9]+")) {
            throw new ValidationException(buildMessage(formatter, field));
        }
    }

    @Override
    public void render(Field field, Void aVoid, MessageFormatter formatter,
                       MarkupWriter writer, FormSupport formSupport) {
        formSupport.addValidation(field, "numeric", buildMessage(formatter, field), null);
    }

    public String buildMessage(MessageFormatter formatter, Field field) {
        return formatter.format(field.getLabel());
    }
}
