//1// .classList //////////////////////////////////////////////////////////////
/*
const h1 = document.querySelector('h1')
const addBtn = document.getElementById('add')
const removeBtn = document.getElementById('remove')
const toggleBtn = document.getElementById('toggle')

console.log(h1.classList)

addBtn.addEventListener('click',function(){
  h1.classList.add('text')
})

removeBtn.addEventListener('click',function(){
  h1.classList.remove('text')
})

toggleBtn.addEventListener('click',function(){
  h1.classList.toggle('text')
})
*/


//2 배열//////////////////////////////////////////////////////////////////

/*
const odd = [1,3,5,7,9]
const even = new Array(2,4,6,8,10)

console.log(odd)
console.log(even)
*/
 
/*
const num = ["영","일","이","삼","사"]
console.log(num)

let ind = 2;
console.log(num[ind])

num[ind] = "둘둘22"
console.log(num[ind])
*/

//3 배열 메소드/////////////////////////////////////////////////////

/*
const pet = ["강아지","고양이","앵무새"]
console.log(pet.length)

console.log(pet)
pet.push("햄스터","거북이")
console.log(pet)

pet.pop()
console.log(pet)
*/

/*
const pet = ["강아지","고양이","앵무새"]
console.log(pet.indexOf("앵무새"))
console.log(pet.indexOf("없으면-1"))
*/

/*
const pet = ["강아지","고양이","앵무새"]
console.log(pet)
// pet.splice(1) //index1부터다지워
// pet.splice(1,2) //1번째부터 2개지워
// pet.splice(1,1,"다람쥐") //1번째부터 1개지워. 대체데이터넣어
console.log(pet)
*/

/*
const pet = ["강아지","고양이","앵무새"]
console.log(pet)

pet.forEach(function(){
  console.log("매개변수가 없으면 배열요소 수만큼 호출된다")
})

pet.forEach(function(param){
  console.log(param)
})
*/

//4 Math /////////////////////////////////////////////////////////////////

console.log(Math.random())  // 0<=x<1
console.log(Math.random()*45+1)
console.log(Math.floor(Math.random()*45+1))

let arr = [];

for(let i=0;i<6;i++) {
  arr[i] = Math.floor(Math.random()*45+1)
}

console.log(arr)
