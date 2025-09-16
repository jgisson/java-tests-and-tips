package jgisson.java8.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by jgisson on 21/03/2017.
 */
public class DateTests {

    private static final String STD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static void main(String[] args) {

        // testPfnDateFormat("2017-02-27T14:36:29");
        // testISO8601DateFormat("2017-02-27T14:36:29Z");

        // testLocalDate();
        // testLocalDateAddDay(5);
        testDateAddMs(5000);
        testDateAddDays(5);
    }

    private static void testDateAddMs(int i) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);

        Date now = new Date();
        System.out.println("ISO8601 Date Time : " + df.format(now));

        Date reminder = new Date(now.getTime() + i);
        System.out.println("ISO8601 Date Time : " + df.format(reminder));
    }

    private static void testDateAddDays(int i) {

        ZonedDateTime delayDate = ZonedDateTime.now().plusDays(i);
        ZonedDateTime delayDay = delayDate.truncatedTo(ChronoUnit.DAYS);

        System.out.println("ZonedDateTime toString()" + delayDay.toString());
        System.out.println("ZonedDateTime ISO8601" + delayDay.format(DateTimeFormatter.ofPattern(ISO8601_DATE_FORMAT)));

        // Take care !
        ZonedDateTime delayDayUTC = delayDay.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("ZonedDateTime ISO8601 UTC" + delayDayUTC.format(DateTimeFormatter.ofPattern(ISO8601_DATE_FORMAT)));
    }

    private static void testLocalDateAddDay(int day) {
        LocalDate date = LocalDate.now();
        System.out.println("Date UTC time : " + date.toString());

        LocalDate date2 = date.plusDays(day);
        System.out.println("Date UTC time : " + date2.toString());
    }

    private static void testLocalDate() {
        ZonedDateTime today = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("Today UTC time : " + today.toString());

        LocalDate todayHere = LocalDate.now();
        System.out.println("Today UTC time : " + todayHere.toString());
    }

    private static void testPfnDateFormat(String sDate) {
        System.out.println("Text: " + sDate);

        SimpleDateFormat df = new SimpleDateFormat(STD_DATE_FORMAT);
        Date date = null;
        try {
            date = df.parse(sDate);
            System.out.println("Date: " + date.getTime());
            String reformatedDate = df.format(date);
            System.out.println("Re-format date: " + reformatedDate);
            if (reformatedDate.equals(sDate)) {
                System.out.println("Tests ok");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void testISO8601DateFormat(String sDate) {
        System.out.println("Text: " + sDate);

        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        Date date = null;
        try {
            date = df.parse(sDate);
            System.out.println("Date time: " + date.getTime());
            String reformatedDate = df.format(date);
            System.out.println("Re-format date: " + reformatedDate);
            if (reformatedDate.equals(sDate)) {
                System.out.println("Tests ok");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
