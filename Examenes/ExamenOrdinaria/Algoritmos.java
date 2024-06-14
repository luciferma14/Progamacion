package ExamenOrdinaria;


//////////////////////////////////
// SI ME TOCAS QUEDAS DESPEDIDO //
//////////////////////////////////
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algoritmos {

    // Validar NIF
    public static boolean validarNIF(String nif) {

        final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
        final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

        return Arrays.binarySearch(INVALIDOS, nif) < 0 // (1)
                && REGEXP.matcher(nif).matches() // (2)
                && nif.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(nif.substring(0, 8)) % 23); // (3)
    }

    // Validar CCC
    public static Boolean validarCCC(String cuenta) {
        Pattern cuentaPattern = Pattern.compile("\\d{20}");
        Matcher m = cuentaPattern.matcher(cuenta);
        if (m.matches()) {
            // cuenta cumple el patrón (20 dígitos)
            String banco = cuenta.substring(0, 4);
            String sucursal = cuenta.substring(4, 8);
            String dC = cuenta.substring(8, 10);
            String CCC = cuenta.substring(10, 20);
            if (!(obtenerDigito("00" + banco + sucursal) == Integer.parseInt(String.valueOf(dC.charAt(0))))
                    || !(obtenerDigito(CCC) == Integer.parseInt(String.valueOf(dC.charAt(1)))))
                return false;
            else
                return true;
        }
        return false;

    }

    private static int obtenerDigito(String valor) {
        Integer[] valores = new Integer[] { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };

        Integer control = 0;
        for (int i = 0; i <= 9; i++)
            control += Integer.parseInt(String.valueOf(valor.charAt(i))) * valores[i];
        control = 11 - (control % 11);
        if (control == 11)
            control = 0;
        else if (control == 10)
            control = 1;
        return control;

    }

    // Validar Tarjeta

    public static boolean validarTarjeta(String number) {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6))
                &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
    }

    // Get the result from Step 2
    private static int sumOfDoubleEvenPlace(String num) {
        int sum = 0;
        for (int i = getSize(num) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    private static int getDigit(int number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    private static int sumOfOddPlace(String num) {
        int sum = 0;
        for (int i = getSize(num) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for number
    private static boolean prefixMatched(String number, int d) {
        return getPrefix(number, getSize(String.valueOf(d))) == d;
    }

    // Return the number of digits in d
    private static int getSize(String d) {
        return d.length();
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    private static long getPrefix(String num, int k) {
        if (getSize(num) > k) {
            return Long.parseLong(num.substring(0, k));
        }
        return Integer.valueOf(num);

    }

}