
// Ex9-마우스 이벤트 객체: 박스의 옵셋 영역 좌표 이용하기
window.addEventListener("load", function() {
  var section = document.querySelector('#section9');
  var container = section.querySelector(".container");
  var status = section.querySelector(".status");

  var dragging = false;
  var offset = {x:0,y:0};

  var current = null;
  var left = container.offsetLeft;
  var top = container.offsetTop;

  console.log(left);
  console.log(top);

  section.onmousedown = function(e) {
    if(e.target.classList.contains('box')){
        dragging = true;
        current = e.target;
        offset.x = e.offsetX;
        offset.y = e.offsetY;
    }
  };

  section.onmousemove = function(e) {
    if(!dragging) return;

    var x = e.pageX-offset.x-left;
    var y = e.pageY-offset.y-top;

    current.style.left = x+"px";
    current.style.top = y+"px";

    status.innerText = "(x,y):("+x+","+y+")";
  };

  section.onmouseup = function(e) {
    dragging = false;
  };

});

// Ex8-마우스 이벤트 객체: 여러개 박스 드래그 방식으로 박스 옮기기
window.addEventListener("load", function() {
  var section = document.querySelector('#section8');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  var dragging = false;
  var offset = {x:0,y:0};

  var current = null;

  container.onmousedown = function(e) {
    if(e.target.classList.contains('box')){
        dragging = true;
        current = e.target;
        offset.x = e.offsetX;
        offset.y = e.offsetY;
    }
  };

  container.onmousemove = function(e) {
    if(!dragging) return;

    current.style.left = e.pageX-offset.x+"px";
    current.style.top = e.pageY-offset.y+"px";
  };

  container.onmouseup = function(e) {
    dragging = false;
  };

  box.onmousedown = function(e) {

  };

});

// Ex7-마우스 이벤트 객체: 드래그 방식으로 박스 옮기기
window.addEventListener("load", function() {
  var section = document.querySelector('#section7');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  var dragging = false;
  var offset = {x:0,y:0};

  container.onmousedown = function(e) {
    if(e.target === box)
        dragging = true;
  };

  container.onmousemove = function(e) {
    if(!dragging) return;

    box.style.left = e.pageX-offset.x+"px";
    box.style.top = e.pageY-offset.y+"px";
  };

  container.onmouseup = function(e) {
    dragging = false;
  };

  box.onmousedown = function(e) {
    offset.x = e.offsetX;
    offset.y = e.offsetY;
  };


  // 첫번째단계, 클릭하면 따라오게하기
  // var dragging = false;

  // container.onmousedown = function(e) {
  //       dragging = true;
  // };

  // container.onmousemove = function(e) {
  //   if(!dragging) return;
  //   box.style.left = e.pageX+"px"; 
  //   box.style.top = e.pageY+"px"; 
  // };

  // container.onmouseup = function(e) {
  //   dragging = false;
  // };


});

// Ex6-MouseEvent Position
window.addEventListener("load", function() {
  var section = document.querySelector('#section6');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  container.onclick = function(e) {
    console.log("(x,y):"+e.x+","+e.y);
    console.log("client (x,y):"+e.clientX+","+e.clientY);
    console.log("page (x,y):"+e.pageX+","+e.pageY);
    console.log("offset (x,y):"+e.offsetX+","+e.offsetY);

    // pageX, pageY
    // 문서전체페이지기준
    box.style.left = e.pageX+"px";
    box.style.top = e.pageY+"px";

    // clientX, clientY
    // 보이는영역기준_기본값이다
    // box.style.left = e.x+"px";
    // box.style.top = e.y+"px";

    // offsetX, offsetY
    // 클릭하는곳최전방영역에서의좌표
    //   (컨테이너클릭하면컨테이너좌표적용,박스클릭하면박스좌표적용)
    // box.style.left = e.offsetX+"px";
    // box.style.top = e.offsetY+"px";
  }
});

