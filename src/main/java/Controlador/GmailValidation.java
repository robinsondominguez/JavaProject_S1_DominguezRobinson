package Controlador;

import java.util.regex.Pattern;

public class GmailValidation {

    private static final Pattern EMAIL_REGEX
            = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static boolean correoValido(String correo) {
        return correo != null && EMAIL_REGEX.matcher(correo).matches();
    }
}
