import mechanics.exceptions.CarNotFoundException;
import mechanics.facade.CarDatabase;
import mechanics.facade.Database;
import mechanics.processor.cars.Car;
import mechanics.processor.CarCRUD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

public class CoreTest {

    private CarCRUD cars;
    @Before
    public void initCar(){
        cars = CarCRUD.getInstance();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test_set_vin_null_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Vin: null");
        cars.insert(null, "AA0000AA", "Camry", 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_reg_null_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Reg: null");
        cars.insert("5CBU54ZTH63482647", null, "Camry", 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_model_spaces_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Model:    ");
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "   ", 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_vin_wrong_length_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Vin: 5CBU54ZTH6348264");
        cars.insert("5CBU54ZTH6348264", "AA0000AA", "Camry", 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_reg_wrong_length_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Reg: AB78979AA");
        cars.insert("5CBU54ZTH63482647", "AB78979AA", "Camry", 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_model_null_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Model: null");
        cars.insert("5CBU54ZTH63482647", "AA0000AA", null, 0, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_path_negative_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Path: -1");
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", -1, LocalDate.now().getYear(), 0);
    }

    @Test
    public void test_set_price_negative_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Price: -1");
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", 0, LocalDate.now().getYear(), -1);
    }

    @Test
    public void test_set_year_wrong_left_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Year: 1899");
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", 0, 1899, 0);
    }

    @Test
    public void test_set_year_wrong_right_exception(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal Year: " + (LocalDate.now().getYear() + 1));
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", 0, LocalDate.now().getYear() + 1, 0);
    }

    @Test
    public void test_correct_add_to_database(){
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", 100, LocalDate.now().getYear(), 1000);
        Assert.assertFalse(cars.isEmpty());
        Database database = CarDatabase.getInstance();
    }

    @Test
    public void test_car_toString(){
        cars.insert("5CBU54ZTH63482647", "AA0000AA", "Camry", 100, LocalDate.now().getYear(), 1000);
        try {
            Car car = cars.selectByVin("5CBU54ZTH63482647").iterator().next();
            Assert.assertEquals(car.toString(), "VIN: " + car.getVinCode() + '\n' +
                    "REG: " + car.getRegNumber() + '\n' +
                    "Model: " + car.getModel() + '\n' +
                    "Path: " + car.getPath() + '\n' +
                    "Year: " + car.getYear() + '\n' +
                    "Price: " + car.getPrice() + '\n');
        } catch (CarNotFoundException e) {
            System.out.println("mechanics.processor.cars.Car didn't set. Check tests for mechanics.processor.cars.Car setters");
        }
    }


}
