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
public class FollowersDetails {

    static ArrayList<String> followersLink = new ArrayList<>(), id = new ArrayList<>(), link = new ArrayList<>();
    private static ArrayList<Document> document = new ArrayList<>();
    private static ArrayList<Elements> detail = new ArrayList<>();

    static void Show() {
        arraylist(link, document);

        int c = 0, a = 0;
        for (Document doc : document) {
            detail.add(doc.getElementsByClass("d-inline-block no-underline mb-1"));

            for (Element datas : detail.get(c)) {
                assert id != null;
                id.add(datas.attr("href"));
                followersLink.add("https://github.com" + id.get(a));
                a++;
            }
            c++;
        }
    }

    private static void arraylist(ArrayList<String> link, ArrayList<Document> document) {
        link.add("https://github.com/zhamri?tab=followers");
        link.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOS0wMi0yMFQxMTo1NDozOCswODowMM4Cfdf_&tab=followers");
        link.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOC0wOS0xNFQxMTozNzozMiswODowMM4CPUKe&tab=followers");
        link.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxNy0wOS0xM1QyMTo1MDoxMCswODowMM4BoGXN&tab=followers");

        for (String Link : link) {
            try {
                document.add(Jsoup.connect(Link).get());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
