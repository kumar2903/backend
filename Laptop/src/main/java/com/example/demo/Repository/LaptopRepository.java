package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Laptop;


public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

}
