package com.grinch.CentralLoggerService.BusinessLogic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContextMap {

	@JsonProperty("traceId")
	private String BTMID;
}
