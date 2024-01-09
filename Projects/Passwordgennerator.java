//import java.util.Random;
import java.util.*;

public class Passwordgennerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of password: ");
        int passLength = sc.nextInt();

        System.out.println("Include Uppercase letter? (YES/NO): ");
        boolean upperCase = sc.next().equalsIgnoreCase("YES");

        System.out.println("Include lowercase letter? (YES/NO): ");
        boolean lowerCase = sc.next().equalsIgnoreCase("YES");

        System.out.println("Include number? (YES/NO): ");
        boolean includeNumber = sc.next().equalsIgnoreCase("YES");

        System.out.println("Include special character? (YES/NO): ");
        boolean includeSpecial = sc.next().equalsIgnoreCase("YES");

        String generatedPassword = generatePassword(passLength, upperCase, lowerCase, includeNumber, includeSpecial);
        System.out.println("Generated Password: " + generatedPassword);
    }

    private static String generatePassword(int passLength, boolean upperCase, boolean lowerCase, boolean includeNumber,
            boolean includeSpecial) {
        StringBuilder password = new StringBuilder();
        Random rm = new Random();

        if (!(upperCase || lowerCase || includeNumber || includeSpecial)) {
            System.out.println("Error: Please include at least one character type (uppercase, lowercase, numbers, or special characters).");
            return ""; 
        }

        while (password.length() < passLength) {
            if (upperCase) {
                password.append((char) (rm.nextInt(26) + 'A'));
            }
            if (lowerCase) {
                password.append((char) (rm.nextInt(26) + 'a'));
            }
            if (includeNumber) {
                password.append((char) (rm.nextInt(10) + '0'));
            }
            if (includeSpecial) {
                
                String specialCharsString = "!@#$%^&*()_+-=[]{}|;':,.<>?";
                password.append(specialCharsString.charAt(rm.nextInt(specialCharsString.length())));
            }
        }

        
        return password.substring(0, Math.min(password.length(), passLength));
    }
}
