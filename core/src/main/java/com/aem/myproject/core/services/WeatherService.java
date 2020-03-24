package com.aem.myproject.core.services;

import com.aem.myproject.core.WeatherClient;
import com.aem.myproject.core.entity.WeatherReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Component(service = WeatherService.class, immediate = true)
@Designate(ocd = Configuration.class)
public class WeatherService {
				
				private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);
				
				private static final String amsterdamCityId = "2759794";
				
				private WeatherClient weatherClient;
				private String url;
				private ObjectMapper objectMapper = new ObjectMapper();
				
				@Activate
				public void activate(Configuration configuration) {
								this.weatherClient = new WeatherClient(configuration.appId());
								this.url = configuration.url();
				}
				
				public WeatherReport getWeatherReport() {
								try {
												String response = weatherClient.getWeatherResponse(url, amsterdamCityId);
												return objectMapper.readValue(response, WeatherReport.class);
								} catch (IOException e) {
												LOG.error(e.getMessage(), e);
								}
								return null;
				}
				
}
