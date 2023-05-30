package graduateproject.jproject.service;


import graduateproject.jproject.domain.Member;
import graduateproject.jproject.domain.Post;
import graduateproject.jproject.repository.MemberRepository;
import graduateproject.jproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;

    private final PostRepository postRepository;

    @Transactional
    public Long writePost(Long memberId, String title, String content) {

        Member member = memberRepository.findOne(memberId); //특정 멤버 조회

        Post post=new Post();
        post.setMember(member);
        post.setTitle(title);
        post.setContent(content);
        post.setPostDate(LocalDate.now());

        postRepository.save(post);

        return post.getId();
    }


    //검색
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }

    public void deletePost(Long postId) {

        postRepository.deleteOne(postId);

    }
}