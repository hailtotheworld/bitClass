
// Ex9-마우스 이벤트 객체: 박스의 옵셋 영역 좌표 이용하기 (스크롤 내려가도 기능유지하게끔)
window.addEventListener("load", function () {
  var section = document.querySelector('#section9');
  var container = section.querySelector(".container");
  var status = section.querySelector(".status");




});








// Ex8-마우스 이벤트 객체: 여러개 박스 드래그 방식으로 박스 옮기기
window.addEventListener("load", function () {
  var section = document.querySelector('#section8');
  var container = section.querySelector(".container8");
  var box = section.querySelector(".box");

  let dragging = false;
  let current = null;
  let boxOffset = {x:0,y:0};

  container.addEventListener('mousedown',function(e) {
    if(e.target.classList.contains('box')) {
      dragging = true;
      current = e.target;
      boxOffset.x = e.offsetX;
      boxOffset.y = e.offsetY;
    }
  });

  container.addEventListener('mousemove',function(e){
    if(dragging!=true) return;

    current.style.left = e.pageX-container.offsetLeft-boxOffset.x+"px";
    current.style.top = e.pageY-container.offsetTop-boxOffset.y+"px";
  })

  container.addEventListener('mouseup',function(e){
    dragging = false;
  });


});












































// Ex7-마우스 이벤트 객체: 드래그 방식으로 박스 옮기기
window.addEventListener("load", function () {
  var section = document.querySelector('#section7');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  let dragging = false;
  let boxOffset = { x: 0, y: 0 }

  box.addEventListener('mousedown', function (e) {
    dragging = true;
  });

  container.addEventListener('mousemove', function (e) {
    if (dragging == true) {

      box.style.left = e.pageX - boxOffset.x - container.offsetLeft + "px";
      box.style.top = e.pageY - boxOffset.y - container.offsetTop + "px";
    }
  });

  container.addEventListener('mouseup', function (e) {
    dragging = false;
  });

  box.addEventListener('mousedown', function (e) {
    boxOffset.x = e.offsetX;
    boxOffset.y = e.offsetY;
  });


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