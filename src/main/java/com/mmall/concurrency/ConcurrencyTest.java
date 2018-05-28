package com.mmall.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author SQiang
 * @create 2018-05-22 14:59
 **/
@Slf4j
public class ConcurrencyTest {

	//请求总数
	public static int clientTotal=5000;
	//同时并发执行的线程数
	public static int threadTotal = 200;
	//计数器
	public static  int count = 0;
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch  coutDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0; i<clientTotal;i++){
			executorService.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				}catch (Exception e){
					log.error("excetion",e);
				}
				coutDownLatch.countDown();
			});
		}
		coutDownLatch.await();
		executorService.shutdown();
		log.info("count:{}"+count);
	}
	private static void add(){
		count++;
	}
}
