package com.neogames.CentralLoggerService.Repositories;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.neogames.CentralLoggerService.BusinessLogic.Entities.Log;


public interface LogsRepository extends ElasticsearchRepository<Log,Long>{

}
