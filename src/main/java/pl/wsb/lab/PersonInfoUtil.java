package pl.wsb.lab;

public final class PersonInfoUtil {
    // private constructor - klasa util nie będzie instancjowana; przechowuje metody
    // statyczne
    private PersonInfoUtil() {
    }

    // Sprawdzenie długości PESEL
    public static boolean isValidPesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }
        return true;
    }

    // Sprawdzenie długości numeru telefonu
    public static boolean isValidPhone(String phone) {
        if (phone.length() != 9) {
            return false;
        }
        return true;
    }

    // Sprawdzenie adresu email
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.indexOf('.') > email.indexOf('@');
    }

    // Sprawdzenie imienia i nazwiska
    public static boolean isValidName(String name) {
        return name.chars().allMatch(Character::isLetter);
    }
}
