<div align=left><h1>💻LMS 학적관리시스템💻</h1></div>

스프링 부트 + JPA LMS 학적관리시스템

<div align=left><h1>프로젝트 소개</h1></div>
교육 및 학습환경을 관리하고 지원하는 LMS학적 관리 시스템 입니다.

<div align=left><h1>📚 STACKS</h1></div>

<div align=left><h3>📕 Environment</h3></div>

<div>
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
  <img src="https://img.shields.io/badge/kakaotalk-FFCD00?style=for-the-badge&logo=kakaotalk&logoColor=white">
</div>

<div align=left><h3>📙 Development</h3></div>

<div>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/jpa-FF6F00?style=for-the-badge&logo=jpa&logoColor=white">
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white">
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
</div>

<div align=left><h1>맴버 구성 및 역할 분담</h1></div>

**😺팀장 권혁인** : 강사관리, 강좌 관리, 수강신청 조회, 유튜브 등록

**😺팀원 임휘재** : 학생관리 조회, 온라인강의수강현황 조회, 전체성적관리 조회, 게시글 작성(담당용) CRUD, 게시판 정보관리 CRUD, 
유튜브 API를 활용한 유튜브 재생 통제기능

**😺팀원 신동은** : 학생의 성적조회, 학생의 수강신청, 강사의 성적조회 및 작성하기 

**😺팀원 이현석** : 스프링 시큐리티(로그인), 나의 강의실, 과제 관련 기능, 회원정보수정, 강사 & 학생 메인페이지, 강의계획서, 강의이력조회

**😺팀원 신민기** : AJAX를 사용한 온라인강의 조회, AJAX를 사용한 강의 차시정보 조회, AJAX를 사용한 강의 차시 상세정보 CRUD

**😺팀원 임승범** : 

<div align=left><h1>💻 화면 구성</h1></div>

<div align=center>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/c40db232-1d89-4d43-8332-43c18ae4c0a8.png"/>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/76e446ca-c9a9-4c53-92df-7c97db162087.png"/>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/f0d6ace9-24f8-4a05-b6f4-de71873ab497.png"/>
</div>

<div align=center>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/9e358461-d33c-4366-882c-ec12a0c5eb89.png"/>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/bb041fa8-bdf6-4e53-996f-f3244e06d4d6.png"/>
    <img width="30%" src="https://github.com/Yujin051/lms-system-team-project/assets/105468233/ea159a7f-fd5d-48be-ad71-fae830f64d95.png"/>
</div>

<div align=center>
    
</div>

<div align=left><h1>💡 주요 기능</h1></div>

<div align=left><h2>👲 관리자 페이지</h2></div>

### 학생관리
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능
- 비동기 통신으로 그리드에 갱신된 정보를 출력하는 기능

### 강사관리
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능
- 비동기 통신으로 그리드에 갱신된 정보를 출력하는 기능

### 강좌관리
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능
- AJAX를 사용해 프론트에서 입력한 정보를 서버로 넘겨서 DB에 업데이트 하는 기능
- 수정한 내용을 전달하여 디비에 등록하고 비동기 통신을 통해 새로운 데이터로 그리드를 갱신하는 기능
- 그리드UI에서 해당 강좌를 선택한 후 '삭제'버튼을 누르면 이 정보를 서버로 전송하여 해당 데이터를 디비에서 삭제하고, 그 결과를 비동기 통해 그리드를 업데이트하여 반영

### 수강신청관리
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능

### 온라인강의콘텐츠관리
- 구글 OAuth인증을 통한 유튜브 API의 사용 권한 부여와 부여된 권한을 이용하여 유튜브 동영상을 서버 단위에서 업로드를 할 수 있는 로직 구현
- API 통신을 이용한 동영상 정보 업데이트기능과 학습시간을 실시간으로 갱신하는 기능을 구현

### 온라인강의정보관리
- AJAX를 사용해 디비와 비동기 통신을 하여 조회하고 업데이트하는 CRUD기능

### 온라인강의수강현황
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능

