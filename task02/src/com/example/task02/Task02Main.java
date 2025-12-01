package com.example.task02;

import java.io.File;
import java.io.IOException;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task02Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:


        System.out.println(listFiles(Paths.get("task02/src/main/resources/")));


    }

    public static List<Path> listFiles(Path rootDir) throws IOException, InterruptedException {
        // your implementation here
        List<Path> files = new ArrayList<>();
        Stack<Path> stack = new Stack<>();
        stack.push(rootDir);
        while (!stack.isEmpty()) {
            Path path = stack.pop();
            if (path.toFile().isFile()) {
                files.add(path);
            }
            else  {
                for (File p : path.toFile().listFiles()) {
                    stack.add(p.toPath());
                }
            }
        }
        return files;
    }
}
