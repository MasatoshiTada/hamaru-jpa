package com.example.app;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tada
 */
public class SqlGenerator {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/tada/Java", "insert_data.sql");
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            List<Integer> itemIdList = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                String sql = "INSERT INTO T_ITEM(ID, NAME) VALUES(?1, ?2)";
                sql = sql.replace("?1", Integer.toString(i))
                        .replace("?2", "'item" + i + "'");
                bw.write(sql);
                bw.newLine();
                itemIdList.add(i);
            }
            Collections.shuffle(itemIdList);
            bw.newLine();
            
            for (int i = 0; i < 100; i++) {
                String sql = "INSERT INTO T_ORDER(ID) VALUES(?1)";
                sql = sql.replace("?1", Integer.toString(1000 + i));
                bw.write(sql);
                bw.newLine();
            }
            bw.newLine();
            
            for (int i = 0; i < 500; i++) {
                String sql = "INSERT INTO T_ORDER_ITEM(ID, ORDER_ID, ITEM_ID) VALUES(?1, ?2, ?3)";
                sql = sql.replace("?1", Integer.toString(i))
                        .replace("?2", Integer.toString(1000 + i / 5))
                        .replace("?3", Integer.toString(itemIdList.get(i)));
                bw.write(sql);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
