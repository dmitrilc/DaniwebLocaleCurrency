package com.example;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Entry {

    public static void main(String[] args){
        //Pre-made locales
        Locale[] locales = {
                Locale.US,
                Locale.JAPAN,
                Locale.FRANCE,
                Locale.KOREA,
                new Locale("es", "PE")
        }; //1

        LocalDate now = LocalDate.now(); //2

        //localized date loop
        for (Locale locale : locales){
            System.out.println("Locale: " + locale + ", date: " + localizeDate(now, locale)); //3
        } //4

        BigDecimal money = BigDecimal.valueOf(1_484.2428127233); //5

        //localized currency loop
        for (Locale locale : locales){
            System.out.println("Locale: " + locale + ", money: " + localizeCurrency(money, locale)); //6
        } //7
    }

    private static String localizeDate(LocalDate date, Locale locale){ //7
        DateTimeFormatter formatter = DateTimeFormatter //8
                .ofLocalizedDate(FormatStyle.LONG) //9
                .withLocale(locale); //10

        return formatter.format(date); //11
    }

    private static String localizeCurrency(BigDecimal money, Locale locale){ //12
        return NumberFormat //13
                .getCurrencyInstance(locale) //14
                .format(money); //15
    }

}
