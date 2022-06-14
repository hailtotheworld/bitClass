package ch14_2_Stream;


import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class mapFlatmap {
	public static void main(String[] args) {

		File[] farr = {new File("123.txt"),new File("4123.txt"),new File("1723.txt")};
		
		Stream<File> fs = Arrays.stream(farr);
		
		fs.map((File f)->f.getName())
		  .forEach(System.out::println);
		
		////////////////////////////////////////////////////////////////////////////////
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try"
			};
		
		Stream<String> ls = Stream.of(lineArr);
		
		ls.flatMap( (String s) -> Stream.of(s.split(" ")))
//		  .map((String s)->s.split(" "))
		  .forEach(System.out::println);
		
		
		
		
	}

}
