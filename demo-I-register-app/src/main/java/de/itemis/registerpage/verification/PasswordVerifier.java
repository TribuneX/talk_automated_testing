package de.itemis.registerpage.verification;

public class PasswordVerifier {

    public static final int MINIMAL_PASSWORD_LENGTH = 8;

    public static boolean verify(String password) {
        return verifyNotNull(password)
                && verifyPasswordLength(password)
                && verifyLowerCaseConstraing(password)
                && verifyUpperCaseConstraint(password)
                && verifyNumberConstraint(password);
    }

    private static boolean verifyUpperCaseConstraint(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean verifyLowerCaseConstraing(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean verifyPasswordLength(String password) {
        return password.length() >= MINIMAL_PASSWORD_LENGTH;
    }

    private static boolean verifyNumberConstraint(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean verifyNotNull(String password) {
        return password != null;
    }

    public static String getVerficationString(String password) {
        if (!verifyNotNull(password)) {
            return "Password can not be null";
        }
        if (!verifyPasswordLength(password)) {
            return mustHaveAtLeastErrorMessage(MINIMAL_PASSWORD_LENGTH+ " characters");
        }
        if (!verifyUpperCaseConstraint(password)) {
            return mustHaveAtLeastErrorMessage("one upper case character");
        }
        if (!verifyLowerCaseConstraing(password)) {
            return mustHaveAtLeastErrorMessage("one lower case character");
        }
        if (!verifyNumberConstraint(password)) {
            return mustHaveAtLeastErrorMessage("one number");
        } else {
            return "Verified";
        }
    }

    private static String mustHaveAtLeastErrorMessage(String reason) {
        return "Password must have at least " + reason;
    }
}
