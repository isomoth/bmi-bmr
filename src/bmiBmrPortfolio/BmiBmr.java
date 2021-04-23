package bmiBmrPortfolio;
import java.util.Scanner;


public class BmiBmr {

	// Calculate a person's BMI and BMR based on their gender, weight and height.
	// Height values allowed: 50cm - 220cm
	// Weight values allowed: 10kg - 300kg 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);


		while (true) {

			System.out.println("Gender: ");
			String gender = input.next();
			System.out.println("Age: ");
			int age = input.nextInt();
			System.out.println("Height (cm): ");
			float height = input.nextFloat();
			System.out.println("Weight (kg): ");
			float weight = input.nextFloat();

			float bmi = bmi(height, weight);
			float bmr = bmr(gender, age, height, weight);

			// Verify if the input is within coherent values

			if (height <= 50 || height >= 220 || weight <= 10 || weight >= 300) {

				System.out.println("Input out of limits. Try again.");
				break;

			}

			else 

				System.out.println("Bmi = " + bmi);
			System.out.println("Bmr = " + bmr);

			System.out.println("Measure again? (y/n)");
			String svar = input.next();
			if (((svar.equals("n")) || (svar.equals("N")))){
				System.out.println("Välkommen tillbaka!");
				break;
			}

		}

		input.close();

	}

	static float bmi (double height, double weight) {

		// Formula to calculate the BMI: 1.3*weight(kg)/height(m)^2.5

		float bmi= (float) ((1.3 * weight)/(Math.pow((height/100), 2.5)));

		return bmi;

	}

	static float bmr (String gender, int age, double height, double weight) {
		
		// Formula to calculate the BMR for women: (9.99 * kg) + (6.25 * cm) - (4.92 * age) - 161
		// For men: (9.99 * kg) + (6.25 * cm) - (4.92 * age) + 5

		float bmr;

		if (gender.equals("kvinna") || gender.equals("Kvinna")) {

			bmr = (float) ((9.99 * weight) + (6.25 * height) - (4.92 * age) - 161);

		}

		else {

			bmr = (float) ((9.99 * weight) + (6.25 * height) - (4.92 * age) + 5);

		}

		return bmr;


	}
}

