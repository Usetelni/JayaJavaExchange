package br.com.usetelni.jayaexchange.util;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class TimeZones {

    private static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    private static final String UTC = "UTC";

    public static void setDefault() {
        TimeZone.setDefault(TimeZone.getTimeZone(AMERICA_SAO_PAULO));
    }

    public static void setUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
    }

    public static ZoneId getDefault() {
        return ZoneId.of(AMERICA_SAO_PAULO);
    }

    public static ZoneId getUtc() {
        return ZoneId.of(UTC);
    }

    public static ZoneOffset getZoneOffSetUtc(){
        return ZoneOffset.UTC;
    }
}
