
//Ex2-이벤트 버블링을 이용해 사용자 이벤트 처리하기:event Bubbling
window.addEventListener("load", function () {

  var section = document.querySelector("#section2");
  var imgList = section.querySelector(".img-list");
  var currentImg = section.querySelector(".current-img");

  imgList.onclick = function (e) {
    if(e.target.nodeName != 'IMG') return;

    currentImg.src = e.target.src;

  };
});

//연습문제 1-선택된 레코드 삭제하기:event target
window.addEventListener("load", function () {

  var section = document.querySelector('#section1-1');
  var tbodyNode = section.querySelector('tbody');

  var delButton = tbodyNode.querySelectorAll('.del-button');

  tbodyNode.addEventListener('click',function(e) {
    if(e.target.nodeName != 'INPUT') return;

    e.target.parentElement.parentElement.remove();
    
  });

});

//Ex1-선택된 이미지 보여주기:event target
window.addEventListener("load", function () {

  var section = document.querySelector("#section1");

  var imgs = section.querySelectorAll(".img");
  var currentImg = section.querySelector(".current-img");

  for (var i = 0; i < imgs.length; i++) {
    imgs[i].onclick = function (e) {
      console.log(e.target.nodeName); //Node.nodeName은 자신의 대문자 태그명이다.
      currentImg.src = e.target.src;
    };
  }
}); 