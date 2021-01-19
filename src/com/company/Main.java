package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Date date = new Date(1900, 0,1,00, 01,01);
        Date date1 = new Date(2000,3-1,18,6,9,23);
        System.out.println(date);
        sssssss
        System.out.println(date.getYear());
*/

    }
}
