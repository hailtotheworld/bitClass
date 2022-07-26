//1 객체리터럴로 객체만들기//////////////////////////////////////////////////////////////////////////////////////////

/*
const cat = {
  name: 'tom',
  color: 'gray', // key는 중복될 수 없다.
  color: 'white',
  eat: function(){
    console.log("맛있다.")
  }
}

console.log(cat['name']) // ['대괄호']로 호출할때는 대괄호 안에 ''를 넣어서 key를 문자열 취급 해야한다.
console.log(cat.color)
cat.eat()

// 값 쓰기
cat.name = "도라에몽"
console.log(cat.name)
*/


//2 스프레드 연산자//////////////////////////////////////////////////////////////////////////////////////////

/*
const animal = ['호랑이','코끼리','다람쥐']
console.log(animal) // 배열형태로 나온다
console.log(...animal) // 값으로 나오네. 아래랑 같은 형태야
console.log('호랑이','코끼리','다람쥐')

const animalPlus = ['너구리',...animal]
console.log(animalPlus)

function printNames(param1,param2,param3) {
  console.log(`제가 키우는 동물은 ${param1},${param2},${param3}입니다`)
}

printNames(...animal)
*/

/*
const person = {
  name: '김봉두',
  job: '이것저것',
  eat: function() {
    console.log('먹는다 냠냠')
  }
}

const teacher = {
  ...person,
  name: '박가르',
  teaching: function() {
    console.log('가르친다')
  }
}

console.log(person)
console.log(teacher)

// console.log(...person) // 객체리터럴 {} 안의 내용이 그대로 복사되기 때문에 문법적으로 맞지가 않으니까 에러가 난다. 
*/


//3 JSON//////////////////////////////////////////////////////////////////////////////////////////
/*
const messi = {
  name : '메시',
  'age' : 34,
  team: "파리",
  'nation' : "아르헨티나",
  friends: ["고양이", "강아지", "도마뱀" ],
  kick: function() {
    console.log("슛~")
  }
}

console.log(messi)
console.log(JSON.stringify(messi)) //함수를 무시한다.

console.log(JSON.parse(JSON.stringify(messi)))
*/

//4 로컬스토리지//////////////////////////////////////////////////////////////////////////////////////////

// 애플리케이션-로컬스토리지
/*
const myDog = "초코"
console.log(myDog)

localStorage.setItem("키값",myDog)
localStorage.setItem("키값이야","갱얼쥐")

// localStorage.clear()

const dogg = localStorage.getItem("키값이야")
console.log(dogg)

localStorage.removeItem("키값")
*/

//5 배열 메소드//////////////////////////////////////////////////////////////////////////////////////////

const twice = ["사나", "지효", "다현", "나연"]

twice.forEach(member => console.log(member))
console.log(" ")
twice.forEach(function(member, index){
  console.log(`${index +1 }번째 멤버 ${member}입니다`)
})
twice.forEach(function(member, index){
  const p = document.createElement('p')
  p.textContent = `${index+1}번째 멤버는 ${member}입니다`
  document.body.appendChild(p)
})


const editTwice = twice.map(function(member,index){
  return `아름다운 ${member}`
})
console.log(editTwice)


const num = [1,2,3,4,5,6]
const editNum = num.filter(n => n%2==0)
console.log(editNum)