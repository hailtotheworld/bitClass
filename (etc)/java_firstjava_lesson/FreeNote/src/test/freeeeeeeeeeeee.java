package test;

import java.util.Scanner;

public class freeeeeeeeeeeee {
	public static void main(String args[]) {
		String[] words = { "television", "computer", "mouse", "phone" };
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			char[] ch = words[i].toCharArray(); // String char[] 을 로 변환
			
			///////////////////////////////////////////////////////////////
			for(int j=0;j<ch.length;j++) {
				int ran = (int) (Math.random()*ch.length);
				
				char temp = ch[j];
				ch[j] = ch[ran];
				ch[ran] = temp;
				
				
			}

			
			///////////////////////////////////////////////////////////////

			System.out.printf("Q%d. %s 의 정답을 입력하세요.>", i + 1, new String(ch));
			String answer = scanner.nextLine();
			// trim() answer , equals word[i] 으로 의 좌우 공백을 제거한 후 로 와 비교
			if (words[i].equals(answer.trim()))
				System.out.printf("맞았습니다.%n%n");
			else
				System.out.printf("틀렸습니다.%n%n");
		}
	} // main의 끝
}
