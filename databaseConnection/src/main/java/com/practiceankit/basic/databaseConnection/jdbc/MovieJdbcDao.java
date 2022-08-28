package com.practiceankit.basic.databaseConnection.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practiceankit.basic.databaseConnection.entity.Movie;

@Repository
public class MovieJdbcDao {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	class MovieMapper implements RowMapper<Movie>{
		

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Movie movie =new Movie();
			movie.setId(rs.getInt("id"));
			movie.setName(rs.getString("name"));
			movie.setBudget(rs.getInt("budget"));
			movie.setGenre(rs.getString("genre"));
			return movie;
		}
		
		
	}
	
	public List<Movie>  findAll(){
		return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));	
	}
//	public List<Movie>  findAll(){
//		return jdbcTemplate.query("select * from movie", new MovieMapper());	
//	}
	
	
	@SuppressWarnings("deprecation")
	public Movie  findById(Integer id){
		
	return jdbcTemplate.queryForObject("select * from movie where id=?",new Object[] {id},
			new BeanPropertyRowMapper<Movie>(Movie.class));	
	}
	
	public int  insertAMovie(Movie movie){
		
		 return jdbcTemplate.update("insert into movie (id,name,budget,genre) "+" values(?,?,?,?)",
				new Object[] { movie.getId(), movie.getName(), movie.getBudget(), movie.getGenre()}) ;
		}
	
	public int deleteById(Integer id) {
		return jdbcTemplate.update("delete from movie where id=?",new Object [] {id});
	}
	
	
	
	
	
	
	

}
