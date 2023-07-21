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
public class RentDto {
	private long RENT_SEQ;//				bigint		PRIMARY KEY AUTO_INCREMENT,
	private String RENT_DATE;//				varchar(30)	NOT NULL,	
	private String RENT_RETURN_DATE;//		varchar(10)	NOT NULL,	
	private String RENT_BCODE;//			varchar(6)	NOT NULL,	
	private String RENT_UCODE;//			varchar(6)	NOT NULL,
	private String RENT_RETUR_YN;//			varchar(1),
	private int RENT_POINT;//				int		
}
