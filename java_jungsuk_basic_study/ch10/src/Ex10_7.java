import java.text.*;

class Ex10_7 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");

		try {
			Number num = df.parse("1,234,567.89");
			System.out.print("1,234,567.89" + " -> ");

			double d = num.doubleValue();
			System.out.print(d + " -> ");

			System.out.println(df2.format(num));
		} catch (Exception e) {
		}
		
		
		double dd = 5478650.57;
		
		DecimalFormat ft = new DecimalFormat("#,###.00");
		
		System.out.println(ft.format(dd));
	} // main
}