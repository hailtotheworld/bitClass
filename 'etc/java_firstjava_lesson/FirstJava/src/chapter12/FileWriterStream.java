package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterStream {
	public static void main(String[] args) throws IOException {
		
		Writer writer = new FileWriter("hyper.txt"); // FileWriter(String) // FileWriter(file은 경로야,)
		// FileWriter 눌러서 예외 추가해줘.
		
		
		writer.write('A');
		writer.write('b');
		writer.write("Z");
		
		writer.close();
		System.out.println("문자 쓰기 완료");
		
		
	}

}
