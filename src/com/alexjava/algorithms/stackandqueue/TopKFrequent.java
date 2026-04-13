package com.alexjava.algorithms.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // 优先级队列，为了避免复杂 api 操作，pq 存储数

        PriorityQueue<int[] > pq =  new PriorityQueue<>((o1, o2) -> o1[1]- o2[1]);

        int[] res = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(var x: map.entrySet()){
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();

            pq.offer(tmp);

            if(pq.size()> k){
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;

    }
}
