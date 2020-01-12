package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StdDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Student s) {
		String sql = "insert into mydb(stdId, stdName, age, gender, dob) values('"+s.getStdId()+"', "+s.getStdName()+", '"+s.getAge()+"', "+s.getGender()+",'"+s.getDob()+"')";
		return template.update(sql);
	}
	
	public int update(Student s){    
	    String sql="update mydb set stdId='"+s.getStdId()+"', stdName="+s.getStdName()+", age='"+s.getAge()+"', gender="+s.getGender()+", dob='"+s.getDob()+"' where StdId="+s.getStdId()+"";
	    return template.update(sql);
	}
	
	public int delete(String stdId) {
		String sql = "delete from mydb where stdId="+stdId+"";    
	    return template.update(sql);
	}
	
	public Student getStudentById(String stdId){    
	    String sql="select * from mydb where stdId=?";    
	    return template.queryForObject(sql, new Object[]{stdId},new BeanPropertyRowMapper<Student>(Student.class));    
	} 
	
	public List<Student> getStudents(){    
	    return template.query("select * from mydb",new RowMapper<Student>(){    
	        public Student mapRow(ResultSet rs, int row) throws SQLException {    
	            Student std = new Student();    
	            std.setStdId(rs.getString(1));    
	            std.setStdName(rs.getString(2));    
	            std.setAge(rs.getInt(3));    
	            std.setGender(rs.getString(4).charAt(0));    
	            std.setDob(rs.getDate(5));    

	            return std;    
	        }    
	    });    
	}   

}