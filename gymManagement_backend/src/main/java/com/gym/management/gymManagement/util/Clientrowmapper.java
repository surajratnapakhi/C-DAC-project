package com.gym.management.gymManagement.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gym.management.gymManagement.model.ClientMaster;

public class Clientrowmapper implements RowMapper < ClientMaster > {
	
	    public ClientMaster mapRow(ResultSet rs, int rownum) throws SQLException {
	    	ClientMaster client = new ClientMaster();
	    	client.setId(rs.getLong("id"));
	    	client.setFirst_name(rs.getString("first_name"));
	    	client.setLast_name(rs.getString("last_name"));
	    	client.setAge(rs.getInt("age"));
	    		    	
	        return client;
	    }

}
