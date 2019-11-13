import gui.Lines;
import gui.Menu;
import mechanics.processor.CarCRUD;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(new FileInputStream("logging/config"));
        CarCRUD carCRUD = CarCRUD.getInstance();
        carCRUD.insert(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine(), Lines.DEFAULT_MODEL_1.getLine(), 500, 2000, 1000);
        carCRUD.insert(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine(), Lines.DEFAULT_MODEL_2.getLine(), 600, 2006, 1300);
        carCRUD.insert(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine(), Lines.DEFAULT_MODEL_3.getLine(), 1500, 1995, 500);
        carCRUD.insert(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine(), Lines.DEFAULT_MODEL_4.getLine(), 50, 2019, 3000);
        Menu menu = new Menu();
        menu.mainMenu();

    }

}
