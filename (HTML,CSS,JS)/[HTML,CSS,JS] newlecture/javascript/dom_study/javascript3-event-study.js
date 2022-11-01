
// Ex9-마우스 이벤트 객체: 박스의 옵셋 영역 좌표 이용하기 (스크롤 내려가도 기능유지하게끔)
window.addEventListener("load", function () {
  var section = document.querySelector('#section9');
  var container = section.querySelector(".container");
  var status = section.querySelector(".status");


});






// Ex8-마우스 이벤트 객체: 여러개 박스 드래그 방식으로 박스 옮기기
window.addEventListener("load", function () {
  var section = document.querySelector('#section8');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");



});



// Ex7-마우스 이벤트 객체: 드래그 방식으로 박스 옮기기
// (0) 마우스이동하는곳으로 따라오게하기
// (1) 마우스 누를때만 따라오게하기
// (2) 박스를 선택해야지만 박스 이동가능
// (3) 박스클릭한곳을 집기
window.addEventListener("load", function () {
  var section = document.querySelector('#section7');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");


});








































// Ex6-MouseEvent Position  (클릭한 곳으로 이동시켜봐)
window.addEventListener("load", function () {
  var section = document.querySelector('#section6');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");


  container.onclick = function (e) {
    box.style.left = e.pageX - container.offsetLeft + "px";
    box.style.top = e.pageY - container.offsetTop + "px";
  };


});