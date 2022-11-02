
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

    current.style.left = e.pageX-offset.x- container.offsetLeft+"px";
    current.style.top = e.pageY-offset.y- container.offsetTop+"px";
  };

  container.onmouseup = function(e) {
    dragging = false;
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

  // (0) 마우스이동하는곳으로 따라오게하기
  // (1) 마우스 누를때만 따라오게하기
  // (2) 박스를 선택해야지만 박스 이동가능
  // (3) 박스클릭한곳을 집기

  // (0) 마우스이동하는곳으로 따라오게하기
  // container.onmousemove = function(e) {
  //   box.style.left = e.pageX+"px"; //
  //   box.style.top = e.pageY+"px";
  // };
  ////////////////////////////////////////////////
  // (1) 마우스 누를때만 따라오게하기
  // var dragging = false;

  // container.onmousedown = function(e) {
  //       dragging = true;
  // };

  // container.onmousemove = function(e) {   // 마우스눌렀을때 onmousemove
  //   if(!dragging) return;
  //   box.style.left = e.pageX+"px"; 
  //   box.style.top = e.pageY+"px"; 
  // };

  // container.onmouseup = function(e) {   // 마우스뗐을때 onmouseup
  //   dragging = false;
  // };
  ///////////////////////////////////////////////////////////////////////////
  // (2) 박스를 선택해야지만 박스 이동가능
  // var dragging = false;

  // container.onmousedown = function(e) {
  // if(e.target === box) // (2)박스를 선택해야지만 박스 이동가능
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

  ///////////////////////////////////////////////////////////////////////////
  // (3)박스클릭한곳을 집기
  // var dragging = false;
  // var offset = {x:0,y:0}; // (3)박스클릭한곳을 집기

  // container.onmousedown = function(e) {
  // if(e.target === box)
  //       dragging = true;
  // };

  // container.onmousemove = function(e) {
  //   if(!dragging) return;
  // box.style.left = e.pageX-offset.x+"px"; // (3)박스클릭한곳을 집기
  // box.style.top = e.pageY-offset.y+"px"; // (3)박스클릭한곳을 집기
  // };

  // container.onmouseup = function(e) {
  //   dragging = false;
  // };

  // box.onmousedown = function(e) { // (3)박스클릭한곳을 집기
  //   offset.x = e.offsetX; // (3)박스클릭한곳을 집기
  //   offset.y = e.offsetY; // (3)박스클릭한곳을 집기
  // };



});

// Ex6-MouseEvent Position
window.addEventListener("load", function() {
  var section = document.querySelector('#section6');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  let left = container.offsetLeft;
  let top = container.offsetTop;

  container.onclick = function(e) {
    console.log("(x,y):"+e.x+","+e.y);
    console.log("client (x,y):"+e.clientX+","+e.clientY);
    console.log("page (x,y):"+e.pageX+","+e.pageY);
    console.log("offset (x,y):"+e.offsetX+","+e.offsetY);

    // pageX, pageY
    // 문서전체페이지기준
    box.style.left = e.pageX -left +"px";
    box.style.top = e.pageY-top+"px";

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

