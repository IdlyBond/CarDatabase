import gui.Lines;
import gui.Menu;
import mechanics.processor.CarDatabase;

public class Main {

    public static void main(String[] args) {
        CarDatabase carDatabase = new CarDatabase();
        carDatabase.add(Lines.DEFAULT_VIN_1.getLine(), Lines.DEFAULT_REG_NUM_1.getLine(), Lines.DEFAULT_MODEL_1.getLine(), 500, 2000, 1000);
        carDatabase.add(Lines.DEFAULT_VIN_2.getLine(), Lines.DEFAULT_REG_NUM_2.getLine(), Lines.DEFAULT_MODEL_2.getLine(), 600, 2006, 1300);
        carDatabase.add(Lines.DEFAULT_VIN_3.getLine(), Lines.DEFAULT_REG_NUM_3.getLine(), Lines.DEFAULT_MODEL_3.getLine(), 1500, 1995, 500);
        carDatabase.add(Lines.DEFAULT_VIN_4.getLine(), Lines.DEFAULT_REG_NUM_4.getLine(), Lines.DEFAULT_MODEL_4.getLine(), 50, 2019, 3000);
        Menu menu = new Menu(carDatabase);
        menu.mainMenu();

    }

}
