/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg2;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author USER
 */
public class Followers extends Thread implements Runnable {

    static String[][] fol = {};
    private static int c;
    private static int n1;

    Followers(int i, int n) {
        c = i;
        n1 = n;
    }

    public void start() {
        synchronized (this) {
            fol = new String[FollowersDetails.followersLink.size()][6];
            String[][] info = new String[FollowersDetails.followersLink.size()][5];

            Document document = null;
            try {
                document = Jsoup.connect(FollowersDetails.followersLink.get(c)).timeout(0).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert document != null;
            Elements data = document.getElementsByClass("Counter hide-lg hide-md hide-sm");

            int i = 0;
            for (Element dataS : data) {
                info[c][i] = dataS.text();
                i++;
            }

            fol[c][0] = String.valueOf(n1 + 1);

            arraylist(FollowersDetails.id, fol, info);
        }
    }

    private static void arraylist(ArrayList<String> id, String[][] fol, String[][] info) {

        String[] logS = id.get(c).split("/");
        for (String logSL : logS) {
            fol[c][1] = logSL;
        }

        for (int a = 0; a < fol[c].length; a++) {
            for (int b = 0; b < info[c].length; b++) {
                if (b == 0 && a == 2) {
                    fol[c][a] = info[c][b];
                } else if (b == 3 && a == 3) {
                    fol[c][a] = info[c][b];
                } else if (b == 2 && a == 4) {
                    fol[c][a] = info[c][b];
                } else if (b == 4 && a == 5) {
                    fol[c][a] = info[c][b];
                }
            }
        }
    }
}
