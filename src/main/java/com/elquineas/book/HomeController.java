package com.elquineas.book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elquineas.book.model.BookDto;
import com.elquineas.book.model.UserDto;
import com.elquineas.book.service.BookService;
import com.elquineas.book.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final UserService uService;
	private final BookService bService;
	public HomeController(BookService bService,UserService uService) {
		this.bService = bService;
		this.uService = uService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("BOOK") BookDto bDto, Model model) {
		List<BookDto> bList = bService.selectList();
		model.addAttribute("BOOK",bDto);
		model.addAttribute("SORT","I");
		model.addAttribute("BOOKS",bList);
		model.addAttribute("BOOK_SEARCH","");
		model.addAttribute("MAIN","BOOK");
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public BookDto insert(@ModelAttribute("BOOK") BookDto bDto,String code, Model model) {
		log.debug("SAVE DATA : {}",bDto);
//		bDto.setB_code(code);		
		BookDto resultDto = bService.findById(bDto);
		model.addAttribute("BOOK",bDto);
		if(resultDto != null) {
			bDto = bDto.builder()
					.b_code("NOT_CODE")
					.build();
			return bDto;
		}
		resultDto = bService.findByName(bDto);
		model.addAttribute("BOOK",bDto);
		if(resultDto != null) {
			bDto = bDto.builder()
					.b_code("NOT_NAME")
					.build();
			return bDto;
		}
		return bDto;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("BOOK") BookDto bDto, String sort, Model model) {
		BookDto resultDto = bService.findById(bDto);
		log.debug("체크 : {}",sort);
		if(sort.equals("I") || resultDto == null) {
			bService.insertBook(bDto);
		}else if(sort.equals("U")) {
			bService.updatetBook(bDto);
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update_check", method = RequestMethod.GET)
	public BookDto update_check(@ModelAttribute("BOOK") BookDto bDto,String code, Model model) {
		log.debug("SAVE DATA : {}",bDto);
		bDto = bService.findById(bDto);
		return bDto;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String search, Model model) {
		List<BookDto> resultList = bService.findBook(search);
		log.debug("체크 : {}",search);
		
		model.addAttribute("SORT","I");
		model.addAttribute("BOOKS",resultList);
		model.addAttribute("BOOK_SEARCH",search);
		model.addAttribute("MAIN","BOOK");
		
		return "home";
	}
	
	
	
	
	@ModelAttribute("BOOK")
	public BookDto bDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);
		int intYear = Integer.valueOf(strDate);
		BookDto bDto = BookDto.builder()
					.b_year(intYear)
					.build();
		return bDto;
	}
	
}
