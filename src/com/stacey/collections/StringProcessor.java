package com.stacey.collections;

import java.io.*;
import java.util.*;

public class StringProcessor {

    // 1
    public void reverseStringsInFile(String fileIn, String fileOut) {
        List<String> list = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(fileIn)) ) {
            while ( sc.hasNextLine() ) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.reverse(list);

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileOut))) {
            list.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2
    public void stackDigits(int number) {
        String str = Integer.toString(number);
        Deque<Integer> digits = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            digits.offer(str.charAt(i) - '0');
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(digits.pollLast());
            System.out.println();
        }
    }

    // 3
    public void printTree(String fileName) {
        List<String> list = new ArrayList<>();
        File root = new File(fileName);
        printChildren(root, 0, list);
        list.forEach(System.out::println);
    }

    private void printChildren(File root, int level, List<String> list) {
        File[] children = root.listFiles();
        if ( children!=null && children.length>0 ) {
            for (File file: children) {
                list.add(file.getAbsolutePath());
                if ( file.isDirectory() ) {
                    printChildren(file, level+1, list);
                }
            }
        }
    }

    // 4
    // wrong order
    public void sortList1(List<Integer> list) {
        list.forEach(System.out::println);
        list.sort(Collections.reverseOrder());
        System.out.println();
        list.forEach(System.out::println);
    }

    // right order
    public void sortList2(List<Integer> list) {
        int i = 0;
        int done = 0;
        while ( i < list.size()-done ) {
            if ( list.get(i) < 0 ) {
                list.add(list.get(i));
                list.remove(list.get(i));
                done++;
            } else {
                i++;
            }
        }
        list.forEach(System.out::println);
    }

    //todo 5
    public void sortAroundX(List<Integer> list, int x) {
    }

    // 6
    public boolean checkBrackets(String input) {
        boolean ok;
        Deque<Character> stack = new ArrayDeque<>();
        if ( ok=input != null ) {
            for ( char symbol : input.toCharArray() ) {
                if ( symbol == '(' || symbol == '[' || symbol == '{' ) {
                    stack.offerFirst(symbol);
                } else if ( symbol == ')' || symbol == ']' || symbol == '}' ) {
                    if ( stack.isEmpty() ) {
                        ok = false; break;
                    } else {
                        char bracket = stack.pollFirst();
                        if ( !checkPairBrackets(bracket, symbol) ) {
                            ok = false; break;
                        }
                    }
                }
            }
            ok = ok && stack.isEmpty();
        }
        return ok;
    }

    private boolean checkPairBrackets(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    // 7
    public void countWords(String fileName) {
        Map<String, Integer> map = new HashMap<>();

        try ( Scanner sc = new Scanner(new File(fileName)) ) {
            while ( sc.hasNext() ) {
                String key = deletePunctuation(sc.next());
                if ( map.containsKey(key) ) {
                    map.put(key, map.get(key)+1);
                } else {
                    map.put(key, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String key: map.keySet()) {
            int value = map.get(key);
            System.out.println(key + " " + value);
        }
    }

    private String deletePunctuation(String s) {
        return s.replaceAll("\\W$", "");
    }

    // 8
    public void findClosestNumber(int number, List<Integer> list) {
        NumberList numberList = new NumberList(list);
        numberList.add(7);
        numberList.remove(2);
        System.out.println(numberList);
        System.out.println("Closest number to " + number + " is: " + numberList.closestNumber(number));
    }
}
