package org.example.input;

import java.util.Scanner;

public class ConsoleInput implements DataInput{
    Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getConnectionString() {
        System.out.println("введите строку подключения");
        String res = scanner.next();
        if(!res.trim().startsWith("http://")) {
            System.out.println("ввод неверный");
            return getConnectionString();
        }
        return res;
    }

    @Override
    public String getSecret() {
        System.out.println("введите токен");
        String res = scanner.next();
        if(res.trim().equals("")) {
            System.out.println("ввод неверный");
            return getSecret();
        }
        return res;
    }

    @Override
    public int getInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    @Override
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }
}
