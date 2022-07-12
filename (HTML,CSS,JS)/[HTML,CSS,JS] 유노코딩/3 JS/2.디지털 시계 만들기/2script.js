//1// 생성자//////////////////////////////////////////////////////////////////////////////////
/*
function Dog(paraName,paraBreed) {
  this.name = paraName
  this.breed = paraBreed
}

// 생성자함수는 new를 통해서 객체를 생성하는데 목적을 두고 만든 함수이다.
const dog1 = new Dog("초코","푸들")
const dog2 = new Dog("방울이","말티즈")
const dog3 = new Dog("순디","진돗개")
console.log(dog1)
console.log(dog2)
console.log(dog3)
*/

//2// new Date() /////////////////////////////////////////////////////////////////////////////
const now = new Date();
console.log(now)

const h1 = document.querySelector('h1')

const hour = now.getHours()
const min = now.getMinutes()
const sec = now.getSeconds()

const nowTime = `${hour}:${min}:${sec}`

h1.textContent = nowTime;

// const then = new Date(2022,9,29) // 월은 0부터시작한다.
// console.log(then)

console.log(now.toLocaleString())
console.log(now.toLocaleString('en'))