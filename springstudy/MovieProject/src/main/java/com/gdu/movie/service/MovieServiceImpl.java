package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> getMovieList() {
		return movieMapper.selectAllMovies();
	}
	
	@Override
	public Map<String, Object> findMovie(HttpServletRequest request) {
		String target = request.getParameter("target");
		String param = request.getParameter("param");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("param", param);
		
		List<MovieDTO> list = movieMapper.selectMoviesByQuery(map);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(list.size() == 0) {
			result.put("status", 400);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}
		return result;
	}
	
	
	
}
