package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Category;
import com.servicesapi.CategoryService;

@Controller
@RequestMapping("profile-CPD")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String page(){
		return "profile-CPD";
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Category category){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(categoryService.saveOrUpdate(category)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Category category){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Category> list = categoryService.list();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");
				
			}
		
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Category category){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(categoryService.delete(category)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
