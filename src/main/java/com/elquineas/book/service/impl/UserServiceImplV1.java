package com.elquineas.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elquineas.book.model.UserDto;
import com.elquineas.book.persistance.UserDao;
import com.elquineas.book.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{


	protected final UserDao uDao;
	public UserServiceImplV1(UserDao uDao) {
		this.uDao = uDao;
	}
	
	
	@Override
	public List<UserDto> selectList() {
		List<UserDto> uList = uDao.selectList();
		return uList;
	}


	@Override
	public List<UserDto> findUser(String search) {
		List<UserDto> uList = uDao.findUser(search);
		return uList;
	}
	@Override
	public UserDto findByUser(UserDto uDto) {
		return uDao.findByUser(uDto);
	}

	@Override
	public UserDto findById(UserDto uDto) {
		return uDao.findById(uDto);
	}


	@Override
	public void insertUser(UserDto uDto) {
		uDao.insertUser(uDto);
	}


	@Override
	public void updateUser(UserDto uDto) {
		uDao.updateUser(uDto);
	}

}
