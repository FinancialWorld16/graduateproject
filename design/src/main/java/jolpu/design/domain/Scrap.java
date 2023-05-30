package jolpu.design.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Scrap {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private LocalDate createDate;
}
