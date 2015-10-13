package com.indasil.shopdrop.web.feature.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vashishta on 10/13/15.
 */
public class IsoDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            date = sdf.parse(s);
        } catch (Exception ex) {

        }

        return date;
    }
}