### 전체성적관리
- AJAX를 사용한 비동기 통신을 통해 디비와 통신하여 프론트에서 학생 정보를 검색 및 조회 가능

### 게시글 작성(담당용)
- AJAX를 사용해 디비와 비동기 통신을 하여 조회하고 업데이트하는 CRUD기능

### 게시판 정보관리
- AJAX를 사용해 디비와 비동기 통신을 하여 조회하고 업데이트하는 CRUD기능

<div align=left><h2>👦 학생/강사 페이지</h2></div>

### 회원가입 및 로그인 기능
- 스프링 시큐리티를 사용
- 권한에 따라 로그인 시 리다이렉션되는 루트 페이지를 설정
- 자기 권한에 맞는 페이지만 접근이 가능

### 성적조회
- AJAX를 사용해 디비와 비동기 통신을 하여 프론트에서 학생의 현재와 과거의 성적을 조회가능

### 수강신청
- Thymeleaf를 사용해 학생의 수강하고 수강한 수강강좌가 담기고 취소할수 있는 페이지를 구현
- 신청시 수강인원초과통제,중복입력통제,자신의 수강학점가능초과 통제

### 성적입력(강사)
- Thymeleaf를 사용해 강사의 강좌의 학생들의 성적을 조회하고 입력하는 페이지 구현

### 게시판/댓글(학생/강사)
- 게시판/댓글 CRUD, 페이징, 검색 구현.
- 세션을 이용한 조회수 중복방지 처리 및 조회수 증가.
- 권한에 따른 게시판 작성 처리 및 비공개 글 조회시 권한비교.
- Summer Note API를 이용한 글 작성 에디터 구현.
- 파일 업로드 및 다운로드 기능 구현.
- 게시글 상세조회에서 이전글, 다음글 이동 가능.

### 쪽지(학생/강사)
- 쪽지 CRUD , 페이징 , 검색 구현.
- 쪽지 받는 대상이 읽을 경우, 읽은 시간 기록.
- 답장기능 구현, 답장시 최초 쪽지 번호키 기록.
- 단체 쪽지 기능 구현.
- 전체, 받은쪽지, 보낸쪽지, 휴지통으로 정렬하여 조회 가능.



<div align=left><h1>프로젝트 회고</h1></div>

### 😃프로젝트 회고

**😺팀장 권혁인** : 처음에는 이전 1차 프로젝트에서 적용해 봤던 기술들의 연속이라고 생각하고, 그 기술들을 조금 더 다진다는 느낌으로 가볍게 마음먹었었지만 처음 접해보는 API 사용에 조금 난항을 겪었습니다. 데이터를 정렬하기 위해 사용한 그리드 UI API는 API를 이용하게 위해 데이터를 정재하는 로직 설계에 애를 먹었고, 유튜브 API 쪽에서는 구글의 인증 토큰을 획득하고 그것을 이용하는 과정이 쉽지 않았지만 멘토님의 도움, 레퍼런스 등을 찾아보며 직접 익혀볼 수 있던 기회가 됐다고 생각합니다. 동시에 담당한 로직이 이전에 사용했던 Thymeleaf 가 아닌 ajax를 통한 비동기 방식의 갱신을 주로 사용했기 때문에 비동기 방식에 대한 이해도 조금 더 넓혀볼 수 있던 기회가 됐습니다. 팀장으로서 역할을 못했던 부분이 많았는데 팀원들이 부족한 팀장 말에 잘 따라와 줘서 고맙다고 말하고 싶네요.

**😺팀원 임휘재** : 프로젝트에 처음으로 JPA를 적용해 보았는데 이번 프로젝트로 JPA에 대해 많이 배우게 되었고, 또, 대부분의 CRUD는 API방식으로 프론트와 통신하여 AJAX를 통해 디비와 비동기 통신을 사용했기 때문에 AJAX와 API방식의 사용들에 대해 많이 알게되는 계기가 되었습니다. 그리고 이번 프로젝트에서 유튜브 API를 사용하여 유튜브 영상을 제어하는 기능을 구현해 보았는데, 아무래도 처음 접해보는 기능이기도 해서 많은 어려움이 있었지만, 차근차근 문제들을 해치면서 유튜브 제어 기능을 계획한대로 구현했기 때문에 구현한 성취감을 느낄 수 있었습니다.

