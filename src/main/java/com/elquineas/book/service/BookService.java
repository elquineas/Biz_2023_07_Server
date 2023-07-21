package com.elquineas.book.service;

import java.util.List;

import com.elquineas.book.model.BookDto;

public interface BookService {
	public List<BookDto> selectList();
	public BookDto findById(BookDto bDto);
	public BookDto findByName(BookDto bDto);
	public void insertBook(BookDto bDto);
	public void updatetBook(BookDto bDto);
	public List<BookDto> findBook(String search);

}
