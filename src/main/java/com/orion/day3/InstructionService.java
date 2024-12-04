package com.orion.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionService {

    private static final String CLEAN_DATA_PATTERN = "mul\\(\\d{1,3},\\d{1,3}\\)";
    public static final String NUMBER_PATTERN = "\\d{1,3}";

    public List<Instruction> cleanAndPrepareInstructions(String data) {
        List<String> clearedData = cleanData(data);
        return prepareInstructions(clearedData);
    }

    private List<String> cleanData(String data) {
        Pattern pattern = Pattern.compile(CLEAN_DATA_PATTERN);
        Matcher matcher = pattern.matcher(data);
        List<String> cleanedData = new ArrayList<>();

        while (matcher.find()) {
            cleanedData.add(matcher.group());
        }

        return cleanedData;
    }

    private List<Instruction> prepareInstructions(List<String> clearedData) {
        return clearedData.stream()
                .map(InstructionService::toInstruction).toList();
    }

    private static Instruction toInstruction(String data) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(data);
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return new Instruction(numbers.get(0), numbers.get(1));
    }
}
