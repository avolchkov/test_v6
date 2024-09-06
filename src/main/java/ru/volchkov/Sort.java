package ru.volchkov;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Sort {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java SortText <input_file> <output_file> <sort_criteria> <word_number>");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        String sortCriteria = args[2];
        int wordNumber = args.length > 3 ? Integer.parseInt(args[3]) : 1;
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            Map<String, Long> mapLines = lines.stream().collect(Collectors.groupingBy(el -> el, Collectors.counting()));
            ArrayList<String> needLines = new ArrayList<>(mapLines.keySet());
            Comparator<String> comparator;
            if (sortCriteria.equals("1")) {
                comparator = String::compareTo;
            } else if (sortCriteria.equals("2")) {
                comparator = Comparator.comparingInt(String::length);
            } else if (sortCriteria.equals("3")) {
                comparator = (line1, line2) -> {
                    String[] words1 = line1.split("\\s+");
                    String[] words2 = line2.split("\\s+");
                    if (words1.length <= wordNumber || words2.length <= wordNumber) {
                        return 0;
                    }
                    return words1[wordNumber - 1].compareTo(words2[wordNumber - 1]);
                };
            } else {
                System.out.println("Не верный критерий сортировки");
                return;
            }
            needLines.sort(comparator);
            List<String> resultLines = needLines.stream()
                    .map(line -> line + " " + mapLines.get(line))
                    .collect(Collectors.toList());
            Files.write(Paths.get(outputFile), resultLines);
            System.out.println("Сортировка выполнена успешно. Проверьте файл: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}