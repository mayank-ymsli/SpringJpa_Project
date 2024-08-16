package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Dao.MyUpdateDao;
import com.Dao.MyentityDao;
import com.entities.myentity;
import com.repository.SpringJPARepository;

@Service
public class Myservice {
	@Autowired
	private SpringJPARepository repository;

	public MyentityDao insert(MyentityDao dao) {
		
		myentity entity = myentity.builder()
		.name(dao.getName())
		.email(dao.getEmail())
		.password(dao.getPassword())
		.build();
		
		entity=repository.save(entity);
		dao=MyentityDao.builder()
				.name(entity.getName())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.build();
		return dao;
	}

	public List<MyentityDao> getAllData() {
		// TODO Auto-generated method stub
		List<myentity> entity=repository.findAll();
		
		List<MyentityDao> dao= entity.stream().map((e)->MyentityDao.builder()
				.name(e.getName())
				.email(e.getEmail())
				.password(e.getPassword()).build())
				.collect(Collectors.toList());
		return dao;
	}

	public MyentityDao getUpdate(MyUpdateDao dao) {
		// TODO Auto-generated method stub
		
		myentity entity=repository.findByEmail(dao.getEmail()).orElse(myentity.builder()
				.name(dao.getName())
				.email(dao.getEmail())
				.password(dao.getPassword())
				.build());
		entity.setName(dao.getName());
		entity.setEmail(dao.getEmail());
		entity.setPassword(dao.getPassword());
		
		entity = repository.save(entity);
		MyentityDao dao2 = MyentityDao.builder()
				.name(entity.getName())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.build();
		return dao2;
	}

	public MyentityDao getdelete(String email) {
		// TODO Auto-generated method stub
		myentity entity = repository.findByEmail(email).orElse(null);
		repository.delete(entity);
		
		return MyentityDao.builder()
				.name(entity.getName())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.build();
	}




}
