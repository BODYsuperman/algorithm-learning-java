package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {


    List<String> res =  new ArrayList<>();
    List<String> path =  new ArrayList<>();


    public List<String> restoreIpAddresses(String s) {

        dfs(s, 0);


        return res;
    }

    private void dfs(String s, int startIndex) {

        if(path.size() == 4){
            if(startIndex == s.length()){
                res.add(String.join(".", path));
            }
        }

        for (int i = startIndex; i < s.length() ; i++) {

            if(i - startIndex >= 3) break;

            String segment = s.substring(startIndex, i + 1);
            if(!isValid(segment)) continue;
            path.add(segment);

            dfs(s, i+1);

            path.remove(path.size()-1);


        }
    }


    private boolean isValid(String s) {

        if(s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >=0 && num <= 255;
    }
}
