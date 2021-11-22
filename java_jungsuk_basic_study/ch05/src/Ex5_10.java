import java.util.Scanner;

public class Ex5_10 {
	public static void main(String[] args) {
		

	String[][] words = {
			{"chair","의자"},      	// words[0][0], words[0][1]
			{"computer","컴퓨터"}, 	// words[1][0], words[1][1]
			{"integer","정수"}     	// words[2][0], words[2][1]
		};
	
	Scanner sc = new Scanner(System.in);
	
	for(int i=0;i<words.length;i++) {
		System.out.printf("Q%d.%s의 뜻은?%n",i+1,words[i][0]);
		
		String str = sc.nextLine();
		
		if (str.equals(words[i][1])) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("오답입니다.");
		}
	}

}
}
