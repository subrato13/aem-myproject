package com.aem.myproject.core.services.waterheights;

import com.adobe.acs.commons.genericlists.GenericList;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component(service = WaterHeightsService.class)
public class WaterHeightsService {
				
				private static final Logger LOG = LoggerFactory.getLogger(WaterHeightsService.class);
				private static final String SERVICE_USER = "water-heights-service";
				
				private static final String WATER_HEIGHTS_PATH = "/etc/acs-commons/lists/water-heights";
				
				@Reference
				private ResourceResolverFactory resourceResolverFactory;
				
				private ObjectMapper objectMapper = new ObjectMapper();
				
				/**
					* Get Water heights by limit
					*
					* @param limit no of results
					*
					* @return
					*/
				public List<ObjectNode> getWaterHeightsByLimit(int limit) {
								List<GenericList.Item> itemList = getWaterHeightList();
								List<ObjectNode> tempList = new ArrayList<>();
								if (limit > itemList.size()) {
												limit = itemList.size();
								}
								for (int i = 0; i < limit; i++) {
												ObjectNode objectNode = objectMapper.createObjectNode();
												objectNode.put("date", itemList.get(i).getTitle());
												objectNode.put("height", itemList.get(i).getValue());
												tempList.add(objectNode);
								}
								return tempList;
				}
				
				/**
					* Get Water level greater by heights
					* @param height height 
					* @return
					*/
				public List<ObjectNode> getWaterHeightsByHeight(int height) {
								List<GenericList.Item> itemList = getWaterHeightList();
								List<ObjectNode> tempList = new ArrayList<>();
								itemList.forEach(item -> {
												if (Integer.parseInt(item.getValue()) > height) {
																ObjectNode objectNode = objectMapper.createObjectNode();
																objectNode.put("date", item.getTitle());
																objectNode.put("height", item.getValue());
																tempList.add(objectNode);
												}
								});
								return tempList;
				}
				
				private List<GenericList.Item> getWaterHeightList() {
								ResourceResolver resourceResolver = getResourceResolver(resourceResolverFactory);
								PageManager pageManager = resourceResolver!= null ? resourceResolver.adaptTo(PageManager.class) : null;
								Page pageList = pageManager != null ? pageManager.getPage(WATER_HEIGHTS_PATH) : null;
								GenericList genericList = pageList != null ? pageList.adaptTo(GenericList.class) : null;
								List<GenericList.Item> itemList = genericList != null ? genericList.getItems() : Collections.emptyList();
								List<GenericList.Item> tempList = new ArrayList<>(itemList);
								tempList.sort(new DateComparator());
								return tempList;
				}
				
				private ResourceResolver getResourceResolver(final ResourceResolverFactory resourceFactory) {
								final Map<String, Object> param = new HashMap<>();
								param.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER);
								ResourceResolver resourceResolver = null;
								try {
												resourceResolver = resourceFactory.getServiceResourceResolver(param);
								} catch (final LoginException e) {
												LOG.error("Unable to get service resource resolver", e);
								}
								return resourceResolver;
				}
				
				// Helper comparator class used for sorting by dates
				public static class DateComparator implements Comparator<GenericList.Item> {
								
								@Override
								public int compare(GenericList.Item o1, GenericList.Item o2) {
												DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
												
												LocalDate localDate1 = LocalDate.parse(o1.getTitle(), sdf);
												LocalDate localDate2 = LocalDate.parse(o2.getTitle(), sdf);
												return localDate2.compareTo(localDate1);
								}
				}
				
}
