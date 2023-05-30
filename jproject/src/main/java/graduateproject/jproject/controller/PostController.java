package graduateproject.jproject.controller;


import graduateproject.jproject.domain.Member;
import graduateproject.jproject.domain.Post;
import graduateproject.jproject.service.MemberService;
import graduateproject.jproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    public final MemberService memberService;
    public final PostService postService;

    @GetMapping("/post")
    public String createForm(Model model) {

        List<Member> members=memberService.findMembers();

        model.addAttribute("members",members);
        model.addAttribute("form", new PostForm());

        return "post/postForm";
    }

    @PostMapping("/post")
    public String post(@RequestParam("memberId") Long memberId,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content
                       ) {

        postService.writePost(memberId, title, content);

        return "redirect:/"; //첫번째 페이지로...
    }

    //게시글 리스트
    @GetMapping("/posts")
    public String list(Model model) {

        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "post/postList";
    }

    //게시글 상세정보 페이지
    @GetMapping("post/{postId}")
    public String seePostDetail(@PathVariable("postId") Long postId, Model model) {

        Post post = postService.findOne(postId);

        model.addAttribute("post", post);

        return "post/postDetail";

    }

    //삭제
    @GetMapping("post/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {

        postService.deletePost(postId);

        return "redirect:/posts";
    }



    /*@GetMapping("post/{postId}/edit")
    public String edit(@PathVariable("postId") Long postId, Model model) {

        Post post=postService.findOne(postId);
        model.addAttribute("post", post);

        return "post/postEdit";

    }


    @PostMapping("/post{postId}/edit")
    public String editPost(@RequestParam("memberId") Long memberId,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content
    ) {

        postService.writePost(memberId, title, content);

        return "redirect:/"; //첫번째 페이지로...
    }*/
}
