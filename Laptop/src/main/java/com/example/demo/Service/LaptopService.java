package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Laptop;
import com.example.demo.Repository.LaptopRepository;


@Service
public class LaptopService {
	@Autowired
	LaptopRepository laptopRepository;
	 public List<Laptop>getAllLaptops()
	 {
		 List<Laptop> shoeList=laptopRepository.findAll();
		 return shoeList; 
	}
	 public Laptop saveLaptop(Laptop s)
	 {
		 Laptop obj=laptopRepository.save(s);
		 return obj;
		 //return studRepository.save(s);
	 }
	 public Laptop updateLaptops( Laptop s)
	 {
		 Laptop obj=laptopRepository.save(s);
		 return obj;
		 //return studRepository.save(s);
	 }
	 public void deleteLaptops(int price)
	 {
		 laptopRepository.deleteById(price);
	 }
	 //sorting
	 public List<Laptop> sortLaptops(String field)
	 {
		//ascending findAll(sort sort) and no change in controller method for both//
		 return laptopRepository.findAll(Sort.by(field));
		 
		 //descending findAll(Sort.by(Direction,field))
		 //return studRepository.findAll(Sort.by(Direction.DESC, field));
	 }
	 
	 
	 //pagination
	 
	 public List<Laptop> pagingLaptops(int offset,int pageSize)
	 {
		 Pageable paging=PageRequest.of(offset,pageSize);
		 Page<Laptop> studData=laptopRepository.findAll(paging);
		 List<Laptop>studList=studData.getContent();
		 return studList;
	 }
	//pagination and sorting
	public List<Laptop> pagingAndSortingEmployees(int offset,
			int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			Page<Laptop> stud=laptopRepository.findAll(paging);
			return stud.getContent();
		}


}
