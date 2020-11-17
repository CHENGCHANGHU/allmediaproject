package com.seu.seumedia.configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by susq on 2017-7-10.
 */
@Primary
public class DateConvert implements Converter<String, Timestamp> {

//    private static String dealDateFormat(String oldDate) {
//        Date date1 = null;
//        DateFormat df2 = null;
//        try {
//            oldDate= oldDate.replace("Z", " UTC");
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
//            Date date = df.parse(oldDate);
//            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
//            date1 = df1.parse(date.toString());
//            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return df2.format(date1);
//    }

    @Override
    public Timestamp convert(String stringDate) {
//        stringDate = dealDateFormat(stringDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = null;
        try {
            Date d = simpleDateFormat.parse(stringDate);
            timestamp = new Timestamp(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

}