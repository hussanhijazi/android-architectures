package br.com.hussan.githubapi.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.TimeZone;

/**
 * Created by hussan on 7/22/16.
 */

public class DateUtils {

    public static String formatDate(final String iso)  {
        DateTimeZone locaTimeZone = DateTimeZone.forTimeZone(TimeZone.getDefault());
        DateTime creationDate = new DateTime(iso, locaTimeZone);

        return creationDate.toString(DateTimeFormat.forPattern("dd/MM/yy - HH:mm"));
    }
}