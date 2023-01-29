package com.cdq.app.processor.task.service;

public class TaskService {

    public static int bestMatch(String input, String pattern) {
        int bestMatch = -1;
        int bestDiff = pattern.length();

        for (int i = 0; i <= input.length() - pattern.length(); i++) {
            int diff = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (input.charAt(i + j) != pattern.charAt(j)) {
                    diff++;
                }
            }

            if (diff < bestDiff) {
                bestDiff = diff;
                bestMatch = i;
            }
        }

        int typosCount = 0;
        for (int i = bestMatch, j = 0; i < pattern.length(); i++, j++) {
            if (input.charAt(i) != pattern.charAt(j)) {
                typosCount++;
            }
        }
        System.out.println("Typos count: " + typosCount);
        return bestMatch;
    }


}
