package com.dsa.application.dto;

import com.dsa.application.type.UserRight;

import lombok.Data;


@Data
public class UserDto {
	private String userId;
	private String userPass;
	private String userName;
	private UserRight userRight;
	private String userPhoneNumber;
	private String userYear;
}
