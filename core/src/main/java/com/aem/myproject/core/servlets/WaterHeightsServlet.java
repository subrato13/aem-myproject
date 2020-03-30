package com.aem.myproject.core.servlets;

import com.aem.myproject.core.services.waterheights.WaterHeightsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang.CharEncoding.UTF_8;

@Component(service = Servlet.class,
				property = {
								"sling.servlet.paths=" + "/bin/waterheights/list"
				})
@ServiceDescription("Water Heights Servlet")
public class WaterHeightsServlet extends SlingSafeMethodsServlet {
				
				@Reference
				private WaterHeightsService waterHeightsService;
				
				private ObjectMapper objectMapper = new ObjectMapper();
				
				@Override
				protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
								String limit = request.getParameter("limit");
								String waterHeight = request.getParameter("x");
								List<ObjectNode> itemList = new ArrayList<>();
								if (limit != null && !limit.trim().equals("")) {
												itemList = waterHeightsService.getWaterHeightsByLimit(Integer.parseInt(limit));
								}
								
								if (waterHeight != null && !waterHeight.trim().equals("")) {
												itemList = waterHeightsService.getWaterHeightsByHeight(Integer.parseInt(waterHeight));
								}
								
								String result = objectMapper.writeValueAsString(itemList);
								response.setContentType("application/json");
								response.setCharacterEncoding(UTF_8);
								response.setHeader("Cache-Control", "no-store");
								response.getWriter().write(result);
				}
}
