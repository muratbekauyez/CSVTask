package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ArticleList extends Thread {
    private ArrayList<Article> articles;
    ArrayList<Report> reports;

    Date max, min;
    String maxID, minID;
    String[] paths;

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public ArticleList(String[] paths) {
        this.paths = paths;
    }


    @Override
    public void run() {
        reports = new ArrayList<>();
        articles = new ArrayList<>();
        min = new Date(2030, 11, 31, 23, 59, 59);
        max = new Date(1900, 0, 1, 0, 01, 01);
        maxID = "1";
        minID = "1";
        String minStr = "";
        String maxStr = "";

        try {
            for (int i = 0; i < paths.length; i++) {
                BufferedReader br = new BufferedReader(new FileReader(paths[i]));
                String line = br.readLine();
                while (line != null) {
                    String[] columns = line.split(",");
                    if (columns.length != 6) {
                        line = br.readLine();
                        continue;
                    }
                    Article article = new Article(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
                    articles.add(article);

                    Report report = new Report(article.getId(), article.getSource_name(), article.getSource_id());
                    if (article.getContent().contains("[+")) {
                        int firstIndex = article.getContent().indexOf("[+")+ 2;
                        int lastIndex = article.getContent().indexOf("chars]") - 1;
                        int length = article.getContent().length() + Integer.parseInt(article.getContent().substring(firstIndex, lastIndex));
                        report.setAvg_content_length("[+"+ length + " chars]");
                    }

                    reports.add(report);


                    if (article.getPublished_at().length() == 20) {
                        Date temp = article.convert(article.getPublished_at());

                        if (temp.after(max)) {
                            maxID = article.id;
                            max = temp;
                            maxStr = article.getPublished_at();
                        }
                        if (temp.before(min)) {
                            minID = article.id;
                            min = temp;
                            minStr = article.getPublished_at();
                        }
                    }
                    line = br.readLine();

                }
            }

            for (Report report : reports) {
                if (report.getId().equals(minID)) {
                    report.setPublished_from(minStr);
                } else if (report.getId().equals(maxID)) {
                    report.setPublished_to(maxStr);
                }

            }
            synchronized (reports) {
                FileWriter csvWrite = new FileWriter("../csv/record.csv");
                for (Report rec : reports) {
                    csvWrite.append(rec.getSource_name() + ",");
                    csvWrite.append(rec.getSource_id() + ",");
                    if (rec.getPublished_from() != null) csvWrite.append(rec.getPublished_from());
                    if (rec.getPublished_to() != null) csvWrite.append(rec.getPublished_to());
                    if (rec.getAvg_content_length() != null) csvWrite.append(rec.getAvg_content_length());

                    csvWrite.append("\n");
                }
                csvWrite.flush();
                csvWrite.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
