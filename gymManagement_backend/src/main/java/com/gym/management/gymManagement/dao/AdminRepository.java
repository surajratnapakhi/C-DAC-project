package com.gym.management.gymManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gym.management.gymManagement.dao.ClientRepository.clientResultSet;
import com.gym.management.gymManagement.model.AdminMaster;
import com.gym.management.gymManagement.model.ClientMaster;

@Repository
public class AdminRepository {
	
	@Autowired
	public JdbcTemplate adminJdbcTemplate;
		
	public class adminrowmapper implements RowMapper < AdminMaster > {
		
	    public AdminMaster mapRow(ResultSet rs, int rownum) throws SQLException {
	    	AdminMaster admin = new AdminMaster();
	    	admin.setId(rs.getLong("id"));
	    	admin.setFirst_name(rs.getString("first_name"));
	    	admin.setLast_name(rs.getString("last_name"));
	    	admin.setPassword(rs.getString("password"));
	    	admin.setAge(rs.getInt("age"));
	    		    	
	        return admin;
	    }

}
public class adminResultSet implements ResultSetExtractor< AdminMaster > {
		

		public AdminMaster extractData(ResultSet rs) throws SQLException, DataAccessException {
			AdminMaster admin = new AdminMaster();
			while(rs.next()) {
				admin.setId(rs.getLong("id"));
				admin.setFirst_name(rs.getString("first_name"));
				admin.setLast_name(rs.getString("last_name"));
				admin.setPassword(rs.getString("password"));
				admin.setAge(rs.getInt("age"));
	    	return admin;
			}	
			return null;
	        
		}

}
public AdminMaster findClientbyName(String name) {
	AdminMaster client = adminJdbcTemplate.query("select * from admin where first_name=?", new Object[] {
	        name }, new adminResultSet());
	
    return client;
}

public AdminMaster findClientbyId(int id) {
    return adminJdbcTemplate.query("select * from admin where id=?", new Object[] {
        id }, new adminResultSet());
}

}
