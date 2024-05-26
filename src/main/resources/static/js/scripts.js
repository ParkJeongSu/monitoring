// scripts.js

function formatTimestamp(timestamp) {
    var date = new Date(timestamp);

    var year = date.getFullYear();
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var day = ('0' + date.getDate()).slice(-2);
    var hours = ('0' + date.getHours()).slice(-2);
    var minutes = ('0' + date.getMinutes()).slice(-2);
    var seconds = ('0' + date.getSeconds()).slice(-2);

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
}


// 6초마다 페이지 새로 고침 함수
function autoRefresh() {
    setInterval(function() {
        location.reload();
    }, refreshTime);
}

// 페이지가 로드되면 autoRefresh 함수 실행
window.onload = autoRefresh;


// Dynamically resize canvas to fit the parent element
//function resizeCanvas(canvas) {
//    const parent = canvas.parentElement;
//    canvas.width = parent.clientWidth;
//    canvas.height = parent.clientHeight;
//}
//
//const canvases = document.querySelectorAll('canvas');
//canvases.forEach(canvas => {
//    resizeCanvas(canvas);
//    window.addEventListener('resize', () => resizeCanvas(canvas));
//});