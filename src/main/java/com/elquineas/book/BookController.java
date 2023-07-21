package com.elquineas.book;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elquineas.book.model.BookDto;
import com.elquineas.book.persistance.BookDao;
import com.elquineas.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

	private final BookService bService;
	public BookController(BookService bService) {
		this.bService = bService;
	}
	
}
