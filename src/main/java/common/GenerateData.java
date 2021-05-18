package common;

import java.util.Random;

public class GenerateData {

	String username = "";
	String email = "";

	// Generation inspired by code from
	// https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	public String generateUsername() {

		Random r = new Random();
		int low = 1;
		int high = 1000;
		int result = r.nextInt(high - low) + low;
		username = "Testtestar" + result;

		return username;
	}

	public String generateEmail() {

		Random r = new Random();
		int low = 1;
		int high = 1000;
		int result = r.nextInt(high - low) + low;
		email = "Testtestar" + result + "@testtestson.com";

		return email;
	}

}
