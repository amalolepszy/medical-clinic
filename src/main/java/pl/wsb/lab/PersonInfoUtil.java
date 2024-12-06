package pl.wsb.lab;

public final class PersonInfoUtil {
    // private constructor - klasa util nie będzie instancjowana; przechowuje metody
    // statyczne
    private PersonInfoUtil() {
    }

    // Sprawdzenie długości PESEL
    public static boolean isValidPesel(String pesel) {
        return pesel.length() == 11 && pesel.matches("[0-9]+");
    }

    // Sprawdzenie długości numeru telefonu
    public static boolean isValidPhone(String phone) {
        return phone.length() == 9 && phone.matches("[0-9]+");
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
