
//let//////////////////////////////////////////////////////////////////////////////////////
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

//let//////////////////////////////////////////////////////////////////////////////////////
{var a = 30;}
console.log(a);

{let b = 50;} // let은 괄호블록을 사용하면 지역변수로 사용된다
// console.log(b); //에러