package com.zhi.date;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,9,5, 16,22,55);
        System.out.println(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2021,Calendar.OCTOBER,5, 16,22,55);
        System.out.println(calendar2.getTime());
        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID());
        System.out.println(TimeZone.getDefault().getRawOffset() / 3600000);

        String timeStr  = "2021-09-28 11:22:31";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(timeStr);
        System.out.println(parse);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(parse));

        // ZoneDateTime = LocalDateTime + ZoneId 具有时区性质
        ZoneId zoneIdSH = ZoneId.of("Asia/Shanghai");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println(calendar1.getTime());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusDays(30));

        // 对日期时间做计算操作，Java8日期时间API会比Calendar功能强大很多

        System.out.println("//测试操作日期");
        System.out.println(LocalDate.now()
                .minus(Period.ofDays(4))
                .plus(4, ChronoUnit.DAYS)
        );


        System.out.println("//本月第一天");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println("//今年的程序员节");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));

        System.out.println("//计算时间差");
        LocalDate ld1 = LocalDate.of(2021,10, 5);
        LocalDate ld2 = LocalDate.of(2021, 5, 5);
        System.out.println(Period.between(ld2, ld1));
        System.out.println(Period.between(ld2, ld1).getDays());
        System.out.println(ChronoUnit.DAYS.between(ld2, ld1));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-10s", "嗷嗷").replace(" ", "_"));
        System.out.println(stringBuilder);

        BigDecimal bigDecimal = BigDecimal.valueOf(0.5235).setScale(2, BigDecimal.ROUND_DOWN)
                .multiply(BigDecimal.valueOf(100))
                ;
        System.out.println(bigDecimal.longValue());

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
