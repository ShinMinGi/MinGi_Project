/**
 * @author 임승범
 */

// 파일목록 추가 생성
function addFileInput() {
    // ul 태그 가져오기
    let fileList = document.getElementById('fileList');

    if(fileList.getElementsByTagName('li').length === 5){
        alert('더 이상 파일을 추가 할 수 없습니다.');
        return ;
    }

    // 새로운 input file 생성
    var newInput = document.createElement('input');
    newInput.type = 'file';
    newInput.accept = '*/*';
    newInput.multiple = 'multiple';
    // li 생성
    let li = document.createElement('li');
    // li안에 input 넣어주기
    li.append(newInput);

    // li를 fileList ul에 추가
    fileList.appendChild(li);
}

let fileNo;

// 파일 업로드 버튼
function uploadFile(){

    let formData = new FormData();

    // fileList 엘리먼트에서 모든 input file 엘리먼트를 찾음
    let fileInputs = document.querySelectorAll('#fileList input[type="file"]');
    let files;

    // 각각의 input file 엘리먼트에서 선택된 파일들을 formData에 추가
    fileInputs.forEach(input => {
        files = input.files;
        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }
    });

    // console.log('filesEa = ' + files.length);
    // console.log('files = ' + files.value);
    // console.log("formdata = " + formData);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload', true);
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            // 업로드 성공 시 처리할 코드
            console.log('파일 업로드 성공');
            alert('파일 업로드 되었습니다.');
            let result = JSON.parse(xhr.response);
            console.log("result = " + result);
            fileNo = result[0].id;
            console.log("fileNo = " + fileNo);
        } else {
            // 업로드 실패 시 처리할 코드
            console.error('파일 업로드 실패');
            alert('파일 업로드 실패...');
        }
    };
    xhr.onerror = function () {
        // 네트워크 오류 등으로 업로드에 실패한 경우 처리할 코드
        console.error('파일 업로드 중 오류 발생');
    };
    xhr.send(formData);
}




//  summernote 설정
// $('#summernote').summernote('code', );
$('#summernote').summernote({
    toolbar: [
        ['fontname', ['fontname']],
        ['fontsize', ['fontsize']],
        ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
        ['color', ['forecolor','color']],
        ['table', ['table']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['insert',['picture','link']],
        ],
    height: 500,                 // 에디터 높이
    minHeight: 500,             // 최소 높이
    maxHeight: 500,             // 최대 높이
    maxWidth: 1200,
    focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
    lang: "ko-KR",					// 한글 설정
    placeholder: '내용을 입력해주세요.'	//placeholder 설정
});

//마지막으로 한 행동 취소 ( 뒤로가기 )
$('#summernote').summernote('undo');
// 앞으로가기
$('#summernote').summernote('redo');
// 기존 작성값 불러오기(html로 변환해서 가져와야 양식 유지)
// $('#summernote').summernote('pasteHTML', data);

// 등록버튼
const saveBtn = document.getElementById('saveBtn');
// 등록버튼 클릭시
if(saveBtn){

    saveBtn.addEventListener('click' , ()=>{

        // 게시판 종류 값 가져오기
        const boardType = document.getElementById('boardType').value;
        // 사용자 id 값 가져오기
        const memberId = document.getElementById('memberId').value;
        // 사용자 이름 값 가져오기
        const memberName = document.getElementById('memberName').value;
        // 게시글 제목 가져오기
        const title = document.getElementById('title').value;
        // 서머 노트 입력값 가져오기
        const content = $('#summernote').summernote('code');

        // 비공개 글 여부 체크 값 가져오기
        let privateCk = false;
        if(document.getElementById('private_ck').checked === true){
            privateCk = true;
        }

        // 게시판 유효성 검사
        if(content == null || content === "" || title == null || title === ""){
            alert('내용을 입력해주세요');
            return ;    // 종료
        }


        console.log("privateCk : " + privateCk);
        console.log("boardType : " + boardType);
        console.log("memberId : " + memberId);
        console.log("memberName : " + memberName);
        console.log("title : " + title);
        console.log("content : " + content);

        let data;

        if(fileNo !== null || fileNo === 0){
            data = {
                type : boardType,
                memberId : memberId,
                writer : memberName,
                title : title,
                content : content ,
                isLocked : privateCk,
                fileNo : fileNo
            };
        }else {
            data = {
                type : boardType,
                memberId : memberId,
                writer : memberName,
                title : title,
                content : content ,
                isLocked : privateCk
            };
        }


        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/board/write' , true);
        xhr.setRequestHeader('Content-Type' , 'application/json; charset=UTF-8');

        xhr.onreadystatechange = function (){
            if(xhr.readyState === 4){
                // 성공 응답시
                if(xhr.status === 201){
                    alert('등록됨');
                    let article = JSON.parse(xhr.response);
                    let articleId = article.id;
                    // console.log("articleId = " + articleId);
                    window.location = '/board/view/' + articleId;
                }
                else {
                    alert('실패');
                }
            }
        };
        xhr.send(JSON.stringify(data));


    });
}

// 수정버튼
const modifyBtn = document.getElementById('modifyBtn');

// 수정버튼 클릭시
if(modifyBtn){

    modifyBtn.addEventListener('click' , ()=>{

        // 게시판 종류 값 가져오기
        const boardType = document.getElementById('boardType').value;
        // 사용자 id 값 가져오기
        const memberId = document.getElementById('memberId').value;
        // 사용자 이름 값 가져오기
        const memberName = document.getElementById('memberName').value;
        // 게시글 제목 가져오기
        const title = document.getElementById('title').value;
        // 서머 노트 입력값 가져오기
        const content = $('#summernote').summernote('code');
        // 비공개 글 여부 체크 값 가져오기
        let privateCk = false;
        if(document.getElementById('private_ck').checked == true){
            privateCk = true;
        }
        // 게시판 id 가져오기
        const articleId = document.getElementById('articleId').value;

        console.log("privateCk : " + privateCk);
        console.log("boardType : " + boardType);
        console.log("memberId : " + memberId);
        console.log("memberName : " + memberName);
        console.log("title : " + title);
        console.log("content : " + content);
        console.log("articleId : " + articleId);

        let data;

        if(fileNo !== null || fileNo === 0){
            data = {
                type : boardType,
                memberId : memberId,
                writer : memberName,
                title : title,
                content : content ,
                isLocked : privateCk,
                fileNo : fileNo,
                id : articleId
            };
        }else {
            data = {
                type : boardType,
                memberId : memberId,
                writer : memberName,
                title : title,
                content : content ,
                isLocked : privateCk,
                id : articleId
            };
        }


        let xhr = new XMLHttpRequest();
        xhr.open('PUT', '/board/modify' , true);
        xhr.setRequestHeader('Content-Type' , 'application/json; charset=UTF-8');

        xhr.onreadystatechange = function (){
            if(xhr.readyState === 4){
                // 성공 응답시
                if(xhr.status === 200){
                    alert('수정됨');
                    let article = JSON.parse(xhr.response);
                    let articleId = article.id;
                    // console.log("articleId = " + articleId);
                    window.location = '/board/view/' + articleId;
                }
                else {
                    alert('실패');
                }
            }
        };
        xhr.send(JSON.stringify(data));

    });
}

// 돌아가기 버튼 클릭시 이벤트 , 전 페이지로 단순이동
const cancleBtn = document.getElementById('cancelBtn');
if(cancleBtn){
    cancleBtn.addEventListener('click',()=>{
       window.history.back();
    });
}
