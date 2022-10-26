//Ex10-클릭한 컬럼을 기준으로 레코드 정렬하기 #1
window.addEventListener("load", function () {

  var notices = [
    { "id": 1, "title": "c유투브에 끌려다니지 않으려고 했는데....ㅜㅜ..", "regDate": "2019-02-05", "writerId": "newlec", "hit": 2 },
    { "id": 2, "title": "b자바스크립트란..", "regDate": "2019-02-02", "writerId": "newlec", "hit": 0 },
    { "id": 3, "title": "z기본기가 튼튼해야....", "regDate": "2019-02-01", "writerId": "newlec", "hit": 1 },
    { "id": 4, "title": "a근데 조회수가 ㅜㅜ..", "regDate": "2019-01-25", "writerId": "newlec", "hit": 0 }
  ];

  var section = document.querySelector("#section10");
  var noticeList = section.querySelector(".notice-list");
  var titldTd = section.querySelector(".title");
  var tbodyNode = noticeList.querySelector("tbody");

  function bindData() {
    let template = section.querySelector('template');

    for (let i = 0; i < notices.length; i++) {
      let clone = document.importNode(template.content, true);
      let tds = clone.querySelectorAll('td');
      tds[0].innerText = notices[i].id;
      tds[1].innerHTML = `<a href=${notices[i].id}>${notices[i].title}</a>`;
      tds[2].innerText = notices[i].regDate;
      tds[3].innerText = notices[i].writerId;
      tds[4].innerText = notices[i].hit;

      tbodyNode.append(clone);
    }
  };

  bindData();

  let toggle = false;

  titldTd.addEventListener('click', function () {

    tbodyNode.innerHTML = "";

    if (toggle == false) {
      notices.sort(function (a, b) {
        if (a.title > b.title) {
          return 1;
        }
        if (a.title < b.title) {
          return -1;
        }
        return 0;
      });
      toggle=true;
    }

    bindData();
    notices.reverse();
  });


});

//Ex9-다중 노드선택 방법과 일괄삭제, 노드의 자리바꾸기
window.addEventListener("load", function () {

  var section = document.querySelector("#section9");
  var noticeList = section.querySelector(".notice-list");
  var tbody = noticeList.querySelector("tbody");
  var allCheckbox = section.querySelector(".overall-checkbox");
  var delButton = section.querySelector(".del-button");
  var swapButton = section.querySelector(".swap-button");


  allCheckbox.onchange = function () {
    let check = tbody.querySelectorAll('input[type="checkbox"]');

    for (let i = 0; i < check.length; i++) {
      check[i].checked = allCheckbox.checked;
    }


  };

  delButton.onclick = function () {
    let check = tbody.querySelectorAll('input[type="checkbox"]:checked');

    $(check).closest('tr').remove();

  };

  swapButton.onclick = function () {
    let check = tbody.querySelectorAll('input[type="checkbox"]:checked');

    if (check.length != 2) {
      console.log('2개만 고르시오');
      return;
    }

    let trs = $(check).closest('tr');
    let clone = trs[0].cloneNode(true);
    trs[1].replaceWith(clone);
    trs[0].replaceWith(trs[1]);

  };

});

//Ex8-노드 삽입과 바꾸기
window.addEventListener("load", function () {

  var section = document.querySelector("#section8");
  var noticeList = section.querySelector(".notice-list");
  var tbodyNode = noticeList.querySelector("tbody");
  var upButton = section.querySelector(".up-button");
  var downButton = section.querySelector(".down-button");

  let selectNode = $(tbodyNode).children()[0];


  downButton.onclick = function () {
    let nextNode = $(selectNode).next()[0];

    if (nextNode == null) {
      console.log('더 이상 이동할 수 없습니다.')
      return;
    }

    nextNode.insertAdjacentElement('afterend', selectNode);

  };

  upButton.onclick = function () {
    let prevNode = $(selectNode).prev()[0];

    if (prevNode == null) {
      console.log('더 이상 이동할 수 없습니다.')
      return;
    }

    prevNode.insertAdjacentElement('beforebegin', selectNode);

  }


});


