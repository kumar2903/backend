package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Login;
import com.example.demo.Repository.LoginRepository;
@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
public Login saveUser(Login u)
{
	  return loginRepository.save(u);
}
public String validateUser(String username,String password)
{
	String result="";
	Login u=loginRepository.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
	

}
