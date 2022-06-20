package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterStream {
	public static void main(String[] args) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter("print.txt"));
		
		out.printf("이름은%s입니다. 나이는%d살입니다.", "안녕히", 29);
		out.println();
		
		out.print("날씨가 좋아요");
		out.println("여전하네요.");
		out.close();
		
	}

}
