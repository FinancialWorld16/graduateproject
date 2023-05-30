package graduateproject.jproject.service;


import graduateproject.jproject.domain.Member;
import graduateproject.jproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //join: 회원가입
    @Transactional //(readOnly=false)
    public Long join(Member member) { //가입 함수

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    //가입할 때 중복 체크용 함수
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByMemberName(member.getMemberName());
        if(!findMembers.isEmpty()) { //memberRepository 안에 이미 해당 이름의 회원이 있으면 회원가입 불가
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //특정 ID를 가지는 회원 한명 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
