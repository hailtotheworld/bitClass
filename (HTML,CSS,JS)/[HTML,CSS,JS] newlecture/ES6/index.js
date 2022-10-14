
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

//2. let을 통한 변수의 지역화//////////////////////////////////////////////////////////////////////////////////////
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


//3. const 상수//////////////////////////////////////////////////////////////////////////////////////
/*
const N=1;
const S=5;

let walkTo = S;
// S = 3;
// console.log(S);

const add = function(a,b) {
  return a+b;
}
// add = 50;

console.log(add(3,4));
*/

//4. template String//////////////////////////////////////////////////////////////////////////////////////
/*
let oldTemplate = 
"<section> \
    <h1></h1> \
    <p></p> \
</section>";

let title = "ES6";
let content = "새로운 문자열";

let template =
String.raw`<section>
    <h1>${title}</h1>\n\n
    <p>${content}</p>
</section>`;

console.log(template);
*/

//5. 객체(키:값)에서  :값 생략할수있다//////////////////////////////////////////////////////////////////////////////////////

/*
let kor = 30;
let eng = 40;
let math = 50;

// let exam = {
//   kor:kor,
//   eng:eng,
//   math:math,         // :값 생략해도 키가 값과 이름이 같으니까 :값 생략하고 키만 남겨도돼.
//   total:function() { // :function 생략해도 함수가 대입된다는걸 알수있으니까 키만 남겨도돼.
//     return kor+eng;
//   }
// };

let exam = {kor,eng,math,total(){
  return kor+eng;
}};

console.log(exam.total())
*/

//6. (키이름:값)에서 변수를 [키이름]에 대입할수있다.//////////////////////////////////////////////////////////////////////////////////////
/*
let attr = "kor";

let exam = {
  [attr]:10
};

console.log(exam.kor);
*/

//////////////////////////////////////////////////////////////////////////////////
/*
let attr = "kor";
let eng = 20;

let exam = {
  [attr]:10,          // [키이름] 대입가능
  eng,                // 키이름:값 같다면  :값  생략가능
  total() {return 30} // 함수이름:function()에서  :function()  생략가능
};
*/
//////////////////////////////////////////////////////////////////////////////////

//8. Object Destructuring#1////////////////////////////////////////////////////////////////////////////////////
/*
let exam = {
  kor:20,
  eng:30,
  math:40
};

function print(exam) {
  // 이렇게 객체에서 각각의 값을 꺼내는건 성능에 좋지 않다. 
  // console.log(`kor:${exam.kor},eng:${exam.eng}`);

  // 이렇게 객체를 미리 뽀개두고 뽀갠값을 이용하는게 성능에 더 좋다.
  // let kor = exam.kor;
  // let eng = exam.eng;
  // console.log(`kor:${kor},eng:${eng}`);
  
  let {kor,eng} = exam;
  console.log(`kor:${kor},eng:${eng}`);
}

print(exam);


function printB({kor,eng,math}) { // 함수를 만들때부터 매개변수에서 객체를 뽀개서 받는다.
  console.log(`kor:${kor},eng:${eng},math:${math}`);
}

printB(exam);
*/

//9. Object Destructuring#2////////////////////////////////////////////////////////////////////////////////////
/*
let exam = {
  kor:50,
  eng:60,
  math:70
};

let {kor,eng,math} = exam;
console.log(`kor:${kor},eng:${eng},math:${math}`);

exam.kor=100; // 단독으로는 뽀개진객체에는 반영이 안된다
exam.eng=90;
({kor,eng}=exam); // 반드시 갱신해줘야한다.

console.log(`kor:${kor},eng:${eng},math:${math}`);
*/

/*
//쪼개진객체/////////////////////////////
let exam = {
  kor:50,
  eng:62,
  math:70
};

// 새로운 '키=값'을 넣을수있다. 이렇게 쪼개진객체에 직접 넣은 새로운 값은 쪼개진객체에만적용된다.
let {kor,eng,math,total=(kor+eng+math)} = exam;

exam.kor = 100; // 진짜객체에만적용
exam.eng = 100; // 진짜객체에만적용
exam.avg = (exam.kor+exam.eng+exam.math)/3;  // 진짜객체에만적용
({kor,eng,avg}=exam);  // 쪼개진객체에적용시키기위해서는 갱신시켜야한다.

console.log(`kor:${kor},eng:${eng},math:${math},total:${total},avg:${avg}`);
// kor:100,eng:100,math:70,total:182(갱신적용안됨!),avg:90

console.log(exam);
//kor: 100, eng: 100, math: 70, avg: 90
*/


//10. Object Destructuring#3////////////////////////////////////////////////////////////////////////////////////

/*
let exam = {
  kor:50,
  eng:60,
  math:70,
  student:{
   name:"newlec",
   phone:"010-2222-3333" 
  }
};

// 객체의 속성과 다른이름 지정하는 방법
// 객체안의 객체에서 속성 뽑아내는방법
let{kor:k, eng:e, student:{name,phone}} = exam;

// console.log(kor); // 선언된 변수가 없다며 오류발생
console.log(k);
console.log(name);
 */

//11. Array Destructuring#1////////////////////////////////////////////////////////////////////////////////////

/*
let kors = [10,20,30];
let [,kor2,kor3] = kors;
console.log(`kor2:${kor2}, kor3:${kor3}`)

let temp = [40,50,60];
kors = temp;
console.log(kors);
*/

//11. Array Destructuring#1////////////////////////////////////////////////////////////////////////////////////

// let kors = [10,20,30];
// let [kor1,kor2,kor3,kor4=40] = kors;
// console.log(kor4) 

// let notice = {
//   title:"공지사항",
//   files:["img1.png", "img.png"]
// };

// let {files:[first]} = notice;
// console.log(first);

/*
// 객체뽀개기, 배열뽀개기
let notices = {
  title:"공지사항",
  list:[
    {title:"첫번째제목",content:"첫번째내용"},
    {title:"두번째제목",content:"두번째내용"}
  ]
};

let {list:[first,second]}= notices;
console.log(second.title);
*/

// 13. Set /////////////////////////////////////////////////////////////////////////////////////////////////////
/*
let ar = [1,3,3,2,4,4,2,5];
let set = new Set(ar);
console.log(set.size); //중복이 제거된다.

set.forEach(function(value,key,ownerSet) {
  console.log(`key:${key},value:${value}`)
});

for (let v of set) { //forof문은 값을 반환
  console.log(v);
}

for (let [k,v] of set.entries()) {
  console.log(`${k},${v}`);
}

for (let v in set) { //forin문은 키를 반환
  console.log(v);
}
*/

// 14. Map /////////////////////////////////////////////////////////////////////////////////////////////////////

let exam = new Map();
exam.set("kor",10);
exam.set("eng",20);
exam.set("math",30);

for (let [k,v] of exam.entries()) {
  console.log(`${k},${v}`);
}

let first = new Map([
  [1, 'one'],
  [2, 'two'],
  [3, 'three'],
]);

for (let [k,v] of first.entries()) {
  console.log(`${k},${v}`);
}










