package com.zembrzuski.geolife.baseservice.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;

@Getter
public class RichDate {

    private static final SimpleDateFormat DIA_DA_SEMANA_FORMATTER = new SimpleDateFormat("EE");
    private static final SimpleDateFormat HORA_FORMATTER = new SimpleDateFormat("HH");

    private final Date firstTimestamp;
    private final String diaDaSemana;
    private final String hora;

    RichDate(Date firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
        this.diaDaSemana = DIA_DA_SEMANA_FORMATTER.format(firstTimestamp);
        this.hora = HORA_FORMATTER.format(firstTimestamp);
    }

}
