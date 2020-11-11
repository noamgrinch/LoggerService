package com.grinch.CentralLoggerService.BusinessLogic.Entities;

import java.sql.Timestamp;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.grinch.CentralLoggerService.BusinessLogic.ContextMap;
import com.grinch.CentralLoggerService.BusinessLogic.Source;

import lombok.Data;
@Data
@Document(indexName = "logentries", type = "Log")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Log {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("logEntryDate")
	private String logEntryDate;
	@JsonProperty("logCreateDate")
	private Timestamp logCreateDate;
	@JsonProperty("application")
	private String application;
	@JsonProperty("level")
	private String logLevel;
	@JsonProperty("className")
	private String className;
	@JsonProperty("message")
	private String Message;
	@JsonProperty("loggerName")
	private String logger;
	private ContextMap contextMap;
	private Source source;

}
