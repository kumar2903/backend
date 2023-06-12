package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Login;

//@Repository//
public interface LoginRepository extends JpaRepository< Login ,Integer> {
	Login findByUsername(String username);


}
