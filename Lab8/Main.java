package Lab8;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new DataFilter());
        dataManager.registerDataProcessor(new DataTransformer());

        dataManager.loadData("hello world this is a simple test");

        dataManager.processData();

        dataManager.saveData("output.txt");
    }
}