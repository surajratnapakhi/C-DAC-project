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
import com.gym.management.gymManagement.service.ClientService;

@RestController
@RequestMapping(path = "/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "Hi";
		}
	
	@PostMapping(path = "/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return clientService.login(loginRequest);
	}
		
	@PostMapping(path = "/client")
	public void addClient(@RequestBody ClientMaster client) {
		int status = clientService.addClient(client);
		System.out.println(status);
		
	}
	
	@DeleteMapping(path = "/client")
	public String  deleteClient(@RequestParam long id) {
		return clientService.deleteClientbyid(id);
	}
	
	@PutMapping(path = "/client")
	public String modifyClient(@RequestBody ClientMaster client) {
		return clientService.modifyClient(client);
	}
	
	@GetMapping(path = "/client/find")
	public ClientMaster getClientById (@RequestParam int id) {
		return clientService.findById(id);
	}
}
