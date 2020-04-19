package com.locadoraveiculosweb.util.jpa;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Startup
@Singleton
@Log4j
public class Cache<T> {
	
	@Getter
	Map<String, Object> cache;
	
	@PostConstruct
	public void initializer() {
		newIntance();
	}
	
	@Schedule(dayOfMonth = "*", hour = "*/1", persistent = false)
	public void newIntance() {
		cache = new HashMap<>();
		log.info("Cleaning the Cache.");
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
	
	@SuppressWarnings("unchecked")
	public void removeValue(Object object, String key) {
		if(isInCache(key)) {
			
			List<T> list = (List<T>) cache.get(key);
			
			if(list.contains(object)) {
				list.remove(object);
			}
		}
	}
	
}
