package com.aem.myproject.core;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherClient {
				private static final Logger LOG = LoggerFactory.getLogger(WeatherClient.class);
				private String appId;
				
				private CloseableHttpClient httpClient = HttpClients.createDefault();
				
				public WeatherClient(String appId) {
								this.appId = appId;
				}
				
				public String getWeatherResponse(String url,String cityId)throws IOException{
								return getRequest(url,cityId);
				}
				
				private String getRequest(String url,String cityId) throws IOException {
								HttpGet httpGet = null;
								try {
												URIBuilder uriBuilder = new URIBuilder(url);
												uriBuilder.setParameter("id",cityId);
												uriBuilder.setParameter("appid",appId);
												
												httpGet = new HttpGet(uriBuilder.build());
								} catch (URISyntaxException e) {
												LOG.error(e.getMessage(), e);
								}
								
								try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
												HttpEntity entity = response.getEntity();
												return EntityUtils.toString(entity);
								} catch (IOException e) {
												LOG.error(e.getMessage(), e);
								}
								return null;
				}
}
