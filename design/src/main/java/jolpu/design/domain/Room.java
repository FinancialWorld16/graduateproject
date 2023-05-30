package jolpu.design.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String roomName;

    private LocalDateTime createTime;

    @OneToMany(mappedBy = "room")
    private List<Participant> participants=new ArrayList<>();

    @OneToMany(mappedBy = "room")
    private List<Chat> chats=new ArrayList<>();

}
