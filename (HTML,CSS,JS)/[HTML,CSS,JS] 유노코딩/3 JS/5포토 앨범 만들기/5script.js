// 이 url은 서버주소이고, 이 서버에 요청을 보내면 JSON형태로 이미지를 전달해준다.
const url = 'https://dog.ceo/api/breeds/image/random'


// 1. XMLHttpRequest 객체생성
const request = new XMLHttpRequest()


// 2. 서버와 통신할 때 필요한 정보 및 처리 방법 등을 기입한다.
request.addEventListener("load", function(){
  console.log(JSON.parse(request.responseText)) // 자기에게 전달된 응답데이터를 의미한다.
  
  const obj = JSON.parse(request.responseText)
  const imageSrc = obj.message

  const div = document.querySelector('div')
  div.style.backgroundImage = `url(${imageSrc})`
})

request.addEventListener('error',() => alert("뭔가 문제가 있다..!"))


// 3. 요청을 전송해 통신을 시작한다.
// 서버에 요청을 보낼 때는 XMLHttpRequest 객체의 open메소드로 요청을 초기화하고
// 이후 send메소드로 보내주는 순서가 일반적이다.
const button = document.querySelector("button")
button.addEventListener('click',function(){
  request.open("GET",url) // get방식으로 이 url에 요청을 보내야지 (초기화한다)
  request.send()
})
