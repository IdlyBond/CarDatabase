package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CarUtils {

    public static <T> boolean collectionIsEmpty(Collection<T> collection) {
        ArrayList<T> list = new ArrayList<>(collection);
        list.trimToSize();
        return list.isEmpty();
    }

    public static boolean lineIsExists(String line) {
        return Objects.nonNull(line) && line.length() != 0 && line.replaceAll("\\s", "").length() != 0;
    }

    public static boolean checkVinCode(String vin) {
        return Objects.nonNull(vin) && vin.trim().length() == 17 && vin.trim().matches("^[0-9A-Z]{11}[0-9]{6}$");
    }

    public static boolean checkYear(int year) {
        return (year >= 1900 && year <= LocalDate.now().getYear());
    }

    public static boolean checkRegNumber(String reg) {
        return Objects.nonNull(reg) && reg.trim().length() == 8 && reg.trim().matches("^[A-C][A-Z]\\d{4}[A-C][A-Z]$");
    }

    public static boolean checkModel(String model) {
        return Objects.nonNull(model) && model.trim().length() != 0;
    }

    public static boolean checkPrice(int num) {
        return num >= 0;
    }

    public static boolean checkPath(int num) {
        return num >= 0;
    }

    public static boolean checkFullName(String fio) {
        return Objects.nonNull(fio) && fio.trim().length() != 0 && fio.trim().matches("^[A-Z][a-z]+\\s[A-Z][a-z]+\\s[A-Z][a-z]+$|^[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+$");
    }

    public static boolean lineIsZero(String line) {
        return Objects.nonNull(line) && line.trim().length() == 1 && line.trim().equals("0");
    }

    public static boolean isLess(int less, int more) {
        return less > more;
    }
}
