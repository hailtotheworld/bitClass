let arr = ["마우스", "키보드", "수신기"];

for (const element of arr) {
    console.log(element); // 마우스, 키보드, 수신기
}

for (const index in arr) {
    console.log(index) // 1, 2, 3
}

for(let i = 0; i < arr.length; i++) {
    // i는 한번 선언이 되고, 활용을 해서 값을 변경을 하면서 index를 추적하기 때문에 let으로 선언을 해줘야한다.
}

const str = "The quick brown fox jumps over the lazy dog";
const words = str.split(' ');
console.log(words[3]);  // Expected output: "fox"

const word = "12:34";
console.log(word.split(":")[0]); // 12