package com.elquineas.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elquineas.book.model.BookDto;
import com.elquineas.book.persistance.BookDao;
import com.elquineas.book.service.BookService;

@Service
public class BookServiceImplV1 implements BookService{
	protected final BookDao bDao;
	public BookServiceImplV1(BookDao bDao) {
		this.bDao = bDao;
	}
	
	@Override
	public void insertBook(BookDto bDto) {
		bDao.insertBook(bDto);
	}

	@Override
	public void updatetBook(BookDto bDto) {
		bDao.updateBook(bDto);
		
	}

	@Override
	public List<BookDto> selectList() {
		return bDao.selectList();
	}

	@Override
	public BookDto findById(BookDto bDto) {
		return bDao.findbyCode(bDto);
	}

	@Override
	public List<BookDto> findBook(String search) {
		return bDao.findBook(search);
	}

	@Override
	public BookDto findByName(BookDto bDto) {
		return bDao.findbyName(bDto);
	}


}
