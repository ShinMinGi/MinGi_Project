insert into member(user_id , user_pw , user_name , user_phonenum , user_regdate , user_addr , user_birthday , user_email , user_gender , user_role) values
    ('admin1' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '관리자1','01022225555' , '2023-1-1' , '관리자네집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'ADMIN'),
    ('student1' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '김학생','01022225555' , '2023-1-1' , '학생1집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'USER'),
    ('student2' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '이학생','01021225555' , '2023-1-1' , '학생2집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'USER'),
    ('prof1' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '김선생','01023225555' , '2023-1-1' , '선생1집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'TEACHER'),
    ('prof2' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '이선생','01024225555' , '2023-1-1' , '선생2집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'TEACHER'),
    ('prof3' , '$2a$10$BNEf0bp3OvIoAL9kIAStP.pyoMnNIpdjFuUnv2SvATm75s6YrM1HG' , '신선생','01024225555' , '2023-1-1' , '선생2집', '2023-1-1' ,'admin@admin.com', 'MALE' , 'TEACHER');

insert into student(member_id, stud_grade, stud_maxcr, stud_nowcr, stud_crecpl) values
    (2, 2, 18, 0, 11),
    (3, 3, 16, 0, 15);

insert into professor(member_id, prof_agency, prof_work, prof_bank, prof_account, is_active) values
    (4, '소속기관1', '직무1', '하나은행', '1111-1111', true),
    (5, '소속기관1', '직무1', '하나은행', '1111-1111', true),
    (6, '소속기관1', '직무1', '하나은행', '1111-1111', true);

insert into lect_info(prof_id, lect_name, lect_subject, lect_year, lect_sem, lect_credit, lect_nownum, lect_maxnum, enroll_start, enroll_end, lect_start,  lect_end, is_active, lect_assign, lect_check, lect_test) values
     (1, '미분적분학', '필수과목', '2023', '2학기', 2, 15, 30, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (1, '미분기하학', '필수과목', '2023', '2학기', 3, 17, 25, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (1, '암호학', '필수과목', '2023', '2학기', 2, 13, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (1, '해석학', '필수과목', '2023', '2학기', 2, 13, 25, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (2, '기계학', '필수과목', '2023', '2학기', 3, 10, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (2, '동물학', '필수과목', '2023', '2학기', 3, 13, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (2, '몰라학', '필수과목', '2023', '2학기', 2, 11, 25, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (2, '화학', '필수과목', '2023', '2학기', 2, 12, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (2, '화학2', '필수과목', '2023', '2학기', 3, 15, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (3, '물리학', '필수과목', '2023', '2학기', 3, 13, 20, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (3, '양자학', '필수과목', '2023', '2학기', 2, 29, 30, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (3, '부력학', '필수과목', '2023', '2학기', 2, 30, 30, NOW(), NOW(), NOW(), NOW(), true, 35, 35, 30),
     (3, '표면장력학', '필수과목', '2023', '1학기', 2, 23, 30, NOW(), NOW(), NOW(), NOW(), false, 35, 35, 30),
     (3, '유력학', '필수과목', '2022', '2학기', 2, 23, 30, NOW(), NOW(), NOW(), NOW(), false, 35, 35, 30),
     (3, '우주학', '필수과목', '2021', '2학기', 2, 29, 30, NOW(), NOW(), NOW(), NOW(), false, 35, 35, 30),
     (3, '종이학', '필수과목', '2022', '1학기', 2, 30, 30, NOW(), NOW(), NOW(), NOW(), false, 35, 35, 30);

insert into grade_info(lect_id, stud_id, grade, check_score, assign_score, test_score, is_record) values
    (1, 1, 'D', 25, 33, 20, true),
    (2, 2, 'A', 25, 33, 20, true),
    (3, 1, 'B', 25, 33, 20, true),
    (4, 2, 'A', 25, 33, 20, true),
    (5, 1, 'C', 25, 33, 20, true),
    (6, 1, 'A', 25, 33, 20, true),
    (7, 2, 'D', 25, 33, 20, true),
    (8, 1, 'A', 25, 33, 20, true),
    (9, 2, 'A', 25, 33, 20, true),
    (10, 2, 'D', 25, 33, 20, true),
    (11, 1, 'A', 25, 33, 20, true),
    (12, 1, 'A', 25, 33, 20, true),
    (13, 1, 'A', 25, 33, 20, true),
    (13, 2, 'D', 25, 33, 20, true),
    (14, 1, 'C', 25, 33, 20, true),
    (14, 2, 'A', 25, 33, 20, true),
    (15, 1, 'D', 25, 33, 20, true),
    (15, 2, 'A', 25, 33, 20, true),
    (16, 1, 'A', 25, 33, 20, true);

insert into sem_grade(stud_id, sem_year, sem_sem, sem_crecpl, sem_avg_crecpl) values
    (1, '2023', '2학기', 0, 0),
    (1, '2023', '1학기', 0, 0),
    (1, '2022', '2학기', 0, 0),
    (1, '2022', '1학기', 0, 0),
    (2, '2023', '2학기', 0, 0),
    (2, '2023', '1학기', 0, 0),
    (2, '2022', '2학기', 0, 0),
    (2, '2021', '2학기', 0, 0);
