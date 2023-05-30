package graduateproject.jproject.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message="회원 아이디은 필수 입니다")
    private String memberName;

    private String memberPassword;

    private String memberEmail;



}
