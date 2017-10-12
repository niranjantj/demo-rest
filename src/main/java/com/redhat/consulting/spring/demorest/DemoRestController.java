package com.redhat.consulting.spring.demorest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Rest API 
 * 
 * @author dsancho
 *
 */
@RestController
public class DemoRestController {
	
	@RequestMapping(method=RequestMethod.GET, path="/demo")
	Collection<Integer> getOrderedRandomList() {
		Collection<Integer> collection = new ArrayList<>();
		int number = 0;
		for (int i=0; i<5; i++) {
			number = number + new Random().nextInt(100);
			collection.add(number);
		}
		return collection;
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/demo")
	Integer sum(@RequestBody List<Integer> numbers) {
		int result= 0;
		if (numbers!=null && numbers.size()>0 ) {
			for (int number : numbers) {
				result += number;
			}
		}
		return result;
	}
	

}
