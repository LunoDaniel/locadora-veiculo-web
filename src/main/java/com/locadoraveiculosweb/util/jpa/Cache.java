package com.locadoraveiculosweb.util.jpa;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.Getter;

@Startup
@Singleton
public class Cache<T> {
	
	@Getter
	Map<String, Object> cache;
	
	@PostConstruct
	@Schedule(minute = "1", hour = "*", persistent = false)
	public void initializer() {
		cache = new HashMap<>();
	}
	
	public boolean isInCache(String key) {
		return cache.containsKey(key) && !isEmpty(cache.get(key));
	}
	
	@Lock(LockType.READ)
	public Object getValue(String key){
	    return cache.get(key);
	}
	
	@Lock(LockType.WRITE)
	public void putValue(String key, Object values) {
		cache.put(key, values);
	}
	
}
