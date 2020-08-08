package com.paring;

import java.util.HashMap;

public class Game {
    int rightPositions;
    int wrongPositions;
    HashMap<String, Integer> test1 = new HashMap<>();
    String[] code = new String[]{"Red", "Green", "Yellow", "Blue"};

    public Game() {
        for (int i = 0; i < code.length; i++) {
            test1.put(code[i], test1.containsKey(code[i]) ? test1.get(code[i]) + 1 : 0);
        }
    }

    public void masterMind(String[] input) {

        for (int i = 0; i < input.length; i++) {
            if (test1.containsKey(input[i])) {
                if (code[i].equals(input[i]))
                    rightPositions++;
                else
                    wrongPositions++;
            }

        }

    }

    public int getRightPositions() {
        return this.rightPositions;
    }

    public int getWrongPositions() {
        return this.wrongPositions;
    }
}
