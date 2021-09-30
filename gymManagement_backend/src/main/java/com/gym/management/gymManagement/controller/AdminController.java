package com.gym.management.gymManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.management.gymManagement.model.ClientMaster;
import com.gym.management.gymManagement.model.LoginRequest;
import com.gym.management.gymManagement.service.AdminService;
import com.gym.management.gymManagement.service.ClientService;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return adminService.login(loginRequest);
	}
	
	@GetMapping(path = "/allClients")
	public List<ClientMaster> getAllClients(){
		return clientService.getAllClient();
	}
	@DeleteMapping(path = "/client")
	public String  deleteClient(@RequestParam long id) {
		return clientService.deleteClientbyid(id);
	}
	
	@PutMapping(path = "/client")
	public String modifyClient(@RequestBody ClientMaster client) {
		return clientService.modifyClient(client);
	}
}
