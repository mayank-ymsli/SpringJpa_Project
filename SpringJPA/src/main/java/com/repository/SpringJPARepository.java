package com.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.myentity;
public interface SpringJPARepository extends JpaRepository<myentity, Integer> {

	Optional<myentity> findByEmail(String email);
	

}
