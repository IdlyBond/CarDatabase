package mechanics.processor.cruds.saver;


import mechanics.processor.cars.Car;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface FileInteractive<T> {
    void save(Collection<T> item) throws IOException;
    void save(Collection<T> items, Path path) throws IOException;
    void read(Collection<T> into, Class<T> clazz) throws IOException;
}
