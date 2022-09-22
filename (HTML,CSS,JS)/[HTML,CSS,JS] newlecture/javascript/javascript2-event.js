
//Ex1-선택된 이미지 보여주기:event target
window.addEventListener("load", function () {

  var section = document.querySelector("#section1");

  var imgs = section.querySelectorAll(".img");
  var currentImg = section.querySelector(".current-img");

  for(var i=0;i<imgs.length;i++) {
    imgs[i].onclick = function (e) {
      console.log(e.target.nodeName); //Node.nodeName은 자신의 대문자 태그명이다.
      currentImg.src = e.target.src;
    };
  }
}); 