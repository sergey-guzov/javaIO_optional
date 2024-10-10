package com.huz.javaio;

import java.io.*;
import java.util.Stack;

// ll lll    lllll  l  l2; l2
public class WordReplacer {

    public final String readerPath = "src/main/java/com/huz/javaio/WordReplacer.java";
    public final String writerPath = "data/result.txt";

    private final String replacedWord = "public";
    private final String replacingWord = "private";

    public void replaceWord () {
        try (BufferedReader reader = new BufferedReader(new FileReader(readerPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(writerPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String replacedLine = line.replaceAll("public", "private");
                writer.write(replacedLine + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reverseOrder () {
        try (BufferedReader reader = new BufferedReader(new FileReader(readerPath));
             PrintWriter writer = new PrintWriter(new FileWriter(writerPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                char[] array = line.toCharArray();
                Stack<Character> characterStack = new Stack<>();
                for (char ch:array) {
                    characterStack.push(ch);
                }
                StringBuilder builder = new StringBuilder();
                while (!characterStack.empty()) {
                    char ch = characterStack.pop();
                    builder.append(ch);
                }
                writer.write(builder.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void replaceToUpperCase () {
        try (BufferedReader reader = new BufferedReader(new FileReader(readerPath));
             PrintWriter writer = new PrintWriter(new FileWriter(writerPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split("\\s+");
                StringBuilder builder = new StringBuilder();

                for (String str:array) {
                    if (str.length() < 3){
                        str = str.toUpperCase();
                    }
                    builder.append(str).append(" ");
                }
                writer.write(builder.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
