package org.example.repository;

import org.example.dto.admin.ApplyStudentDto;
import org.example.entity.LectInfo;
import org.example.entity.StudLectApply;
import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectApplyRepository extends JpaRepository<StudLectApply, Long> {

    // 강좌 ID로 해당 수강생 찾는 쿼리
    @Query("select new org.example.dto.admin.ApplyStudentDto(s.studId, s.member.userName, s.member.userId, s.member.userEmail, " +
            "l.lectSubject, s.member.userGender) from StudLectApply la join LectInfo l on l.lectId = la.lectInfo.lectId " +
            "join Student s on s.studId = la.student.studId where l.lectId = :lectId")
    List<ApplyStudentDto> findAllByLectId(@Param("lectId") Long id);

    // 학생과 강좌 정보가 일치하면 DB에서 삭제하는 메소드
    void deleteByStudentAndLectInfo(Student student, LectInfo lectInfo);

}
