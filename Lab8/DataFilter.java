package Lab8;

import java.util.List;
import java.util.stream.Collectors;

public class DataFilter {
    @DataProcessor
    public List<String> filterShortWords(List<String> data) {
        return data.stream()
                .filter(word -> word.length() >= 4)
                .collect(Collectors.toList());
    }
}