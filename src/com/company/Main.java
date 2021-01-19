package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] paths = new String[]{
                "../csv/part1.csv",
                "../csv/part2.csv",
                "../csv/part3.csv",
                "../csv/part4.csv"
        };

        ArticleList al = new ArticleList(paths);
        al.start();
    }
}



