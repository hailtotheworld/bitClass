
//Ex9-다중 노드선택 방법과 일괄삭제, 노드의 자리바꾸기
window.addEventListener("load", function () {

  var section = document.querySelector("#section9");

  var noticeList = section.querySelector(".notice-list");
  var tbody = noticeList.querySelector("tbody");
  var allCheckbox = section.querySelector(".overall-checkbox");
  var delButton = section.querySelector(".del-button");
  var swapButton = section.querySelector(".swap-button");

  allCheckbox.onchange = function () { //.onchange 체크박스선택이 변경되었을때 이벤트가 발생한다
    /*
    console.log(allCheckbox.value); //value값을 아무것도 적지않으면 기본값으로 on이 전달된다.
    console.log(allCheckbox.checked); //체크되면true,체크해제되면false '반환한다'
    */

    var inputs = tbody.querySelectorAll("input[type='checkbox']");
    // 하나하나 for문 돌면서 체크해! (하나하나체크)
    for (var i = 0; i < inputs.length; i++) {
      inputs[i].checked = allCheckbox.checked;
    }
  };

  delButton.onclick = function () {
    // 하나하나 돌면서 체크된거 확인하지 말고, 체크된것들만 가져와. (체크된거확인해서가져오기)
    var checkedInputs = tbody.querySelectorAll("input[type='checkbox']:checked");

    for(var i=0;i<checkedInputs.length;i++) {
      checkedInputs[i].parentElement.parentElement.remove();
    }

  };

  swapButton.onclick = function () {


  };

});

//Ex8-노드 삽입과 바꾸기
window.addEventListener("load", function () {

  var section = document.querySelector("#section8");

  var noticeList = section.querySelector(".notice-list");
  var tbodyNode = noticeList.querySelector("tbody");
  var upButton = section.querySelector(".up-button");
  var downButton = section.querySelector(".down-button");

  var currentNode = tbodyNode.firstElementChild; //.children[0];

  downButton.onclick = function () {
    var nextNode = currentNode.nextElementSibling;
    if (nextNode == null) {
      alert("더 이상 이동할 수 없습니다.");
      return;
    }

    // tbodyNode.insertBefore(nextNode, currentNode);
    currentNode.insertAdjacentElement('beforebegin', nextNode)
  };

  upButton.onclick = function () {
    // current전에 있는 노드를 
    var prevNode = currentNode.previousElementSibling;
    if (prevNode == null) {
      alert("더 이상 이동할 수 없습니다.");
      return;
    }

    // tbodyNode.insertBefore(currentNode, prevNode);
    currentNode.insertAdjacentElement('afterend', prevNode);
  };

});

//Ex7 : 노드 복제와 템플릿 태그
window.addEventListener("load", function () {
  var notices = [
    { id: 5, title: "퐈이야~~~", regDate: "2019-01-26", writerId: "newlec", hit: 1 },
    { id: 6, title: "나 좀 복제해줘~", regDate: "2019-03-20", writerId: "newlec", hit: 17 }
  ];

  var section = document.querySelector("#section7");

  var noticeList = section.querySelector(".notice-list");
  var tbodyNode = noticeList.querySelector("tbody");
  var cloneButton = section.querySelector(".clone-button");
  var templateButton = section.querySelector(".template-button");

  cloneButton.onclick = function () {
    var trNode = noticeList.querySelectorAll('tbody tr')[0];
    var clone = trNode.cloneNode(true);
    var cloneTds = clone.querySelectorAll('td');
    cloneTds[0].innerText = notices[0].id;
    cloneTds[1].innerHTML = '<a href=' + notices[0].id + '>' + notices[0].title + '</a>';
    cloneTds[2].innerText = notices[0].regDate;
    cloneTds[3].innerText = notices[0].writerId;
    cloneTds[4].innerText = notices[0].hit;

    tbodyNode.appendChild(clone);

  };

  templateButton.onclick = function () {
    for (let i = 0; i < notices.length; i++) {
      var template = section.querySelector('template');
      var tClone = document.importNode(template.content, true);
      var tds = tClone.querySelectorAll('td');

      tds[0].innerText = notices[i].id;

      var aNode = tds[1].children[0];
      aNode.setAttribute('href', notices[i].id);
      aNode.innerText = notices[i].title;

      tds[2].innerText = notices[i].regDate;
      tds[3].innerText = notices[i].writerId;
      tds[4].innerText = notices[i].hit;

      tbodyNode.appendChild(tClone);
    }

  };

});