//Ex7 : 노드 복제와 템플릿 태그
window.addEventListener("load", function () {
  var notices = [
    { id: 5, title: "복제해보자", regDate: "2019-01-26", writerId: "newlec", hit: 0 },
    { id: 6, title: "나 좀 복제해줘~", regDate: "2019-01-26", writerId: "newlec", hit: 17 }
  ];

  var section = document.querySelector("#section7");
  var noticeList = section.querySelector(".notice-list");
  var tbodyNode = noticeList.querySelector("tbody");
  var cloneButton = section.querySelector(".clone-button");
  var templateButton = section.querySelector(".template-button");

  cloneButton.onclick = function () {

    let trNode = tbodyNode.querySelector('tr');
    // let trNode = $(tbodyNode).children('tr');

    let clone = trNode.cloneNode(true);
    // let clone = document.importNode(trNode,true);

    let tds = clone.querySelectorAll('td');
    // let tds = $(clone).children('td');
    tds[0].innerText = notices[0].id;
    tds[1].innerHTML = `<a href=${notices[0].id}>${notices[0].title}</a>`;
    tds[2].innerText = notices[0].regDate;
    tds[3].innerText = notices[0].writerId;
    tds[4].innerText = notices[0].hit;

    tbodyNode.append(clone);
  };

  templateButton.onclick = function () {
    let template = document.querySelector('template');
    let clone = document.importNode(template.content, true);
    let tds = clone.querySelectorAll('td');
    tds[0].innerText = notices[0].id;
    tds[1].innerHTML = `<a href=${notices[0].id}>${notices[0].title}</a>`;
    tds[2].innerText = notices[0].regDate;
    tds[3].innerText = notices[0].writerId;
    tds[4].innerText = notices[0].hit;

    tbodyNode.append(clone);
  };

});


//Ex6 : 메뉴추가(createTextNode, Element)
window.addEventListener("load", function () {
  var section = document.querySelector("#section6");

  var titleInput = section.querySelector(".title-input");
  var menuListUl = section.querySelector(".menu-list");
  var addButton = section.querySelector(".add-button");
  var delButton = section.querySelector(".del-button");

  addButton.onclick = function (e) {
    let li = document.createElement('li');
    li.innerHTML = `<a href="">${titleInput.value}<a>`;
    menuListUl.append(li);

    titleInput.value = "";
  };

  delButton.onclick = function (e) {
    // menuListUl.firstElementChild.remove();
    menuListUl.lastElementChild.remove();

  };


});

//Ex5 : 엘리먼트 노드의 속성& CSS 속성 변경
window.addEventListener("load", function () {
  var section = document.querySelector("#section5");
  var srcInput = section.querySelector(".src-input");
  var imgSelect = section.querySelector(".img-select");
  var changeButton = section.querySelector(".change-button");
  var img = section.querySelector(".img");
  var colorInput = section.querySelector(".color-input");

  changeButton.onclick = function () {
    // img의 src를 변경해야 한다.

    img.src = imgSelect.value;
    img.style.borderColor = colorInput.value;

  };

});

//Ex4 : childeNodes를 이용한 노드 선택
// input 두개에 아무거나 써봐
window.addEventListener("load", function () {
  var section4 = document.querySelector("#section4");
  var box = section4.querySelector(".box");

  box.children[0].value = "he"
  box.children[1].value = "h2"

});

//Ex3 : Selectors API Level1
window.addEventListener("load", function () {
  var section3 = document.getElementById("section3");
  var txtX = section3.querySelector("input[name='x']");
  var txtY = section3.querySelector(".txt-y");
  var btnAdd = section3.querySelector(".btn-add");
  var txtSum = section3.querySelector(".txt-sum");

  btnAdd.onclick = function () {

  };
});

//Ex2 : 엘리먼트 선택방법 개선하기
window.addEventListener("load", function () {
  var section2 = document.getElementById("section2");
  var txtX = section2.getElementsByClassName("txt-x")[0];
  var txtY = section2.getElementsByClassName("txt-y")[0];
  var btnAdd = section2.getElementsByClassName("btn-add")[0];
  var txtSum = section2.getElementsByClassName("txt-sum")[0];

  /*
  var inputs = section2.getElementsByTagName("input");
  var txtX = inputs[0];
  var txtY = inputs[1];
  var btnAdd = inputs[2];
  var txtSum = inputs[3];
  */

  btnAdd.onclick = function () {

  };
});

//Ex1 : 계산기 프로그램
window.addEventListener("load", function () {
  var txtX = document.getElementById("txt-x");
  var txtY = document.getElementById("txt-y");
  var btnAdd = document.getElementById("btn-add");
  var txtSum = document.getElementById("txt-sum");

  btnAdd.onclick = function () {

  };
});