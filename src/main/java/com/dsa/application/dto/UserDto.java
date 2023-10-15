package com.dsa.application.dto;

import com.dsa.application.entity.User;
import com.dsa.application.type.UserRight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	
	
	private String userId;
	private String userName;
	private UserRight userRight;
	
	public static UserDto fromUserInfo(User user) {
		return UserDto.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.userRight(user.getUserRight())
				.build();
	}

}
