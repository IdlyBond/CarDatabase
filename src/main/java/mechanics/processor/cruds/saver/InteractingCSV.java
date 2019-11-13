package mechanics.processor.cruds.saver;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import gui.Lines;
import mechanics.processor.cars.Car;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class InteractingCSV<T> implements FileInteractive<T> {

    private Path path = Paths.get("database");
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void save(Collection<T> items) throws IOException {
        Files.deleteIfExists(path);
        for (T item : items) {
            mapper.writeValue(new FileOutputStream(path.toFile(), true), item);
        }
    }

    @Override
    public void save(Collection<T> items, Path path) throws IOException {

    }

    @Override
    public void read(Collection<T> into, Class<T> clazz) throws IOException {
        if (Objects.isNull(into)) throw new NullPointerException("Collection is NULL");
        if (Files.exists(path)) {
            ObjectMapper mapper = new ObjectMapper();
            MappingIterator<T> iter = mapper.readValues(new JsonFactory().createParser(path.toFile()), clazz);
            while (iter.hasNext()) {
                into.add(iter.next());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileInteractive<Car> fileInteractive = new InteractingCSV<Car>();
        Collection<Car> cars = new HashSet<>();
        //cars.add(new Car(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine(), Lines.DEFAULT_MODEL_1.getLine(), 500, 2000, 1000));
        //cars.add(new Car(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine(), Lines.DEFAULT_MODEL_2.getLine(), 600, 2006, 1300));
        //cars.add(new Car(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine(), Lines.DEFAULT_MODEL_3.getLine(), 1500, 1995, 500));
        //cars.add(new Car(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine(), Lines.DEFAULT_MODEL_4.getLine(), 50, 2019, 3000));
        //fileInteractive.save(cars);
        fileInteractive.read(cars, Car.class);
        System.out.println(cars);
    }
}
