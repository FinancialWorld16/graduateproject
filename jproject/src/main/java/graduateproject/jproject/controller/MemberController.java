package graduateproject.jproject.controller;


import graduateproject.jproject.domain.Member;
import graduateproject.jproject.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) { //@NotEmpty 이용, 에러 처리

        if (result.hasErrors()) { //결과가 result에 담기는데 그것을 확인 후 처리...
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setMemberName(form.getMemberName());
        member.setMemberPassword(form.getMemberPassword());
        member.setMemberEmail(form.getMemberEmail());

        memberService.join(member);

        return "redirect:/"; //첫번째 페이지로...
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
