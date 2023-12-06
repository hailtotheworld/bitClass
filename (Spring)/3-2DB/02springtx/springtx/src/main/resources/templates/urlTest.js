

// const searchParams = new URL(location.href).searchParams;


const searchParams = new URLSearchParams(location.search); //?type=post&returnURL=hailto

let value = searchParams.get('type');

console.log(value); //post

/*
eg)
https://hailtotheworld.tistory.com/manage/newpost/69?type=post&returnURL=hailto
post

*/