//Ex6 : 메뉴추가(createTextNode, Element)
window.addEventListener("load", function () {
  var section = document.querySelector("#section6");

  var titleInput = section.querySelector(".title-input");
  var menuListUl = section.querySelector(".menu-list");
  var addButton = section.querySelector(".add-button");
  var delButton = section.querySelector(".del-button");

  addButton.onclick = function () {

    var title = titleInput.value;
    var html = '<a href="">' + title + '</a>'
    var li = document.createElement('li');
    li.innerHTML = html;

    menuListUl.appendChild(li);

    /* append vs appendChild
    append(노드or문자열 여러개)
    appedChild(노드 한개만)
    
    menuListUl.append(title);
    // menuListUl.appendChild(title); // 에러가난다.
    */

    // 추가할때마다 기존객체가 삭제되고 새로운객체가 생성되서 성능에 문제가 된다.
    // menuListUl.innerHTML += '<li><a href="">'+title+'</a></li>';

    titleInput.value = "";

    /* var title = titleInput.value;
    var txtNode = document.createTextNode(title);
    var aNode = document.createElement("a");
    aNode.href="";
    aNode.appendChild(txtNode);

    var liNode = document.createElement("li");
    liNode.append(aNode);

    menuListUl.appendChild(liNode); */

    /* var title = titleInput.value;
      var txtNode = document.createTextNode(title);
      menuListDiv.appendChild(txtNode); */
  };

  delButton.onclick = function () {
    var liNode = menuListUl.children[0];
    // menuListUl.removeChild(liNode);
    liNode.remove();


    // 마지막 추가한거부터 지우기
    // var liNode = document.querySelectorAll('.menu-list li');
    // menuListUl.removeChild(liNode[liNode.length-1]);

  };

});

// Ex5 : 엘리먼트 노드의 속성 & CSS 속성 변경
window.addEventListener("load", function () {
  var section = document.querySelector("#section5");
  var srcInput = section.querySelector(".src-input");
  var imgSelect = section.querySelector(".img-select");
  var colorInput = section.querySelector(".color-input");
  var changeButton = section.querySelector(".change-button");
  var img = section.querySelector(".img");

  changeButton.onclick = function () {
    img.src = 'images/' + imgSelect.value;
    img.style.borderColor = colorInput.value;

  };
});

// Ex4 : Selectors API Level1 
window.addEventListener("load", function () {
  var section4 = document.querySelector("#section4");
  var box = section4.querySelector(".box");

  var input1 = box.children[0]; // 내려쓰면 빈공백이 생기는데 그 빈공백이 노드로 잡혔구나
  var input2 = box.children[1];

  input1.value = "hello";
  input2.value = "okay";

});

// Ex3 : Selectors API Level1 
window.addEventListener("load", function () {
  var section3 = document.getElementById("section3");
  var txtX = section3.querySelector("input[name='x']"); //속성으로 찾았다
  var txtY = section3.querySelector(".txt-y"); //클래스로 찾았네
  var btnAdd = section3.querySelector(".btn-add");
  var txtSum = section3.querySelector(".txt-sum");

  btnAdd.onclick = function () {
    var x = parseInt(txtX.value);
    var y = parseInt(txtY.value);

    txtSum.value = x + y;
  };
});

// Ex2 : 엘리먼트 선택방법 개선하기
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
    var x = parseInt(txtX.value);
    var y = parseInt(txtY.value);

    txtSum.value = x + y;
  };
});

// Ex1 : 계산기 프로그램
window.addEventListener("load", function () {
  var txtX = document.getElementById("txt-x");
  var txtY = document.getElementById("txt-y");
  var btnAdd = document.getElementById("btn-add");
  var txtSum = document.getElementById("txt-sum");

  btnAdd.onclick = function () {
    var x = parseInt(txtX.value);
    var y = parseInt(txtY.value);

    txtSum.value = x + y;
  };
});

