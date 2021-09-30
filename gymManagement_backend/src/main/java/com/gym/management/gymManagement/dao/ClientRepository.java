package com.gym.management.gymManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gym.management.gymManagement.model.ClientMaster;
import com.gym.management.gymManagement.util.Clientrowmapper;

@Repository
public class ClientRepository {
	@Autowired
	public JdbcTemplate clientJdbcTemplate;
		
	public class Clientrowmapper implements RowMapper < ClientMaster > {
		
	    public ClientMaster mapRow(ResultSet rs, int rownum) throws SQLException {
	    	ClientMaster client = new ClientMaster();
	    	client.setId(rs.getLong("id"));
	    	client.setFirst_name(rs.getString("first_name"));
	    	client.setLast_name(rs.getString("last_name"));
	    	client.setPassword(rs.getString("password"));
	    	client.setAge(rs.getInt("age"));
	    		    	
	        return client;
	    }

}
public class clientResultSet implements ResultSetExtractor< ClientMaster > {
		

		public ClientMaster extractData(ResultSet rs) throws SQLException, DataAccessException {
			ClientMaster client = new ClientMaster();
			while(rs.next()) {
	    	client.setId(rs.getLong("id"));
	    	client.setFirst_name(rs.getString("first_name"));
	    	client.setLast_name(rs.getString("last_name"));
	    	client.setPassword(rs.getString("password"));
	    	client.setAge(rs.getInt("age"));
	    	return client;
			}	
			return null;
	        
		}

}
	public List<ClientMaster> findAll() {
	   List<ClientMaster> listOfClient =  clientJdbcTemplate.query("select * from client",  new Clientrowmapper());
	   return listOfClient;
	}

	public int addClient(ClientMaster client){
		 return clientJdbcTemplate.update("insert into client (first_name, last_name,password, age) " + "values(?,  ?, ?, ?)",
			        new Object[] {
			        		client.getFirst_name(), client.getLast_name(),client.getPassword(), client.getAge()
			        });
	}
	public int deleteClientbyid(long id) {
	    return clientJdbcTemplate.update("delete from client where id=?", new Object[] {
	        id
	    });
	}
	
	public ClientMaster findClientbyName(String name) {
		ClientMaster client = clientJdbcTemplate.query("select * from client where first_name=?", new Object[] {
		        name }, new clientResultSet());
		
	    return client;
	}
	
	public ClientMaster findClientbyId(int id) {
	    return clientJdbcTemplate.query("select * from client where id=?", new Object[] {
	        id }, new clientResultSet());
	}

	public int modifyClient(ClientMaster client) {
	    return clientJdbcTemplate.update("update client " + " set first_name = ?, last_name = ?, password = ?, age = ? " + " where id = ?",
	        new Object[] {
	        		client.getFirst_name(), client.getLast_name(), client.getPassword(), client.getAge(), client.getId()
	        });
	}
}
