//1 객체리터럴로 객체만들기//////////////////////////////////////////////////////////////////////////////////////////

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