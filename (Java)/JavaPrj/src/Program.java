public class Program {
	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

		total = kor1 + kor2 + kor3;

		avg = (float) total / 3;

		System.out.printf("total: %d%n", total);
		System.out.printf("avg: %.2f", avg);

	}

}