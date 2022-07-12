//1// .classList //////////////////////////////////////////////////////////////

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


