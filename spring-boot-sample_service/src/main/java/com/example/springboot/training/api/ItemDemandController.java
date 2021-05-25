package com.example.springboot.training.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demand")
public class ItemDemandController {

//	http://localhost:9001/demand/getDemand
	@GetMapping("/getDemand")
	public String getAllDemand() {
		return "Item Demand Fetched";
	}

//	http://localhost:9001/demand/addDemand
	@PostMapping("/addDemand")
	public String addItemDemand(@RequestBody Item item) {
		return "Item Demand Details Added";
	}
}
