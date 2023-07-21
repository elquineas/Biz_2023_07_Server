package com.elquineas.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
	private String b_code;//	도서코드  	varchar(6)		PRIMARY KEY,
	private String b_name;//	도서명  	varchar(125)	NOT NULL,
	private String b_auther;//	저자  		varchar(125)	NOT NULL,	
	private String b_comp;//	출판사 		 varchar(125),
	private int b_year;//		구입연도  	int				NOT NULL,
	private int b_iprice;//		구입가격  	int,
	private int b_rprice;//		대여가격  	int				NOT NULL
}
