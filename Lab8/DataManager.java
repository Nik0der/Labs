package Lab8;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        data = List.of(source.split(" "));
        System.out.println("Данные загружены: " + data);
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executorService.submit(() -> {
                        try {

                            data = (List<String>) method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Данные обработаны: " + data);
    }

    public void saveData(String destination) {
        System.out.println("Сохранение данных в: " + destination);
        System.out.println("Итоговые данные: " + data);
    }
}