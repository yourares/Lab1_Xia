import java.util.Scanner;

public class Income {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Years Retired:");
		double n = input.nextDouble();

		System.out.print("Annual return in investment:");
		double r = input.nextDouble();

		while (r < 0 || r > 3) {
			System.out.print("Invalid value. Use a number between 0 and 3.");
			r = input.nextDouble();
		}

		System.out.print("Required Income:");
		double C = input.nextDouble();

		System.out.print("Monthly SSI:");
		double d = input.nextDouble();

		double amountNeeded = PresentValue(n, r, C, d);
		System.out.println("The total amount you need is: $" + amountNeeded);
		
		
		System.out.print("Years to work:");
		double n2 = input.nextDouble();

		System.out.print("Annual Return in Payback:");
		double r2 = input.nextDouble();

		while (r2 < 0 || r2 > 20) {
			System.out.print("Invalid value. Use a number between 0 and 20.");
			r2 = input.nextDouble();
		}
		double amountSaved = SavedValue(n2,r2,amountNeeded);
		System.out.println("The amount you have to saved per month is: $" + amountSaved);
		
	}

private static double PresentValue(double n,double r, double C, double d){
	double m = (C-d)*((1-(1/Math.pow((1+(r/1200)),(n*12)))))/(r/1200);
	return m;
	}
private static double SavedValue(double n2, double r2, double m) {
	double S = m*(r2/1200)/((Math.pow(1+(r2/1200),n2*12))-1);
	return S;
	}
}