**😺팀원 신동은** : 프로젝트하면서 항상 thymeleaf를 사용하여 동기처리를 하였는데 이번에 ajax를 처음 사용하여 비동기를 사용해서 구현해보았습니다.  처음에는 ajax를 쓰는이론조차 이해가 잘되지 않았지만 팀원들에게 도움을 받아서 해결해보고 2번째로 혼자 구현해보았을때는 비동기를 사용해도 할수있겠다는 자신감을 얻었습니다.
이번에 jpa기능을 많이 배웠다고 생각하는게 데이터 중복이면 들어가지못하게 어떻게 처리하지라는것에서 상당히 많이 생각하면서 많이 돌아가는 방법을 사용했는데 jpa 기능중에 existsBy라는 기능을 알게되면서 간단하게 처리하였습니다. 많은 기능들을 구현하면서 이러한 jpa repository기능들을 많이 알게되면서 간단하게 처리하게 된것들이 많았습니다.

**😺팀원 이현석** : 프로젝트를 진행하면서 쿼리를 쓰다 보니 왜 CRUD에서 가장 중요한게 SQL인지 뼈저리게 느낄 수 있었던 프로젝트였다. 저번 프로젝트에선 거의 써보지 못했던 AJAX와 JSON 등의 비동기 처리를 연습할 수 있어 좋았고, 스프링 시큐리티의 기능을 한번 더 써보면서 좀 더 가다듬을 수 있는 것 같아 뿌듯했다. JPA, ThymeLeaf 또한 다시 한 번 사용하면서 지식의 확장을 이룰 수 있었고, 다음 개인 프로젝트에서는 MyBatis 등을 사용하면서 쿼리 공부를 더 해야겠다고 느꼈다.


**😺팀원 신민기** : 프로젝트를 진행하면서 사용해 보지 않은 JPA, AJAX 등 활용하며 많은 것을 배운 거 같고 아직 부족한 부분이 어떤 것인지 많이 알 수 있게 한 기회였던 것 같습니다 계속 반복적인 CRUD 구성을 통해 좀 더 확실하게 알 수 있는 계기가 되었습니다. 그리고 아직 미흡한 부분에서 팀원들이 부족한 부분을 채워주며 끝까지 완성할 수 있었던 것 같습니다 팀원 간에 커뮤니케이션에 대한 중요성도 많이 배운 것 같습니다 아쉬웠던 점은 PPT디자인을 크게 신경 못 쓰고 중요한 내용이 무엇인지 파악을 잘 못했던 것 같아 아쉬움이 있었지만 이번 계기로 좀 더 확실하게 구성할 수 있게 되어 많이 배운 것 같습니다

**😺팀원 임승범** : 가장 기본적이라 할 수 있는 게시판/댓글/메시지 CRUD, 페이징, 검색 등에 대하여 진행해보고 싶었는데, 이번 프로젝트를 통해 구현해보는 시간을 가질 수 있어서 너무 좋았고 기능구현을 진행하면서 내가 평소에 간단하게 사용하던 웹 페이지의 모든 부분들이 정말 섬세하게 하나하나 고려하고 기능구현이 되었다는 것을 새삼 깨달을 수 있었습니다. 또한 이번 프로젝트는 JPA를 활용하여 기능구현이 진행되었는데, 덕분에 mybatis와는 무엇이 다르고 장단점이 무엇인지 조금이나마 알 수 있었습니다. 마지막으로 프로젝트를 이렇게 짧은 기간안에 기획하고 구현하여 완성시키기는 했지만 디자인적인 측면에서, 편의성에서, 기능적인 측면에서...정말 다양한 방면으로 조금 아쉽다는 생각이 듭니다.


