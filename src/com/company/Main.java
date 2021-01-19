package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Part1 part1 = new Part1();
//        Part2 part2 = new Part2();
        Part3 part3 = new Part3();
        Part4 part4 = new Part4();

        part1.start();
//        part2.start();
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
            ArrayList<Article> articles1 = new ArrayList<>();
            String line1 = "";
            Date min1 = new Date(2030, 11, 31, 23, 59, 59);
            Date max1 = new Date(1900, 0, 1, 0, 01, 01);
            String maxid1 = "1";
            String minid1 = "1";
            synchronized (object) {
                try {
                    BufferedReader br1 = new BufferedReader(new FileReader("../csv/part1.csv"));
                    FileWriter csvWrite1 = new FileWriter("../csv/record.csv");
                    while ((line1 = br1.readLine()) != null) {
                        String[] article1 = line1.split(",");
                        articles1.add(new Article(article1[0], article1[1], article1[2], article1[3], article1[4], article1[5]));
                    }
                    for (int i = 1; i < articles1.size(); i++) {
                        Date temp1 = articles1.get(i).convert(articles1.get(i).getPublished_at());
                        if (temp1.after(max1)) {
                            maxid1 = articles1.get(i).id;
                            max1 = temp1;
                        }
                        if (temp1.before(min1)) {
                            minid1 = articles1.get(i).id;
                            min1 = temp1;
                        }
                    }
                    csvWriter(csvWrite1, articles1, minid1, maxid1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class Part2 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles2 = new ArrayList<>();
            String line2 = "";
            Date min2 = new Date(2030, 11, 31, 23, 59, 59);
            Date max2 = new Date(1900, 0, 1, 0, 01, 01);
            String maxid2 = "1";
            String minid2 = "1";
            synchronized (object) {
                try {
                    BufferedReader br2 = new BufferedReader(new FileReader("../csv/part2.csv"));
                    FileWriter csvWrite2 = new FileWriter("../csv/record.csv");
                    while ((line2 = br2.readLine()) != null) {
                        String[] article2 = line2.split(",");
                        articles2.add(new Article(article2[0], article2[1], article2[2], article2[3], article2[4], article2[5]));
                    }
                    for (int i = 1; i < articles2.size(); i++) {
                        Date temp2 = articles2.get(i).convert(articles2.get(i).getPublished_at());
                        if (temp2.after(max2)) {
                            maxid2 = articles2.get(i).id;
                            max2 = temp2;
                        }
                        if (temp2.before(min2)) {
                            minid2 = articles2.get(i).id;
                            min2 = temp2;
                        }
                    }
                    csvWriter(csvWrite2, articles2, minid2, maxid2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class Part3 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles3 = new ArrayList<>();
            String line3 = "";
            Date min3 = new Date(2030, 11, 31, 23, 59, 59);
            Date max3 = new Date(1900, 0, 1, 0, 01, 01);
            String maxid3 = "1";
            String minid3 = "1";
            synchronized (object) {
                try {
                    BufferedReader br3 = new BufferedReader(new FileReader("../csv/part3.csv"));
                    FileWriter csvWrite3 = new FileWriter("../csv/record.csv");
                    while ((line3 = br3.readLine()) != null) {
                        String[] article3 = line3.split(",");
                        articles3.add(new Article(article3[0], article3[1], article3[2], article3[3], article3[4], article3[5]));
                    }
                    for (int i = 1; i < articles3.size(); i++) {
                        Date temp3 = articles3.get(i).convert(articles3.get(i).getPublished_at());
                        if (temp3.after(max3)) {
                            maxid3 = articles3.get(i).id;
                            max3 = temp3;
                        }
                        if (temp3.before(min3)) {
                            minid3 = articles3.get(i).id;
                            min3 = temp3;
                        }
                    }
                    csvWriter(csvWrite3, articles3, minid3, maxid3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class Part4 extends Thread {
        @Override
        public void run() {
            ArrayList<Article> articles4 = new ArrayList<>();
            String line4 = "";
            Date min4 = new Date(2030, 11, 31, 23, 59, 59);
            Date max4 = new Date(1900, 0, 1, 0, 01, 01);
            String maxid4 = "1";
            String minid4 = "1";
            synchronized (object) {
                try {
                    BufferedReader br4 = new BufferedReader(new FileReader("../csv/part4.csv"));
                    FileWriter csvWrite4 = new FileWriter("../csv/record.csv");
                    while ((line4 = br4.readLine()) != null) {
                        String[] article4 = line4.split(",");
                        articles4.add(new Article(article4[0], article4[1], article4[2], article4[3], article4[4], article4[5]));
                    }
                    for (int i = 1; i < articles4.size(); i++) {
                        Date temp = articles4.get(i).convert(articles4.get(i).getPublished_at());
                        if (temp.after(max4)) {
                            maxid4 = articles4.get(i).id;
                            max4 = temp;
                        }
                        if (temp.before(min4)) {
                            minid4 = articles4.get(i).id;
                            min4 = temp;
                        }
                    }
                    csvWriter(csvWrite4, articles4, minid4, maxid4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
