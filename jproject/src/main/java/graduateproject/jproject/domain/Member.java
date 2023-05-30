package graduateproject.jproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    //MEMBER_ID
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @NotEmpty
    private String memberName; //회원 계정 아이디

    private String memberPassword;

    private String memberEmail;

    //POST와의 관계
    @OneToMany(mappedBy = "member") //1:n
    private List<Post> posts = new ArrayList<>();
}
