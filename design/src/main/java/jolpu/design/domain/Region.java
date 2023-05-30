package jolpu.design.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Region {

    @Id
    @GeneratedValue
    private Long id;

    private String regionName;

    @OneToMany(mappedBy = "region")
    private List<Member> memberList =new ArrayList<>();

    @OneToMany(mappedBy = "region")
    private List<Board> boardList=new ArrayList<>();

}
