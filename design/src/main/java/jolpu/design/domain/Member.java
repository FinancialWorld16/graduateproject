package jolpu.design.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String userName;

    private String password;

    private String nickname;

    private String email;

    private LocalDateTime createdTime;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="register_id")
    private Register register;

    @OneToMany(mappedBy = "member")
    private List<Participant> participants=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Chat> chats=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    private Region region;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Scrap> scrapList=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Post> posts=new ArrayList<>();
}
