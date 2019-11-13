package mechanics.processor.cruds.creator;

public interface Creator {
    void insert(String vinCode, String regNumber, String model, int path, int year, int price);
}
