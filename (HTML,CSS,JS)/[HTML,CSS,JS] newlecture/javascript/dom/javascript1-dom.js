
//Ex6 : 메뉴추가(createTextNode, Element)
window.addEventListener("load", function () {
  var section = document.querySelector("#section6");

  var titleInput = section.querySelector(".title-input");
  var menuListUl = section.querySelector(".menu-list");
  var addButton = section.querySelector(".add-button");
  var delButton = section.querySelector(".del-button");

  addButton.onclick = function () {
    
    var title = titleInput.value;    

    var html = '<a href="">'+title+'</a>';
    var li = document.createElement("li");
    li.innerText = html;
    

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
    img.src = "images/" + srcInput.value;
    // img.src = "images/"+imgSelect.value;

    // img.style["border-color"] = colorInput.value;
    img.style.borderColor = colorInput.value;

    console.log(srcInput["class"]);
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

