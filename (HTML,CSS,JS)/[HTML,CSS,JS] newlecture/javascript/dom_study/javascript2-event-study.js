

// Ex5-트리거
window.addEventListener("load", function () {
  var section = document.querySelector("#section5");
  var fileButton = section.querySelector('.file-button');
  var fileTriggerButton = section.querySelector('.file-trigger-button');

  fileTriggerButton.addEventListener('click',function(e){
    let event = new MouseEvent("click", {
      bubbles: true,
      cancelable: true,
      view: window,
    });
  
    fileButton.dispatchEvent(event);
  })


});
// Ex4-2-엘리먼트 노드의 기본행위 막기
window.addEventListener("load", function () {

  var section = document.querySelector("#section4-2");
  var tbody = section.querySelector(".notice-list tbody");

  tbody.addEventListener('click', function (e) {
    e.preventDefault();

    if (e.target.nodeName != 'A') return;

    document.body.classList.contains
    if (e.target.classList.contains('sel-button')) {
      $(e.target).closest('tr').css('background', 'red');
    } else if (e.target.classList.contains('edit-button')) {
      $(e.target).closest('tr').css('background', 'yellow');
    } else if (e.target.classList.contains('del-button')) {
      $(e.target).closest('tr').css('background', 'blue');
    }

  })

});

// Ex4-서로 다른 기능의 여러 버튼을 가진 화면에서 이벤트를 처리하는 방법
window.addEventListener("load", function () {

  var section = document.querySelector("#section4");
  var tbody = section.querySelector(".notice-list tbody");


  tbody.addEventListener('click', function (e) {
    if (e.target.nodeName != 'INPUT') return;

    document.body.classList.contains
    if (e.target.classList.contains('sel-button')) {
      $(e.target).closest('tr').css('background', 'red');
    } else if (e.target.classList.contains('edit-button')) {
      $(e.target).closest('tr').css('background', 'yellow');
    } else if (e.target.classList.contains('del-button')) {
      $(e.target).closest('tr').css('background', 'blue');
    }

  });


});

// Ex3-이벤트 버블링 멈추기
window.addEventListener("load", function () {

  var section = document.querySelector("#section3");

  var imgList = section.querySelector(".img-list");
  var addButton = section.querySelector(".add-button");
  var currentImg = section.querySelector(".current-img");

  imgList.addEventListener('click', function (e) {
    if (e.target.nodeName != 'IMG') return;

    currentImg.src = e.target.src;
  });

  addButton.addEventListener('click', function (e) {
    e.stopPropagation();

    let img = document.createElement('img');
    img.src = '../images/img1.jpg'
    currentImg.insertAdjacentElement('afterend', img);
  });



});

//Ex2-이벤트 버블링을 이용해 사용자 이벤트 처리하기:event Bubbling
window.addEventListener("load", function () {

  var section = document.querySelector("#section2");
  var imgList = section.querySelector(".img-list");
  var currentImg = section.querySelector(".current-img");

  imgList.addEventListener('click', function (e) {
    if (e.target.nodeName != 'IMG') return;

    currentImg.src = e.target.src;
  })




});

//연습문제 1-선택된 레코드 삭제하기:event target
window.addEventListener("load", function () {

  var section = document.querySelector('#section1-1');
  var tbodyNode = section.querySelector('tbody');
  var delButton = tbodyNode.querySelectorAll('.del-button');

  tbodyNode.addEventListener('click', function (e) {
    if (e.target.nodeName != 'INPUT') return;

    $(e.target).closest('tr').remove();

  });



});

//Ex1-선택된 이미지 보여주기:event target
window.addEventListener("load", function () {

  var section = document.querySelector("#section1");
  var imgs = section.querySelectorAll(".img");
  var currentImg = section.querySelector(".current-img");



}); 