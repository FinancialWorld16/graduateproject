package jolpu.design.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Register {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "register", fetch = FetchType.LAZY)
    private Member member;

    private String place;

    private LocalDateTime time;

    private String purpose;

    private int personNum;

    private LocalDateTime createTime;


}
