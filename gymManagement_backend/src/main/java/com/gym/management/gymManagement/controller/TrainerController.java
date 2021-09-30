package com.gym.management.gymManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.management.gymManagement.model.ClientMaster;
import com.gym.management.gymManagement.service.ClientService;

@RestController
@RequestMapping(path = "/trainer")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping(path = "/allClients")
	public List<ClientMaster> getAllClients(){
		return clientService.getAllClient();
	}
	
	@GetMapping(path = "/clientbById")
	public ClientMaster findById(@RequestParam int id) {
		return clientService.findById(id);
	}
	
	@PutMapping(path = "/client")
	public String modifyClient(@RequestBody ClientMaster client) {
		return clientService.modifyClient(client);
	}
}
