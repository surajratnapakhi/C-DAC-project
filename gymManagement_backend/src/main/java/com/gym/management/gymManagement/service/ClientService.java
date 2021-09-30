package com.gym.management.gymManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.management.gymManagement.dao.ClientRepository;
import com.gym.management.gymManagement.model.ClientMaster;
import com.gym.management.gymManagement.model.LoginRequest;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public String addClient() {
		return "Client Successfully added";
		
	}
	
	public List<ClientMaster> getAllClient(){
		return clientRepository.findAll();
	}
	
	public int addClient(ClientMaster client){
		return clientRepository.addClient(client);		
	}
	
	public String deleteClientbyid(long id) {
		 clientRepository.deleteClientbyid(id);
		return "Client Deleted Successfully";
	}
	
	public String modifyClient(ClientMaster client) {
		if(client.getFirst_name() != null && client.getLast_name() != null && client.getPassword() != null && client.getAge()!=0 && client.getId() !=0) {
		clientRepository.modifyClient(client);
		return "Client Modify Successfully";
		}else {
			return "Client modification failed";
		}
	}
	public ClientMaster findById(int id) {
		return clientRepository.findClientbyId(id);
	}
	
	public String validateUser(LoginRequest loginRequest){
		ClientMaster user = new ClientMaster();
				user = clientRepository.findClientbyName(loginRequest.getUserName());
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
