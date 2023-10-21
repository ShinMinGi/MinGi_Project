const dataSource = {
    api: {
        readData: {
            url: '/api/apply/lecturelist', method: 'GET'
        }
    }
}

// 전체 수강신청 대상 강좌 데이터 그리드
const grid = new tui.Grid({
    el: document.querySelector('#grid'),
    data: dataSource,
    scrollX: false,
    scrollY: false,
    minBodyHeight: 40,
    pageOptions: {
        useClient: true, // 클라이언트 페이징 활성화
        perPage: 10, // 페이지당 표시할 항목 수
    },
    columns: [
        {
            header: '강의 ID',
            name: 'lectId',
            sortingType: 'asc',
            sortable: true,
            width: 200
        },
        {
            header: '강의명',
            name: 'lectName',
            sortingType: 'asc',
            sortable: true,
        },
        {
            header: '과목명',
            sortingType: 'asc',
            name: 'lectSubject',
            sortable: true,
        }
    ]
});


// 수강신청 한 학생 데이터 그리드
const grid2 = new tui.Grid({
    el: document.querySelector('#grid2'),
    data: null,
    scrollX: false,
    scrollY: false,
    rowHeaders: ['checkbox'],
    mimBodyHeight: 40,
    pageOptions: {
        useClient: true, // 클라이언트 페이징 활성화
        perPage: 5, // 페이지당 표시할 항목 수
    },
    columns: [
        {
            header: '학생명',
            name: 'userName',
            sortingType: 'asc',
            sortable: true
        },
        {
            header: '학번',
            name: 'userId',
            sortingType: 'asc',
            sortable: true,
        },
        {
            header: '이메일',
            sortingType: 'asc',
            name: 'userEmail',
            sortable: true,
        },
        {
            header: '과목명',
            sortingType: 'asc',
            name: 'lectSubject',
            sortable: true,
        },
        {
            header: '성별',
            sortingType: 'asc',
            name: 'userGender',
            sortable: true,
            formatter: (props) => {
                // 성별 변경하는 포매터
                const value = props.value;
                if (value === 'MALE') {
                    return '남성';
                } else if (value === 'FEMALE') {
                    return '여성';
                } else {
                    return '';
                }
            }
        }
    ]
})

// 클릭한 행의 강좌 정보 출력하기
grid.on('click', (ev) => {
    // 클릭한 행 강좌 ID
    const lectId = grid.getRow(ev.rowKey).lectId
    // 요청 보낼 url
    const url = '/api/apply/studentlist'

    // 서버에 요청하여 수강생 정보 탐색
    $.ajax({
        url: url,
        method: 'GET',
        data: {
            lectId : lectId
        },
        success: function (response) {
            // 찾아온 데이터로 그리드 정렬
            grid2.resetData(response)
        },
        error: function () {
            alert("데이터 불러오기 오류")
        }
    })

    // 체크된 학생 데이터 삭제
    deleteBtn.addEventListener('click', () => {
        const url = '/api/apply/deletestudent'
        // 체크된 행 키 값의 배열
        const rows = grid2.getCheckedRowKeys()
        const deleteRows = grid2.getCheckedRows();
        let deleteData = {
            lectId : lectId,
            deleteRows : deleteRows
        }
        console.log(JSON.stringify(deleteData))
        // 해당 행들 삭제
        grid2.removeRows(rows)
        // 삭제된 행 정보 컨트롤러로 전송
        $.ajax({
            url : url,
            method : 'DELETE',
            contentType: 'application/json',
            data : JSON.stringify(deleteData)
        })
    })
})

// 검색하여 그리드 갱신하기
const searchBtn = document.querySelector("#searchBtn")
const url = '/api/apply/lecturelist'

searchBtn.addEventListener('click', () => {
    const year = document.querySelector("#lectYear")
    const sem = document.querySelector("#lectSem")
    const nameSearch = document.querySelector(".lName")

    $.ajax({
        url: url,
        method: 'POST',
        data: {
            year: year.value,
            sem: sem.value,
            name: nameSearch.value,
        },
        success: function (response) {
            grid.resetData(response)
        },
        error: function () {
            alert("데이터 불러오기 오류")
        }
    })
})

