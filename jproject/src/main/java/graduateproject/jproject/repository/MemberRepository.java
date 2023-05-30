package graduateproject.jproject.repository;

import graduateproject.jproject.domain.Member;
import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //save: DB에 member 저장
    public void save(Member member) { //member 저장
        em.persist(member);
    }

    //findOne
    public Member findOne(Long id) { //member 하나 조회
        return em.find(Member.class, id); //(Type, PK)
    }

    //findAll: 전체 리스트 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //JPQL. from의 대상이 테이블이 아니라 entity
                .getResultList();
    }

    //findByName: 회원 아이디로 회원 검색
    public List<Member> findByMemberName(String memberName) {
        return em.createQuery("select m from Member m where m.memberName= :memberName", Member.class)
                .setParameter("memberName", memberName)
                .getResultList();
    }
    
}
