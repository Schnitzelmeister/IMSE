package imse.SS2017.team1.filter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class CreditCardValidator {

	public boolean isCreditCardNumber(String cardnumber) {
		return Pattern.matches("([0-9]{4}[-]{1}){3}[0-9]{4}", cardnumber);

	}

	public boolean isName(String name) {
		return Pattern.matches("[a-zA-Zöü]{3,25}", name);
	}

	public boolean isCvv(String cvv) {
		return Pattern.matches("[0-9]{3}", cvv);
	}

	public boolean isMonth(String monat) {
		return Pattern.matches("[1-9]|0[1-9]|1[012]", monat);
	}

	public boolean isYear(String jahr) {

		return Pattern.matches("(2[0-9]{3})", jahr);
	}

	public boolean isValidCreditCard(String month, String year) {
		if (this.isMonth(month) && this.isYear(year)) {
			// Initialize your Date however you like it.
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int jahr = calendar.get(Calendar.YEAR);
			// Add one to month {0 - 11}
			int monat = calendar.get(Calendar.MONTH) + 1;
			if ((Integer.parseInt(year)) > jahr) {

				return true;
			} else if (Integer.parseInt(year) == jahr && Integer.parseInt(month) >= monat) {
				return true;
			}
		}
		return false;
	}

}
