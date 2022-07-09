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

let test = 314
console.log(typeof "st")
