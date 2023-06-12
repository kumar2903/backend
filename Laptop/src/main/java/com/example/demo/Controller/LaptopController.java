package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Laptop;

import com.example.demo.Service.LaptopService;


import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class LaptopController {
	@Autowired
	LaptopService laptopService;
	@Tag(name="Get",description="get data")
	 @GetMapping(value="/fetchLaptop")
	 public List<Laptop> getAllShoes(      )
	 {
		 List<Laptop> shoeList=laptopService.getAllLaptops();
		 return shoeList;
	 }


	@Tag(name="Post",description="post data")
	 @PostMapping(value="/saveLaptops")
	 public Laptop saveShoe(@RequestBody Laptop s)
	 {
		 return laptopService.saveLaptop(s);
	 }
	@Tag(name="Put",description="put data")
	 @PutMapping(value="/updateLaptop")
	 public Laptop updateShoe(@RequestBody Laptop s)
	 {
		 return laptopService.updateLaptops(s);
	 }
	@Tag(name="Delete",description="delete data")
	 @DeleteMapping(value="/deleteLaptop/{rno}")
	 public void deleteLaptop(@PathVariable("rno") int price )
	 {
		 laptopService.deleteLaptops(price);
	 }
	 //sorting
	 @GetMapping("/sortLaptops/{field}")
	 public List<Laptop>sortLaptop(@PathVariable String field)
	 {
	 	return laptopService.sortLaptops(field);
	 }

	 ///pagination

//	      http://localhost:8080/pageStudents/0/1

	 @GetMapping("/pagingLaptops/{offset}/{pageSize}")
	 public List<Laptop> pagigLaptops(@PathVariable int offset,@PathVariable int pageSize)
	 {
	 	return laptopService.pagingLaptops(offset,pageSize);
	 }
	//pagination and sorting
	@GetMapping("/pageAndSortingLaptops/{offset}/{pageSize}/{field}")
	public List<Laptop>pagingAndSortingEmployees(@PathVariable int offset,@PathVariable int  pageSize,@PathVariable String field)
	{
		return laptopService.pagingAndSortingEmployees(offset,pageSize,field);
	}

}
