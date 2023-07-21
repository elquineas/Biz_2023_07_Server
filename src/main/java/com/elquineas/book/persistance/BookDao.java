package com.elquineas.book.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.elquineas.book.model.BookDto;

public interface BookDao {
	@Select(" SELECT * FROM tbl_books ")
	public List<BookDto> selectList();
	@Select(" SELECT * FROM tbl_books WHERE b_code = #{b_code}")
	public BookDto findbyCode(BookDto bDto);

	public int insertBook(BookDto bDto);
	public int updateBook(BookDto bDto);
	public List<BookDto> findBook(String search);

	@Select(" SELECT * FROM tbl_books WHERE b_name = #{b_name}")
	public BookDto findbyName(BookDto bDto);

}
