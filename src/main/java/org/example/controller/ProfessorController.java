package org.example.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.dto.AssignmentsDto;
import org.example.dto.LectInfoDTO;
import org.example.dto.ProfessorDto;
import org.example.entity.*;
import org.example.repository.AssignmentsRepository;
import org.example.repository.LectInfoRepository;
import org.example.repository.MemberRepository;
import org.example.repository.ProfessorRepository;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.EnteringGradeDto;
import org.example.entity.Member;
import org.example.service.MemberService;
import org.example.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/prof")
@AllArgsConstructor
@Log4j2
@RequiredArgsConstructor
public class ProfessorController {

    private final MemberRepository memberRepository;
    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;
    private final MemberService memberService;
    @Autowired
    private final AssignmentsRepository assignmentsRepository;
    private final LectureService lectureService;
    @Autowired
    private final LectInfoRepository lectInfoRepository;
    private final AssignSubmitService assignSubmitService;
    private final StudentService studentService;
    private final AssignmentsService assignmentsService;




    // 강사 메인페이지
    @GetMapping("")
    public String profMain(Principal principal, Model model) {

        // 강사 프로필에 이름 띄우기
        Member member = memberRepository.findByUserId(principal.getName());
        String name = (member != null) ? member.getUserName() : "Unknown";
        String savedProfile = (member != null) ? member.getImgSaved() : "Unknown";
        model.addAttribute("name", name);
        model.addAttribute("profileImg", savedProfile);
        return "/prof/prof_main";
    }

    // 강사 나의 강의실
    @GetMapping("/lecture")
    public String profLecture() {
        return "/prof/myLecture";
    }

    // 강사 강의계획서
    @GetMapping("/lecture번호/lectureplan")
    public String profPlan() {
        return "/prof/lecturePlan";
    }

    // 강사 마이페이지
    @GetMapping("/mypage")
    public String profMyPage(Model model, Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Member member = memberRepository.findByUserId(userDetails.getUsername());

        Professor professor = professorService.ProfessorView(member.getUserId());

        model.addAttribute("professor", professor);
        model.addAttribute("member", member);

        return "/prof/prof_my_page";
    }

    @PostMapping("/mypage/modify")
    public String profUpdate(Professor professor, Member member, Principal principal, Model model, @RequestPart MultipartFile file) throws Exception {
        Member memberT = memberService.memberView(principal.getName());
        memberT.setUserName(member.getUserName());
        memberT.setUserBirthday(member.getUserBirthday());
        memberT.setUserPhoneNum(member.getUserPhoneNum());
        memberT.setUserEmail(member.getUserEmail());
        memberT.setUserAddr(member.getUserAddr());

        memberService.updateMember(memberT, file);

        Professor professorT = professorService.ProfessorView(memberT.getId());

        professorT.setProfBank(professor.getProfBank());
        professorT.setProfWork(professor.getProfWork());
        professorT.setProfAccount(professor.getProfAccount());
        professorT.setProfAgency(professor.getProfAgency());

        professorService.professorUpdate(professorT);

        model.addAttribute("message", "정보가 수정되었습니다.");
        model.addAttribute("SearchUrl", "/prof");
        return "/student/message";
    }

    // 학생 나의 강의현황
    @GetMapping("/lecture")
    public String studentLecture(Principal principal, Model model) {
        Member member = memberRepository.findByUserId(principal.getName());

        Professor professor = professorService.ProfessorView(member.getId());
        Long id = professor.getProfId();
        model.addAttribute("professorId", id);

        String year = "2023"; // 년도 값 설정
        String semester = "2학기"; // 학기 값 설정
        model.addAttribute("year", year);
        model.addAttribute("semester", semester);

        List<LectInfo> lectInfoList = lectureService.findCoursesByProfessorAndSemester(id, year, semester);
        model.addAttribute("lectInfoList", lectInfoList);

        return "/prof/myLecture";
    }

    // 학생 나의 강의현황 > 강좌검색
    @RequestMapping(value = "/lecture/find", method = RequestMethod.GET)
    @ResponseBody
    public List<LectInfoDTO> findCoursesByProfessorAndSemester(@RequestParam Long professorId, @RequestParam String year, @RequestParam String semester) {
        List<LectInfo> lectInfoList = lectureService.findCoursesByProfessorAndSemester(professorId, year, semester);

        List<LectInfoDTO> lectInfoDTOList = new ArrayList<>();
        for (LectInfo lectInfo : lectInfoList) {
            lectInfoDTOList.add(LectInfoDTO.fromLectInfo(lectInfo));
        }
        return lectInfoDTOList;
    }

