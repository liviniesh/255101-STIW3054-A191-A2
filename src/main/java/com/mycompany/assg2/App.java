/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg2;

import static com.mycompany.assg2.FollowersDetails.followersLink;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class App {

    static String[][] List = {};
    private static FollowersDetails followersdetail = new FollowersDetails();
    private static WriteToExcel ex = new WriteToExcel();

    public static void main(String[] args) throws IOException {
        followersdetail.Show();
        List = new String[FollowersDetails.followersLink.size() + 2][6];
        List[0] = new String[]{"No.", "login id", "No of repositories", "No of followers", "No of stars", "No of following"};
        System.out.printf("| %-3s | %-20s | %-18s | %-16s | %-14s | %-16s |%n", List[0][0], List[0][1], List[0][2], List[0][3], List[0][4], List[0][5]);
        System.out.println("");

        for (int x = FollowersDetails.followersLink.size() - 1, y = 0; x >= 0; x--) {
            Thread t = new Followers(x, y++);
            try {
                t.start();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

            List[y] = new String[]{Followers.fol[x][0], Followers.fol[x][1], Followers.fol[x][2],
                Followers.fol[x][3], Followers.fol[x][4], Followers.fol[x][5]};
            System.out.printf("| %-3s | %-20s | %-18s | %-16s | %-14s | %-16s |%n", List[y][0], List[y][1], List[y][2], List[y][3], List[y][4], List[y][5]);
        }
        ex.main(args);
    }
}
