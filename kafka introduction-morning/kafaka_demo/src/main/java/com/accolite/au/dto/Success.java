package com.accolite.au.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Success {
	@NonNull
	private Integer code;

	private String message;

	private String details;

}
