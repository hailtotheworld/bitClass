
//1. let은 재선언이 불가능하다//////////////////////////////////////////////////////////////////////////////////////
/*
var x = 30;
console.log(x);
console.log(window.x); // var로 선언한 변수는 window객체의 전역속성이다.
var x = 31;
console.log(x); // var은 재선언이 가능하네. 치명적인 문제야.
// var 쓰지말자.

let y = 50;
console.log(y);
console.log(window.y); // let으로 선언한건 window객체의 전역속성이 아니다.
// let y = 51; // let으로는 재선언이 불가능
*/

//2. let을 통핸 변수의 지역화//////////////////////////////////////////////////////////////////////////////////////
/*
{var a = 30;}
console.log(a);

{let b = 50;} // let은 괄호블록을 사용하면 지역변수로 사용된다
// console.log(b); //에러

function getValue(contidition) {
  if(contidition){
    var value = "ok";
    return value;
  } else{
    return value;
  }
}

console.log(getValue(true));
console.log(getValue(false));//undefined: 변수가 선언되어있다는걸 의미한다. 값대입이 안되어있다는의미. 에러가나야정상인데...


function getLetValue(contidition) {
  if(contidition){ 
    let value = "ok";
    return value;
  } else{
    return value;
  }
}

console.log(getLetValue(true));
console.log(getLetValue(false));//에러발생. 이게 정상이지. let변수의 생명주기가 {}까지니까.
*/