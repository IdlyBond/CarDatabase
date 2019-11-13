import mechanics.processor.CarCRUD;
import mechanics.processor.cruds.searcher.Searcher;
import org.junit.Before;

public class SearcherUnit {

    CarCRUD database;
    Searcher searcher;

    @Before
    public void init(){
        database = CarCRUD.getInstance();
    }

}
