package com.Dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyentityDao  {
	
	private int id;
	private String name;
	private String email;
	private String password;

}
