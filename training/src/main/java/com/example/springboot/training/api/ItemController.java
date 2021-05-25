package com.example.springboot.training.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired    
	private ItemService itemService;    
	
	private static final Logger LOGGER = LogManager.getLogger(ItemController.class);
	
	@GetMapping("/get")
	public List<Item> getAllItems() {
		LOGGER.info("@@@@Controller getAllItems() info is called");
		return itemService.getAllItems();
	}
	@PostMapping("/add")
	public Item addItem(@RequestBody Item item) {
		LOGGER.info("Controller addItem() is called");
		return itemService.addItem(item);
	}
	
	@GetMapping("/getItemDemand")
	public String getItemDemand() {
		return itemService.getItemDemand();
	}
	
	@GetMapping("/getItemDemandWithoutHystrix")
	public String getItemDemandWithoutHystrix() {
		return itemService.getItemDemandWithoutHystrix();
	}
	
	@PostMapping("/addItemDemand")
	public String addItemDemand(@RequestBody Item item) {
		return itemService.addItemDemand(item);
	}
	
}
