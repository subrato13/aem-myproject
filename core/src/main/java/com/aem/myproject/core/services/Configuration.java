package com.aem.myproject.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Weather Service Configuration",
				description = "Weather Configuration ")
public @interface Configuration {
				
				@AttributeDefinition(name = "App Id", description = "App Id for Weather Service", type = AttributeType.STRING)
				String appId();
				
				@AttributeDefinition(name = "Url", description = "URL for Weather Service", type = AttributeType.STRING)
				String url();
}
