/**
 * 
 */
package com.dsa.application.type;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserRight {
	LEVLE_1("미가입유저"),
	LEVEL_2("가입유저"),
	LEVEL_3("관리자"),
	LEVEL_4("슈퍼유저");
	private final String userRight;
}
