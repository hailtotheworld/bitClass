
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
    // box.style.left = e.pageX+"px";
    // box.style.top = e.pageY+"px";

    // box.style.left = e.x+"px"; // clientX
    // box.style.top = e.y+"px";

    box.style.left = e.offsetX+"px";
    box.style.top = e.offsetY+"px";
  }
});

