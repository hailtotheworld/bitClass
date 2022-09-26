
// Ex6-MouseEvent Position
window.addEventListener("load", function() {
  var section = document.querySelector('#section6');
  var container = section.querySelector(".container");
  var box = section.querySelector(".box");

  container.onclick = function(e) {
    // e.x, e.y / e.offsetX, e.offsetY / e.clientX, e.pageX ...
    console.log("(x,y):"+e.x+","+e.y);
    box.style.left = e.x+"px";
    box.style.top = e.y+"px";

  }
})

