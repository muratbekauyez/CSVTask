package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        Part3 part3 = new Part3();
        Part4 part4 = new Part4();

        part1.start();
        part2.start();
        part3.start();
        part4.start();

    }

    static void csvWriter(FileWriter csvWrite, ArrayList<Article> articles, String minid, String maxid) throws IOException {
        for (int i = 1; i < articles.size(); i++) {
            csvWrite.append(articles.get(i).source_name + ",");
            csvWrite.append(articles.get(i).source_id + ",");
            if (articles.get(i).id == minid || articles.get(i).id == maxid) {
                csvWrite.append(articles.get(i).published_at + ",");
            }
            if (articles.get(i).getContent().contains("[+")) {
                int firstIndex = articles.get(i).getContent().indexOf("[+");
                int lastIndex = articles.get(i).getContent().indexOf("chars]") + 6;
                csvWrite.append(articles.get(i).getContent().substring(firstIndex, lastIndex));
            }
            csvWrite.append("\n");

        }
        csvWrite.flush();
        csvWrite.close();
    }

    static class Part1 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles = new ArrayList<>();
            String line = "";
            Date min = new Date(2030, 11, 31, 23, 59, 59);
            Date max = new Date(1900, 0, 1, 0, 01, 01);
            String maxid = "1";
            String minid = "1";
            try {
                BufferedReader br = new BufferedReader(new FileReader("../csv/part1.csv"));
                FileWriter csvWrite = new FileWriter("../csv/record.csv");
                while ((line = br.readLine()) != null) {
                    String[] article = line.split(",");
                    articles.add(new Article(article[0], article[1], article[2], article[3], article[4], article[5]));
                }
                for (int i = 1; i < articles.size(); i++) {
                    Date temp = articles.get(i).convert(articles.get(i).getPublished_at());
                    if (temp.after(max)) {
                        maxid = articles.get(i).id;
                        max = temp;
                    }
                    if (temp.before(min)) {
                        minid = articles.get(i).id;
                        min = temp;
                    }
                }
                csvWriter(csvWrite, articles, minid, maxid);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Part2 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles = new ArrayList<>();
            String line = "";
            Date min = new Date(2030, 11, 31, 23, 59, 59);
            Date max = new Date(1900, 0, 1, 0, 01, 01);
            String maxid = "1";
            String minid = "1";
            try {
                BufferedReader br = new BufferedReader(new FileReader("../csv/part2.csv"));
                FileWriter csvWrite = new FileWriter("../csv/record.csv");
                while ((line = br.readLine()) != null) {
                    String[] article = line.split(",");
                    articles.add(new Article(article[0], article[1], article[2], article[3], article[4], article[5]));
                }
                for (int i = 1; i < articles.size(); i++) {
                    Date temp = articles.get(i).convert(articles.get(i).getPublished_at());
                    if (temp.after(max)) {
                        maxid = articles.get(i).id;
                        max = temp;
                    }
                    if (temp.before(min)) {
                        minid = articles.get(i).id;
                        min = temp;
                    }
                }
                csvWriter(csvWrite, articles, minid, maxid);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Part3 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles = new ArrayList<>();
            String line = "";
            Date min = new Date(2030, 11, 31, 23, 59, 59);
            Date max = new Date(1900, 0, 1, 0, 01, 01);
            String maxid = "1";
            String minid = "1";
            try {
                BufferedReader br = new BufferedReader(new FileReader("../csv/part3.csv"));
                FileWriter csvWrite = new FileWriter("../csv/record.csv");
                while ((line = br.readLine()) != null) {
                    String[] article = line.split(",");
                    articles.add(new Article(article[0], article[1], article[2], article[3], article[4], article[5]));
                }
                for (int i = 1; i < articles.size(); i++) {
                    Date temp = articles.get(i).convert(articles.get(i).getPublished_at());
                    if (temp.after(max)) {
                        maxid = articles.get(i).id;
                        max = temp;
                    }
                    if (temp.before(min)) {
                        minid = articles.get(i).id;
                        min = temp;
                    }
                }
                csvWriter(csvWrite, articles, minid, maxid);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Part4 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles = new ArrayList<>();
            String line = "";
            Date min = new Date(2030, 11, 31, 23, 59, 59);
            Date max = new Date(1900, 0, 1, 0, 01, 01);
            String maxid = "1";
            String minid = "1";
            try {
                BufferedReader br = new BufferedReader(new FileReader("../csv/part4.csv"));
                FileWriter csvWrite = new FileWriter("../csv/record.csv");
                while ((line = br.readLine()) != null) {
                    String[] article = line.split(",");
                    articles.add(new Article(article[0], article[1], article[2], article[3], article[4], article[5]));
                }
                for (int i = 1; i < articles.size(); i++) {
                    Date temp = articles.get(i).convert(articles.get(i).getPublished_at());
                    if (temp.after(max)) {
                        maxid = articles.get(i).id;
                        max = temp;
                    }
                    if (temp.before(min)) {
                        minid = articles.get(i).id;
                        min = temp;
                    }
                }
                csvWriter(csvWrite, articles, minid, maxid);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

}
