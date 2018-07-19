package com.zembrzuski.geolife.baseservice.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class RichDate {

    private static final SimpleDateFormat DIA_DA_SEMANA_FORMATTER = new SimpleDateFormat("EE");
    private static final SimpleDateFormat HORA_FORMATTER = new SimpleDateFormat("HH");

    private Date firstTimestamp;
    private String diaDaSemana;
    private String hora;

    RichDate(Date firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
        this.diaDaSemana = DIA_DA_SEMANA_FORMATTER.format(firstTimestamp);
        this.hora = HORA_FORMATTER.format(firstTimestamp);
    }

}
