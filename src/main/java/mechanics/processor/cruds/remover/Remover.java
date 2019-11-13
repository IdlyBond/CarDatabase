package mechanics.processor.cruds.remover;

import mechanics.exceptions.CarNotFoundException;

public interface Remover {

    void removeByVin(final String vin) throws CarNotFoundException;
    void removeByReg(final String reg) throws CarNotFoundException;
    void removeByModel(final String model) throws CarNotFoundException;
    void removeByPrice(final int from, final int to) throws CarNotFoundException;
    void removeByPath(final int from, final int to) throws CarNotFoundException;
    void removeByYear(final int from, final int to) throws CarNotFoundException;
    void removeAll() throws CarNotFoundException;

}
