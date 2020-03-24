package com.aem.myproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {
				
				@Inject
				private String title;
				
				@Inject
				private String buttonTitle;
				
				@Inject
				private String text;
				
				@Inject
				private String fileReference;
				
				@Inject
				private String link;
				
				@SlingObject
				private Resource currentResource;
				
				
				public String getTitle() {
								return title;
				}
				
				private String getProperty(String propertyName) {
								ValueMap valueMap = currentResource.getValueMap();
								return valueMap.get(propertyName, String.class);
				}
				
				public String getButtonTitle() {
								return buttonTitle;
				}
				
				public String getText() {
								return text;
				}
				
				public String getFileReference() {
								return fileReference;
				}
				
				public String getLink() {
								return link;
				}
}
