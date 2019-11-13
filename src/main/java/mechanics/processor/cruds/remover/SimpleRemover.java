package mechanics.processor.cruds.remover;

import mechanics.exceptions.CarNotFoundException;
import mechanics.processor.cars.Car;
import utils.CarUtils;

import java.util.Collection;

public class SimpleRemover implements Remover {

    private Collection<Car> cars;

    public SimpleRemover(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void removeByVin(final String vin) throws CarNotFoundException {
        if (!cars.removeIf(v -> v.getVinCode().equals(vin))) throw new CarNotFoundException("No cars with vin " + vin);
    }

    @Override
    public void removeByReg(final String reg) throws CarNotFoundException{
        if(!cars.removeIf(v -> v.getRegNumber().equals(reg))) throw new CarNotFoundException("No cars with reg " + reg);
    }

    @Override
    public void removeByModel(final String model) throws CarNotFoundException{
        if(!cars.removeIf(v -> v.getModel().equals(model))) throw new CarNotFoundException("No cars with model " + model);
    }

    @Override
    public void removeByPrice(final int from, final int to) throws CarNotFoundException{
        if (CarUtils.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        if (!cars.removeIf(v -> v.getPrice() >= from && v.getPrice() <= to)) throw new CarNotFoundException("No cars with price From " + from + " To " + to);
    }

    @Override
    public void removeByPath(final int from, final int to) throws CarNotFoundException{
        if (CarUtils.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        if(!cars.removeIf(v -> v.getPath() >= from && v.getPath() <= to)) throw new CarNotFoundException("No cars with path From " + from + " To " + to);
    }

    @Override
    public void removeByYear(final int from, final int to) throws CarNotFoundException{
        if (CarUtils.isLess(from, to)) throw new IllegalArgumentException(from + " < " + to);
        if(!cars.removeIf(v -> v.getYear() >= from && v.getYear() <= to)) throw new CarNotFoundException("No cars with year From " + from + " To " + to);
    }

    @Override
    public void removeAll() {
        cars.clear();
    }
}
