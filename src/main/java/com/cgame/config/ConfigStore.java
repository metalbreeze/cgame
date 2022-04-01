package com.cgame.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConfigurationProperties(prefix = "myconfig.config")
@Data
public class ConfigStore {
	public boolean isRedis =false;	
}



