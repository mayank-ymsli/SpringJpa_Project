package com.controller;
import com.Dao.MyUpdateDao;
import com.Dao.MyentityDao;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.service.Myservice;

import lombok.RequiredArgsConstructor;

@RestController    //combination of controller and response body
@RequiredArgsConstructor

public class Mycontroller {
	private final Myservice service;
	@PostMapping("/insert")
	public MyentityDao insert(@RequestBody MyentityDao dao) {
		System.out.println(dao);
		return service.insert(dao);
	}
	@GetMapping("/get")
	public List<MyentityDao> getAllData(){
		return service.getAllData();
	}
	@PutMapping("/update")
	public MyentityDao update(@RequestBody MyUpdateDao dao) {
		return service.getUpdate(dao);
	}
	@DeleteMapping("/delete/{email}")
	public MyentityDao delete(@PathVariable("email") String email) {
		return service.getdelete(email);
	}

}
