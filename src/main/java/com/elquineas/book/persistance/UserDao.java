package com.elquineas.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.elquineas.book.model.UserDto;

public interface UserDao {
	@Select(" SELECT * FROM tbl_users ")
	public List<UserDto> selectList();

	public List<UserDto> findUser(String search);

	@Select(" SELECT * FROM tbl_users WHERE u_code = #{u_code} AND u_tel = #{u_tel}")
	public UserDto findByUser(UserDto uDto);

	@Select(" SELECT * FROM tbl_users WHERE u_code = #{u_code} ")
	public UserDto findById(UserDto uDto);

	public void insertUser(UserDto uDto);

	public void updateUser(UserDto uDto);

}
