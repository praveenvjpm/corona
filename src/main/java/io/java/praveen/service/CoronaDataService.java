package io.java.praveen.service;

import java.io.StringReader;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoronaDataService {

	public static final String URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
    
	@PostConstruct
	public String fetchData() {

		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		//Reader in;
		try {
			//in = new FileReader("path/to/file.csv");
			StringReader  in = new StringReader(rest.exchange(URL, HttpMethod.GET, entity, String.class).getBody());
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				String id = record.get("Province/State");
				String country = record.get("Country/Region");
				String lat = record.get("Lat");
				String date = record.get("2/27/20");
				System.out.println("Province/State="+id+"- \t Country/Region"+country+"- \t Lat,Long"+lat+"\t Date"+date);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rest.exchange(URL, HttpMethod.GET, entity, String.class).getBody();

	}
	
	@Scheduled(cron="* * * * * * ")
	public void testService() {
		System.out.println("Executiong Cron Job");
	}

}
