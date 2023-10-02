package com.dsa.application.dto;

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
	private String userPass;
	private String userName;
	private UserRight userRight;
	private String userPhoneNumber;
	private String userYear;
	
/*
 * Cloneable 인터페이스는 복제해도 되는 클래스임을 명시하는 용도의 믹스인 인터페이스지만, 
 * 아쉽게도 의도한 목적을 제대로 이루지 못했다. 여기서 큰 문제점은 clone 메서드가 선언된 곳이 Cloneable이 아닌 OBject이고,
 * 그 마저도 protected이다. 그래서 Cloneable을 구현하는 것만으로는 외부 객체에서 clone 메소드를 호출할 수 없다. 
 * 리플렉션을 사용하면 가능하지만, 100% 성공하는 것도 아니다. 이러한 여러 문제점을 가진 인터페이스이지만, 
 * Cloneable 방식은 널리 쓰이고 있어서 잘 알아두는 것이 좋다. Cloneable이 몰고 온 모든 문제를 되짚어봤을 때, 
 * 새로운 인터페이스를 만들 때는 절대 Cloneable을 확장해서는 안 되며, 새로운 클래스도 이를 구현해서는 안된다. 
 * final 클래스라면 Cloneable을 구현해도 위험이 크지는 않지만, 성능 최적화 관점에서 검토한 후 별다른 문제가 없을 때만 드물게 허용해야 한다.
 * 기본 원칙은 '복제 기능은 생성자와 팩터리를 이용하는게 최고' 라는 것이다.
 * 단, 배열만은 clone 메소드 방식이 가장 깔끔한, 이 규칙의 합당한 예외라 할 수 있다.
 * 
 * */
    /* 복사 생성자 방식*/
    public UserDto (UserDto original) {
        this.userId = original.userId;
        this.userPass = original.userPass;
        this.userName = original.userName;
        this.userRight = original.userRight;
        this.userPhoneNumber = original.userPhoneNumber;
        this.userYear = original.userYear;
    }

//    /* 복사 팩터리 방식*/
//    public static UserDto userClone(UserDto original) {
//    	UserDto copy = new UserDto();
//		copy.userId = original.userId;
//		copy.userPass = original.userPass;
//		copy.userName = original.userName;
//		copy.userRight = original.userRight;
//		copy.userPhoneNumber = original.userPhoneNumber;
//		copy.userYear = original.userYear;
//        return copy;
//    }
}
