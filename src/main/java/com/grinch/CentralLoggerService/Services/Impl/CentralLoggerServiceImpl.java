package com.neogames.CentralLoggerService.Services.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.neogames.CentralLoggerService.BusinessLogic.Entities.Log;
import com.neogames.CentralLoggerService.Repositories.LogsRepository;
import com.neogames.CentralLoggerService.Services.CentralLoggerService;

@Service
public class CentralLoggerServiceImpl implements CentralLoggerService{

	@Autowired
	private LogsRepository repository;
	@Autowired
	private ObjectMapper mapper;
	
	@KafkaListener(topics = "LogQueue", groupId = "group_id")
    public void receiveMessage(String message) {
		try {	
			Log log = mapper.readValue(message, Log.class);
			if(log.getLogger()!=null) {
				String[] split = log.getLogger().split(Pattern.quote("."));
				log.setClassName(split[split.length-1]);
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
			log.setLogEntryDate(simpleDateFormat.format(new Date()));
			log.setId(UUID.randomUUID().toString().replace("-", ""));
			this.repository.save(log);
		}
		catch(Exception e) {
			System.out.println("Failed to map message " + message);
			System.out.println(Throwables.getStackTraceAsString(e));
		}
    }

}
