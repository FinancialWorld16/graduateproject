package graduateproject.jproject.repository;

import graduateproject.jproject.domain.Post;
import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    //save
    public void save(Post post) { //member 저장
        em.persist(post);
    }

    //findOne
    public Post findOne(Long id) { //member 하나 조회
        return em.find(Post.class, id); //(Type, PK)
    }


    //findAll: 전체 리스트 조회
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class) //JPQL
                .getResultList();
    }

    @Transactional //delete시 @Transactional 필수
    public void deleteOne(Long postId) {
        System.out.println("postId = " + postId);
        Post post = em.createQuery("select p from Post p where p.id = :postId", Post.class)
                .setParameter("postId", postId)
                .getSingleResult();
        em.remove(post);
    }
}

