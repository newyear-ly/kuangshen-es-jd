package pub.newyear.kuangshenesjd.utils;

import javafx.util.Pair;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputHandlerUtil {

    public static Map<String,String> resolve(String input){
        Map<String,String> map = Stream.of(input)
                .map(lines -> lines.split("\n"))
                .flatMap(Arrays::stream)
                .map(kv -> {
                    String[] kvs = kv.split("(?!^):");
                    return new Pair<String,String>(kvs[0].trim(),kvs[1].trim());
                }).collect(Collectors.toMap(Pair::getKey,Pair::getValue));
        return map;
    }
}
