package jolpu.design.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Scrap> scrapList=new ArrayList<>();

    private String title;

    private String content;

    private LocalDateTime createTime;

    private String thumbnail;

    private int likeCount;

    private int scrapCount;

    private int commentCount;

    private int hits;
}
