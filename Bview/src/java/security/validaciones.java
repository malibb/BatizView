package security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validaciones {

    public boolean isEmpty(String cadena) {

        String trim = cadena.trim();
        return trim.isEmpty();

    }

    public boolean isNumericN(String cadena, String numero) {

        return cadena.matches("([0-9]{"+ numero +"})+");

    }

    public boolean isNumericP(String cadena) {

        return cadena.matches("^[-]?[0-9]+[.]?[0-9]*$");
    }

    public boolean isString(String cadena) {

        String trim = cadena.trim();
        return trim.matches("([a-z]|[A-Z]|[ÁáÉéÍíÓóÚúÜüÑñ]|\\s){1,}+");

    }

    public boolean isEmail(String email) {

        return email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4}){1,}$");

    }

    public boolean isCode(String code) {

        return code.matches("^([A-Fa-f0-9]{12})$");

    }

    public boolean isOption(String option) {

        return option.matches("^[1-5]{1}");

    }

    public boolean isPassword(String pass, String nombre) {

        boolean contain = pass.matches("(?=^.{8,}$)(?=.*\\d)(?=.*\\W+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
        if (contain == true) {
            contain = pass.contains(nombre) ? false : true;
        }

        return contain;
    }

    public boolean isPassword(String pass) {

        return pass.matches("(?=^.{8,}$)(?=.*\\d)(?=.*\\W+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]){8,}.*$");

    }

    public boolean isId(String boleta) {

        return boleta.matches("20((0[0-9])|(1[0-5]))09\\d{4}");

    }

    public boolean isPath(String path) {

        return path.matches("^[a-z]+[:]?((\\\\|\\/)[a-z0-9\\s_@\\-^!#$%&+={}\\[\\]]+)+\\.[a-z]{3,}$");

    }

    public boolean isHour(int hour) {
        boolean result = false;

        if (hour > 6 && hour < 21) {
            result = true;
        }

        return result;
    }

}
