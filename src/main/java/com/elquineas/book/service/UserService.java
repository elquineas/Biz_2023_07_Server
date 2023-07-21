package com.elquineas.book.service;

import java.util.List;

import com.elquineas.book.model.BookDto;
import com.elquineas.book.model.UserDto;

public interface UserService {

	public List<UserDto> selectList();

	public List<UserDto> findUser(String search);

	public UserDto findByUser(UserDto uDto);

	public UserDto findById(UserDto uDto);

	public void insertUser(UserDto uDto);

	public void updateUser(UserDto uDto);

}