    @GetMapping("/history")
    public String lectureHistory(Principal principal, Model model) {
        Member member = memberRepository.findByUserId(principal.getName());

        Professor professor = professorService.ProfessorView(member.getId());
        Long id = professor.getProfId();
        model.addAttribute("professorId", id);

        List<LectInfo> lectInfoList = lectureService.findCoursesByMemberAndSemester(id, "2023", "2학기");
        model.addAttribute("lectInfoList", lectInfoList);
        return "/prof/prof_class";
    }

    @RequestMapping(value = "/history/find", method = RequestMethod.GET)
    @ResponseBody
    public List<LectInfoDTO> findCoursesByProfessorAndSemesterinHistory(@RequestParam Long professorId, @RequestParam String year, @RequestParam String semester) {
        List<LectInfo> lectInfoList = lectureService.findCoursesByProfessorAndSemester(professorId, year, semester);

        List<LectInfoDTO> lectInfoDTOList = new ArrayList<>();
        for (LectInfo lectInfo : lectInfoList) {
            lectInfoDTOList.add(LectInfoDTO.fromLectInfo(lectInfo));
        }
        return lectInfoDTOList;
    }

    @GetMapping("/lecture/view/{id}")
    public String lectureView(Model model, @PathVariable("id") long id) {
        model.addAttribute("lectinfo", lectureService.lectureView(id));
        return "/prof/lecturemain";
    }


    @GetMapping("/att")
    public String AttendanceCheck(){
        return "/prof/attendanceCheck";
    }


    @GetMapping("/lecture/view/{lectId}/assignments")
    public String assignment(@PathVariable("lectId") Long lectId, Model model) {
        model.addAttribute("lectId", lectId);
        LectInfo lectInfo = lectInfoRepository.findByLectId(lectId);
        List<Assignments> assignmentsList = assignmentsRepository.findByLectInfoLectId(lectId);

//        List<AssignSubmit> submissions = assignSubmitService.getSubmissionsByLectId(lectId);
        model.addAttribute("lectInfo", lectInfo);
        model.addAttribute("assignmentsList", assignmentsList);
//        model.addAttribute("submissions", submissions);
        return "prof/assignment"; // Thymeleaf 템플릿 경로 수정
    }

    @GetMapping("/lecture/view/{lectId}/assignments/add")
    public String addAssignment2(@PathVariable("lectId") Long lectId, Model model, Assignments assignments) {
        model.addAttribute("lectId", lectId);
        model.addAttribute("assignment", assignments);
        return "prof/assiWrite";
    }

    @PostMapping("/lecture/view/{lectId}/assignments/add/add")
    public String studentUpdate(@PathVariable("lectId") Long lectId, @Validated Assignments assignment, @RequestPart MultipartFile file, Model model) throws Exception {
        try {
            Assignments assignments = Assignments.createAssignments(assignment);
            assignmentsService.saveAssignment(assignments, file);
            model.addAttribute("message", "과제가 추가되었습니다.");
        } catch (Exception e) {
            model.addAttribute("error", "과제 추가 중 오류가 발생했습니다.");
        }
        return "prof/assignment";
    }

//    @GetMapping("/findStudentInfo")
//    public List<Student> findStudentInfo(@RequestParam(name = "lectId") String lectId,
//                                         @RequestParam(name = "assiId") Long assiId) {
//        List<Student> studentInfoList = studentService.findStudentInfoByLectIdAndAssiId(lectId, assiId);
//        return studentInfoList;
//    }
        /**
         * 강사 : 나의강의실 - 과제제출정보
         * @author 임휘재
         */

    //강사 : 나의강의실 - 과제정보쓰기
    @GetMapping("/assiWrite")
    public String assiWrite(){
        return "/prof/assiWrite";
    }

    //강사 : 나의강의실 - 성적입력
    @GetMapping("/assiGrade")
    public String assiGrade(Model model, Principal principal){
        // 사용자 로그인 아이디 가져오기
        String loginId = principal.getName();
        // 사용자 정보 가져오기(member)
        Member member = memberService.memberView(loginId);

        model.addAttribute("list", professorService.AssiGradeLectInfoCheckList(member.getId()));
        return "/prof/assiGrade";
    }

    // 강사 : 성적입력 작성하기
    @RequestMapping(value = "/assiGrade/write", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> findEnteringGrade(@RequestParam String lectId) {
        log.info("lect아이디는?", lectId);
        Long LongLectId = Long.valueOf(lectId);
        List<EnteringGradeDto> enteringGradeDtoList = professorService.EnteringGradeCheckList(LongLectId);
        log.info("디티오는?, {}", enteringGradeDtoList.toString());
        return ResponseEntity.status(HttpStatus.OK).body(enteringGradeDtoList);
    }

    @GetMapping("/onlineclass")
    public String test2() {
        return "/prof/onlineclass";
    }
}
