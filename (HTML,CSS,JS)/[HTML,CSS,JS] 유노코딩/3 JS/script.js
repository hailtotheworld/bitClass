//2//window.alert/////////////////////////////////////////////////////////////////////////////////////////
// window.alert('경고발생')
// window.alert('경고발생22')
// window.alert('경고발생333')

// 한줄짜리 주석
/* 여러줄 주석 */


//3//console.log, console.clear/////////////////////////////////////////////////////////////////////////////////////////
// window.console.log('기록남는다') // 콘솔화면에 기록을 남기겠다는 의미이다.
// console.log('console접근할때 window.은 생략이가능하다.'); console.log('세미콜론이 있으면 구문이 하나 끝난거라서 한줄에 코드를 이어서쓸수있다')
// console.log('세미콜론;은 한줄의 코드에 두 줄 이상의 구문이 있을때는 반드시 필요하다.')
// console.log('한줄에 한구문만 있을때는 세미콜론을 굳이 써주지 않아도 된다. 선택이지.')

// console.clear() // console을 깨끗하게 지워준다. log로 기록해둔게 다 지워졌네.


//4//let/////////////////////////////////////////////////////////////////////////////////////////
// console.log(0);
// console.log(-3.14);

// console.log('문자열을 표현할때는 작은따옴표와 큰따옴표 모두가능')
// console.log("문자열을 표현할때는 작은따옴표와 큰따옴표 모두가능")

// let aa = 10; // 대입
// console.log(aa)
// aa = '변했어' // 변수를 기억하고 있는 데이터를 바꿀 수 있다
// console.log(aa) 


//5//const, window.prompt/////////////////////////////////////////////////////////////////////////////////////////
// const promptMessage = "프롬프트에 표시할 문자열"
// const result = prompt(promptMessage);
// console.log(result);


//6//`템플릿 리터럴`/////////////////////////////////////////////////////////////////////////////////////////

// 백틱을 이용한 문자열도 문자열과 동일하게 취급된다.
// let str = "따옴표 문자열";
// console.log(str);
// str = `백틱을 이용해서만든 템플릿리터럴`;
// console.log(str);


// let number = 1;
// let player = "새해";
// console.log(`${player}의 날짜는 ${number}일 입니다.`);


// let number = 21;
// let player = prompt("좋아하는 축구선수는?")
// console.log(
//   `제가 좋아하는 축구선수는 ${player}, 그의 등번호는 ${21}입니다.`
// ) // 위아래 같은문장이다.
// console.log(
//   `제가 좋아하는 축구선수는 ${prompt("좋아하는 축구선수는?")}, 그의 등번호는 ${21}입니다.`
// )


/* let player = prompt("좋아하는 선수이름은 무엇인가요?")
 console.log(
   `당신이 좋아하는 선수이름은 ${player}(이)고, 등번호는 ${prompt("그 선수 등번호는 뭔가요?")}`
) */


//7//연산자/////////////////////////////////////////////////////////////////////////////////////////

// let result = 4;
// result += 6;
// console.log(result);


//8//null,undefined,boolean / typeof/////////////////////////////////////////////////////////////////////////////////////////

// let data;
// console.log(data);
// data = null;
// console.log(data)

// let data1 = true;
// console.log(typeof data1);
// data1 = false;
// console.log(data1)
// data = True // 에러난다. is not defined.
// console.log(data1);

// let test = 314
// console.log(typeof "st")

//10//document.querySelector(),document.getElementById()/////////////////////////////////////////////////////////////////////////////////////////
// console.log(document.querySelector("h1")) // 요소를 반환해준다 eg)<h1>큰제목입니다</h1>
// console.log(document.querySelector("p"))
// console.log(document.querySelector("#iden"))
// console.log(document.querySelector(".clazz"))
// console.log(document.querySelector("ul>li:nth-child(3)"))

// console.log(document.getElementById("iden"))


// const h1t = document.querySelector("h1")
// console.log(h1t.textContent) // 텍스트를 반환해준다. eg)큰제목입니다
// h1t.textContent = prompt("변경원하는 제목을 입력해보세요")

// console.log(document.getElementById("iden").textContent)


//11//비교연산자(대소비교,등가비교)/////////////////////////////////////////////////////////////////////////////////////////
// let num1 = 3;
// let num2 = 5;
// console.log(num1 > num2)
// console.log(num1 < num2)

// let num1 = '3';
// let num2 = 3;
// console.log(num1 == num2)  //true
// console.log(num1 != num2)  //false
// console.log(num1 === num2) //false
// console.log(num1 !== num2) //true


//12//조건문if/////////////////////////////////////////////////////////////////////////////////////////
// let num = 3
// console.log(num==3)

// if(num==7) {
//   console.log("조건으로 사용된 비교연산식이 참을 반환했다")
// } else {
//   console.log("거짓")
// } 


//13//반복문while/////////////////////////////////////////////////////////////////////////////////////////
// let number = 1;
// while(number <= 10) {
//   console.log(number);
//   number+=1;
// }

// window.alert("경고창에 쓸 메시지!"); // undefined값이 남는다.

// window.confirm("경고창에 쓸 메시지!"); // 확인true, 취소false 선택해서 누를수 있다.
// console.log(confirm("메시지"));

// while(confirm("취소를 누를때까지 반복됩니다")) {
//   console.log("확인을 누르셨군요")
// }
// console.log("취소 버튼을 눌렀군요")

//14//반복문for/////////////////////////////////////////////////////////////////////////////////////////
// for(let i=1;i<=3;i++) {
//   console.log(i,"번째 반복중입니다")
// }

