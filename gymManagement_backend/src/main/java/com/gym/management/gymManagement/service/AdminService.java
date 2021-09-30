package com.gym.management.gymManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.management.gymManagement.dao.AdminRepository;
import com.gym.management.gymManagement.model.AdminMaster;
import com.gym.management.gymManagement.model.ClientMaster;
import com.gym.management.gymManagement.model.LoginRequest;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public String validateUser(LoginRequest loginRequest){
		AdminMaster user = new AdminMaster();
				user = adminRepository.findClientbyName(loginRequest.getUserName());
		String message;
		
		if(user == null) {
			message = "User not found";
		}
		else if(user.getFirst_name().equals(loginRequest.getUserName()) && user.getPassword().equals(loginRequest.getPassword()))
		{
			message = "User is successfully authenticate";
		}else {
			message = "Invalid login credentials";
		}
		return message;
	}
	public String login(LoginRequest loginRequest){
	return validateUser(loginRequest);
	}
}
