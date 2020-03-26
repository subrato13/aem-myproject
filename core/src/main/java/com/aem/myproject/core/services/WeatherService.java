package com.aem.myproject.core.services;

import com.aem.myproject.core.WeatherClient;
import com.aem.myproject.core.entity.Properties;
import com.aem.myproject.core.entity.WeatherReport;
import com.aem.myproject.core.entity.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Component(service = WeatherService.class, immediate = true)
@Designate(ocd = Configuration.class)
public class WeatherService {
				
				private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);
				
				private WeatherClient weatherClient;
				private String url;
				private ObjectMapper objectMapper = new ObjectMapper();
				
				@Activate
				public void activate(Configuration configuration) {
								this.weatherClient = new WeatherClient(configuration.appId());
								this.url = configuration.url();
				}
				
				/**
					* Get Weather Report
					*
					* @param cityId cityId
					*
					* @return weather report
					*/
				public WeatherReport getWeatherReport(String cityId) {
								try {
												String response = weatherClient.getWeatherResponse(url, cityId);
												WeatherResponse weatherResponse = objectMapper.readValue(response, WeatherResponse.class);
												return populateReport(weatherResponse);
								} catch (IOException e) {
												LOG.error(e.getMessage(), e);
								}
								return null;
				}
				
				/**
					* Populate Wether Report Response
					*
					* @param weatherResponse weather Response
					*
					* @return weather report
					*/
				private WeatherReport populateReport(WeatherResponse weatherResponse) {
								WeatherReport weatherReport = new WeatherReport();
								
								weatherReport.setCountryCode(weatherResponse.getSys().getCountry());
								weatherReport.setCityName(weatherResponse.getName());
								float kelvin = weatherResponse.getMain().getTemp();
								float celsius = (float) Math.ceil(kelvin - 273.15F);
								weatherReport.setTemperature(String.valueOf(celsius));
								weatherReport.setPressure(String.valueOf(weatherResponse.getMain().getPressure()));
								weatherReport.setHumidity(String.valueOf(weatherResponse.getMain().getHumidity()));
								List<Properties> propertiesList = weatherResponse.getWeather();
								if (!propertiesList.isEmpty()) {
												weatherReport.setWeatherType(propertiesList.get(0).getMain());
												weatherReport.setWeatherDescription(propertiesList.get(0).getDescription());
								}
								String sunrise = millisecondsToTime(weatherResponse.getSys().getSunrise());
								String sunset = millisecondsToTime(weatherResponse.getSys().getSunset());
								weatherReport.setSunrise(sunrise);
								weatherReport.setSunset(sunset);
								weatherReport.setLatitude(weatherResponse.getCoord().getLat());
								weatherReport.setLongitude(weatherResponse.getCoord().getLon());
								Date date = new Date();
								SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
								formatter.setTimeZone(TimeZone.getTimeZone("CET"));
								weatherReport.setCurrentDateTime(formatter.format(date));
								weatherReport.setWindSpeed(weatherResponse.getWind().getSpeed());
								return weatherReport;
				}
				
				private String millisecondsToTime(Long milliseconds) {
								Date date = new Date(milliseconds * 1000);
								SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
								formatter.setTimeZone(TimeZone.getTimeZone("CET"));
								return formatter.format(date);
				}
}
