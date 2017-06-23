package com.more;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/6/23.
 */
public class MyCallable implements Callable {
    private  int j;

    public MyCallable(int j){
        this.j = j;
    }

    public Integer call() throws Exception {
        System.out.println("T "+ Thread.currentThread().getName() + " : " + j);
        int i = j + (int)(Math.random()*100);
        System.out.println("start " + j + " result: " + i);
        return i;

    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for(int i = 0; i<100; i++){
            Future<Integer> future = threadPool.submit(new MyCallable(i));
            list.add(future);
        }
        System.out.println(list.size());

    }
}
