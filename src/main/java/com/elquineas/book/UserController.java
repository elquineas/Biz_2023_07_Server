package com.elquineas.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elquineas.book.model.UserDto;
import com.elquineas.book.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	private final UserService uService;
	public UserController(UserService uService) {
		this.uService = uService;
	}
		
	@RequestMapping(value={"/",""}, method = RequestMethod.GET)
	public String userhome(@ModelAttribute("USER") UserDto uDto, Model model) {
		List<UserDto> uList = uService.selectList();

//		model.addAttribute("USER",null);
		model.addAttribute("SORT","I");
		model.addAttribute("USERS",uList);
		model.addAttribute("MAIN","USER");
		return "home";
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String search, Model model) {
		List<UserDto> uList = uService.findUser(search);
		log.debug("체크 : {}",search);
		log.debug("체크 : {}",uList);
		
		model.addAttribute("USER_SEARCH",search);
		model.addAttribute("USERS",uList);
		model.addAttribute("SORT","I");
		model.addAttribute("MAIN","USER");
		return "home";
	}
	

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public UserDto insert(@ModelAttribute("USER") UserDto uDto,String code, Model model) {
		log.debug("SAVE DATA : {}",uDto);
//		bDto.setB_code(code);		
		UserDto resultDto = uService.findByUser(uDto);
		model.addAttribute("USER",uDto);
		if(resultDto != null) {
			uDto = uDto.builder()
					.u_code("NOT")
					.build();
		}
		return uDto;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("USER") UserDto uDto, String user_sort, Model model) {
		UserDto resultDto = uService.findById(uDto);
		log.debug("체크 : {}",user_sort);
		if(user_sort.equals("I") || resultDto == null) {
			uService.insertUser(uDto);
		}else if(user_sort.equals("U")) {
			uService.updateUser(uDto);
		}
		return "redirect:/user";
	}

	@ModelAttribute("USER")
	public UserDto uDto() {
		return new UserDto();
	}
}
