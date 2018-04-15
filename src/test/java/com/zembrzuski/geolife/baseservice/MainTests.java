package com.zembrzuski.geolife.baseservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void xoxoTest() throws ParseException, JsonProcessingException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = df.parse("01-01-1970 01:00");

		Event event = new Event("party", date);

		ObjectMapper mapper = new ObjectMapper();
//		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//		mapper.setDateFormat(df);

		mapper.writeValueAsString(event);

	}
}

class Event {

	private final String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private final Date date;

	public Event(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
}