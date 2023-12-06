let str = "Hello World";

str.indexOf('Hello'); // 반환값 0

str.indexOf('Bye'); // 반환값 -1


str = "Hello World";

if(str.indexOf('Bye') == -1) // 'Bye'라는 문자가 없을때
{
  // do something
}