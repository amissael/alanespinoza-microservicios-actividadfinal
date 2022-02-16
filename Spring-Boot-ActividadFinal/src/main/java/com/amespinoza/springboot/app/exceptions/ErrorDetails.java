package com.amespinoza.springboot.app.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	
	private Date timestamp;
	private String cod;
	private String mensaje;
	private String url;

}
