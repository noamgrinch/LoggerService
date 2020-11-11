package com.grinch.CentralLoggerService.Repositories;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.grinch.CentralLoggerService.BusinessLogic.Entities.Log;


public interface LogsRepository extends ElasticsearchRepository<Log,Long>{

}
