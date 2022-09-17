window.addEventListener("load",function () {
  btnPrint = document.getElementById("btn-print");

  btnPrint.onclick = function () {
    // btnPrint = document.getElementById("btn-print");

    var x = prompt("x의 값을 입력하세요", 0);
    var y = prompt("y의 값을 입력하세요", 0);

    x = parseInt(x);
    y = parseInt(y);
    btnPrint.value = x + y;
  };
});