// for(let i=1;i<=10;i++) {
//   if(i%2==0) {
//     console.log(i,"는 짝수입니다")
//   }
// }

// for(let i=1;i<=10;i+=2) {
//   console.log(i)
// }

//15//함수선언식,함수표현식/////////////////////////////////////////////////////////////////////////////////////////
// let number = 3;
// let myNumber = 5; //낙타표기법
// console.log(myNumber);

// 함수선언식: 처음만들어질때부터 이름이 있는 함수를 만든다.
// sayHello() // 함수호출문이 함수선언식보다 위에 있어도 괜찮다. => 호이스팅hoisting이 가능하다.
// function sayHello() {
//   console.log("Hello")
//   console.log("Hi")
//   console.log("안녕")
//   let hello = "문자열 헬로" // 지역변수
//   console.log(hello) 
// }
// console.log(hello) //오류. 함수 내부에서 선언한 변수(=지역변수)는 함수 바깥에서 사용할 수 없다.


// 함수표현식: 이름이없는 익명함수를 만든다음에 이름을 붙혀주는거다.
// const sayBye = function() {
//   console.log("good bye~")
// }
// sayBye()


//16//return/////////////////////////////////////////////////////////////////////////////////////////
// const result = confirm("참or거짓")
// console.log(result);

// function noReturn() {
//   console.log("데이터를 반환하지 않는 함수이다.")
// }
// console.log(noReturn()) // 함수기능수행하고 / undefined반환된다(반환한게 없다는 의미이다)

// function yesReturn() {
//   return "반환하는 함수이다"
// }
// console.log(yesReturn());

// function onlyOne() {
//   return 10,20,30,50
// }
// console.log(onlyOne()) // 값이 마지막에 쓴 하나만 반환된다.


//17//매개변수/////////////////////////////////////////////////////////////////////////////////////////
// function noReturnNoPara() {
//   console.log("리턴도 없고, 매개변수도 없다")
// }
// noReturnNoPara();

// function usePara(num, par) {
//   for (let i = 0; i < num; i++) {
//     console.log("날씨는", par, "입니다")
//   }
// }
// usePara(3,"맑음")

// function oddEven(num) {
//   if(num<=0) {
//     return "1 이상의 자연수만 입력하세요."
//   } else if (num%2==0) {
//     return "짝수입니다"
//   } else if(num%2==1) {
//     return "홀수입니다."
//   }
// }
// console.log(oddEven(0))
// console.log(oddEven(-7))
// console.log(oddEven(4))
// console.log(oddEven(3))

//18//이벤트/////////////////////////////////////////////////////////////////////////////////////////

// const inputType = document.querySelector("#typing") // 타입이 object이다.
// const inputClick = document.querySelector("#push")

// const handleTyping = function() {
//   console.log("타이핑되고있어요")
// }

// inputType.onkeydown = handleTyping; // eg) 백스페이스,ctrl 다적용되네
// inputType.onkeydown = function() {
//   console.log("on이벤트명과 같은 이벤트속성을 사용하면, 마지막이벤트만 적용된다")
// }

// // 이벤트핸들러함수는 익명함수를 사용할수있다.
// inputClick.onclick = function() {
//   console.log("클릭되고있어요")
// }


//19//addEventListener/////////////////////////////////////////////////////////////////////////////////////////
/*
const btn1 = document.getElementById("one")
const btn2 = document.getElementById("two")
const btn3 = document.getElementById("three")

const handleClick = function() {
  console.log("저를 클릭하셨나요?")
}

// 1) 다수의 이벤트핸들러 추가가능
btn1.addEventListener('click',handleClick)
btn1.addEventListener('click',function() {
  console.log("두번째 이벤트핸들러 등록")
})

// 2) 이벤트핸들러 제거가능
btn1.removeEventListener('click',handleClick)

/////////////이벤트객체////////////////
const handleEventObject = function(event) {
  console.log(event.target)
}

btn1.addEventListener('click',handleEventObject)
btn2.addEventListener('click',handleEventObject)
btn3.addEventListener('click',handleEventObject)
*/


//20//document.createElement & document.appendChild/////////////////////////////////////////////////////////////////////////////////////////
/*
const button1 = document.getElementById("push1")
const div1 = document.getElementById("area")

button1.addEventListener('click', function(){
  console.log("div 생성중")
  const newDiv = document.createElement('div')

  newDiv.style.backgroundColor = "red"
  newDiv.style.width = "200px"
  newDiv.style.height = "200px"
  newDiv.style.border = "1px solid black"
  
  div1.appendChild(newDiv)
})
*/



//21//value / event.preventDafault/////////////////////////////////////////////////////////////////////////////////////////

/*
const text = document.getElementById("text")
const button1 = document.getElementById("button")

button1.addEventListener('click',function() {
  console.log(text1.value)
  // text1.value = "이렇게 하면 값을 넣어준다"
})
*/

/*
const form1 = document.querySelector("form")

form1.addEventListener('submit',function(e) {
  // 기존의 기능을 차단한다. 
  // 리다이렉션되는 기능을 차단해버리고, 내가 사용하고 싶은 기능을 채워넣어서 새로운 이벤트 핸들링을 하겠다는 의미이다.
  e.preventDefault() 

  console.log(form1.name.value)
  console.log(form1.town.value)
})
*/


//22//삼항연산/////////////////////////////////////////////////////////////////////////////////////////

/*
let result;
result = 3 < 2 ? "true" : "false"
console.log(result)
*/
