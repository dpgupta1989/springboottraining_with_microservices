package com.example.springboot.training.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	 Item addItem(Item item){
		 return itemRepository.save(item);
	 }

	public String getItemDemandWithoutHystrix() {
			return restTemplate.getForObject("http://localhost:9001/demand/getDemand", String.class);
	}
	 
//	Hystrix allows us to configure multiple properties using the @HystrixProperty annotation, 
//	here demonstrated 3 of those properties but you can use the ones required for your use case.
//	When calls to service made using rest template exceeds requestVolumeThreshold and  
//	failure percentage is greater than errorThresholdPercentage 
//	in a rolling window defined by timeInMilliseconds, the circuit opens and the call is not made 
//	In cases of error and an open circuit, the fallback method will be called 
//	which sends a predefined message.
	@HystrixCommand(fallbackMethod = "itemDemandFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4") })
	public String getItemDemand() {
		return restTemplate.getForObject("http://localhost:9001/demand/getDemand", String.class);
	}
	
	public String itemDemandFallback() {
		return "Get Item Demand Fallback Method Called";
	}
	
	@HystrixCommand(fallbackMethod = "addItemDemandFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4") })
	public String addItemDemand(Item item) {
		return restTemplate.postForObject("http://localhost:9001/demand/addDemand", item, String.class);
	}
	
	public String addItemDemandFallback(Item item) {
		return " Add Item Demand Fallback Method Called";
	}
}
