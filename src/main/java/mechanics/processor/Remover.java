package mechanics.processor;

import utillities.Checker;

import java.util.Set;

class Remover {

    private Set<Car> carSet;

    Remover(Set<Car> carSet) {
        this.carSet = carSet;
    }

    void removeByVin(final String vin) {
        carSet.removeIf(v -> v.getVinCode().equals(vin));
    }

    void removeByReg(final String reg) {
        carSet.removeIf(v -> v.getRegNumber().equals(reg));
    }

    void removeByModel(final String model) {
        carSet.removeIf(v -> v.getModel().equals(model));
    }

    void removeByPrice(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carSet.removeIf(v -> v.getPrice() >= from && v.getPrice() <= to);
    }

    void removeByPath(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carSet.removeIf(v -> v.getPath() >= from && v.getPath() <= to);
    }

    void removeByYear(final int from, final int to) {
        if (Checker.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        carSet.removeIf(v -> v.getYear() >= from && v.getYear() <= to);
    }
}
