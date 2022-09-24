
// Ex5-엘리먼트 노드의 기본행위 막기
window.addEventListener("load", function () {

  var section = document.querySelector("#section5");
  var tbody = section.querySelector(".notice-list tbody");

  tbody.onclick = function (e) {
    e.preventDefault();
    var target = e.target;

    if (target.nodeName != "A") return;

    if (target.classList.contains("sel-button")) {

      var tr = target.parentElement;
      for (; tr.nodeName != "TR"; tr = tr.parentElement);

      tr.style.background = "yellow";

    } else if (target.classList.contains("edit-button")) {

    } else if (target.classList.contains("del-button")) {

    }
  }
});

// Ex4-서로 다른 기능의 여러 버튼을 가진 화면에서 이벤트를 처리하는 방법
window.addEventListener("load", function () {

  var section = document.querySelector("#section4");
  var tbody = section.querySelector(".notice-list tbody");

  tbody.onclick = function (e) {
    var target = e.target;

    if (target.nodeName != "INPUT") return;

    //if(target.className = "sel-button") //클래스가 1개라면 사용할수있긴한데, 클래스이름이 단독이름을 갖고있는 경우는 많지가 않다.
    if (target.classList.contains("sel-button")) {

      // var tr = target.parentElement.parentElement;
      //이렇게 찾는건 다른 인라인태그가 추가되면 변하기때문에 위험이 있다..!
      var tr = target.parentElement;
      for (; tr.nodeName != "TR"; tr = tr.parentElement);

      tr.style.background = "yellow";

    } else if (target.classList.contains("edit-button")) {

    } else if (target.classList.contains("del-button")) {

    }
  }
});

// Ex3-이벤트 버블링 멈추기
window.addEventListener("load", function () {

  var section = document.querySelector("#section3");

  var imgList = section.querySelector(".img-list");
  var addButton = section.querySelector(".add-button");
  var currentImg = section.querySelector(".current-img");

  imgList.onclick = function (e) {
    console.log('imgList.onclick');
    if (e.target.nodeName != 'IMG') return;

    currentImg.src = e.target.src;

  };

  addButton.onclick = function (e) {
    // e.stopPropagation();
    // 자식의이벤트(click)가 부모에게 전파되는걸 막는 메서드

    console.log('addButton.onclick');
    var img = document.createElement('img');
    img.src = "images/img1.jpg";
    currentImg.insertAdjacentElement('afterend', img);


  };

});

//Ex2-이벤트 버블링을 이용해 사용자 이벤트 처리하기:event Bubbling
window.addEventListener("load", function () {

  var section = document.querySelector("#section2");
  var imgList = section.querySelector(".img-list");
  var currentImg = section.querySelector(".current-img");

  imgList.onclick = function (e) {
    if (e.target.nodeName != 'IMG') return;

    currentImg.src = e.target.src;

  };
});

//연습문제 1-선택된 레코드 삭제하기:event target
window.addEventListener("load", function () {

  var section = document.querySelector('#section1-1');
  var tbodyNode = section.querySelector('tbody');

  var delButton = tbodyNode.querySelectorAll('.del-button');

  tbodyNode.addEventListener('click', function (e) {
    if (e.target.nodeName != 'INPUT') return;

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