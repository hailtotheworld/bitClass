(function getTotalHours() {

    let url = location.href;
    let tag = "";

    if(url.indexOf("playlist?list") != -1) {
        tag = "#thumbnail #overlays span.style-scope.ytd-thumbnail-overlay-time-status-renderer";
    } else {
        tag = "#thumbnail-container #thumbnail #overlays span.style-scope.ytd-thumbnail-overlay-time-status-renderer";
    }

    let ar = document.querySelectorAll(tag);

    let min = 0;
    let sec = 0;
    for (let i = 0; i < ar.length; i++) {
        min = min + parseInt(ar[i].innerText.split(":")[0]);
        sec = sec + parseInt(ar[i].innerText.split(":")[1]);
    }
    min += sec / 60

    let totalHours = Math.floor(min / 60);
    let totalMins = Math.floor(min % 60);
    let totalSec = Math.floor(sec % 60);

    alert(`총 재생시간은 ${totalHours}시간  ${totalMins}분 ${totalSec}초 입니다.`);
})();