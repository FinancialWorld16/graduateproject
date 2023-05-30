package graduateproject.jproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Post {

    //POST_ID
    @Id
    @GeneratedValue
    @Column(name="post_id")
    private Long id;

    private String title;

    private String content;

    //MEMBER와 N:1
    @ManyToOne(fetch=FetchType.LAZY) //XToOne은 옵션을 LAZY로
    @JoinColumn(name="member_id")
    private Member member;

    //POST_DATE
    private LocalDate postDate;


    //==연관관계 메서드==// 양방향일때 control하는 쪽이 들고있는것이 좋다!
    public void setMember(Member member) {
        this.member = member;
        member.getPosts().add(this); //member의 post리스트에 이 post를 add!
    }

}
