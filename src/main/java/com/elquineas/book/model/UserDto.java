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
public class UserDto {
	private String u_code;//	varchar(6)		PRIMARY KEY,
	private String u_name;//	varchar(125)	NOT NULL,
	private String u_tel;//		varchar(125),
	private String u_addr;//	varchar(125)	
}
