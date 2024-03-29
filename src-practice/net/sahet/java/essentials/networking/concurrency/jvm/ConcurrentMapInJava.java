package net.sahet.java.essentials.networking.concurrency.jvm;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-concurrent-map
/*** 
 * 
 * 
 */
public class ConcurrentMapInJava {

	@Test
	public void givenHashMap_whenSumParallel_thenError() throws Exception {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> sumList = parallelSum100(map, 100);

		assertNotEquals(1, sumList.stream().distinct().count());
		long wrongResultCount = sumList.stream().filter(num -> num != 100).count();

		assertTrue(wrongResultCount > 0);
	}

	private List<Integer> parallelSum100(Map<String, Integer> map, int executionTimes) throws InterruptedException {
		List<Integer> sumList = new ArrayList<>(1000);
		for (int i = 0; i < executionTimes; i++) {
			map.put("test", 0);
			ExecutorService executorService = Executors.newFixedThreadPool(4);
			for (int j = 0; j < 10; j++) {
				executorService.execute(() -> {
					for (int k = 0; k < 10; k++)
						map.computeIfPresent("test", (key, value) -> value + 1);
				});
			}
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);
			sumList.add(map.get("test"));
		}
		return sumList;
	}

	@Test
	public void givenConcurrentMap_whenSumParallel_thenCorrect() throws Exception {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		List<Integer> sumList = parallelSum100(map, 1000);

		assertEquals(1, sumList.stream().distinct().count());
		long wrongResultCount = sumList.stream().filter(num -> num != 100).count();

		assertEquals(0, wrongResultCount);
	}
//
//	@Test
//	public void givenConcurrentHashMap_whenPutWithNullKey_thenThrowsNPE() {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			concurrentMap.put(null, new Object());
//		});
//	}
//
//	@Test
//	public void givenConcurrentHashMap_whenPutNullValue_thenThrowsNPE() {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			concurrentMap.put("test", null);
//		});
//	}

}
