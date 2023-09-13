import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int fromYear = 2010;
        int toYear = 2015;

        printBonusDatesBetween(fromYear, toYear);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        // Sets format for dates.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {

                // Checks how mane days are in a month. Checks is it 28, 29, 30 or 31.
                int daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth();

                for (int day = 1; day <= daysInMonth; day++) {
                    // Creates date and formats it then reverses it.
                    LocalDate date = LocalDate.of(year, month, day);
                    String original = date.format(formatter);
                    String reversed = new StringBuilder(original).reverse().toString();

                    // Removes '-' symbol from string to compare them.
                    String copyOriginal = original.replace("-", "");
                    String copyReversed = reversed.replace("-", "");

                    // Compares two numbers and prints date that is the same reversed.
                    if (copyOriginal.equals(copyReversed)) {
                        System.out.println(original);
                    }
                }
            }
        }
    }
}
