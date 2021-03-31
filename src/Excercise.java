package com.answers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Excercise {

	public static void main(String[] arg) throws InterruptedException, ExecutionException {

		/*
		 * Map<String, String> map = new HashMap<>(); map.put("Winterfell", "Arya");
		 * map.put("Carstery", "Sarsi"); map.put("KingLanding", "Joffery");
		 * 
		 * map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(item ->
		 * { System.out.println(item.getValue()); });
		 * 
		 * System.out.println("Reverse order : ");
		 * 
		 * map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.
		 * reverseOrder())).forEach(item -> { System.out.println(item.getValue()); });
		 * 
		 * map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(item ->
		 * { System.out.println(item.getValue()); });
		 * 
		 * map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(item -> {
		 * System.out.println(item.getKey()); });
		 * 
		 * System.out.println("Compare by Value" +
		 * map.entrySet().stream().max(Map.Entry.comparingByKey()));
		 * 
		 * ExecutorService service = Executors.newFixedThreadPool(3);
		 * Future<CompletableFuture<String>> future1 = service.submit(() ->{
		 * System.out.println("Current Thread "+ Thread.currentThread().getName());
		 * Thread.sleep(5000); return CompletableFuture.completedFuture("Test"); });
		 * 
		 * Future<?> future2 = service.submit(() ->{
		 * System.out.println("Current Thread "+ Thread.currentThread().getName());
		 * return "Test"; });
		 * 
		 * Future<?> future3 = service.submit(() ->{
		 * System.out.println("Current Thread "+ Thread.currentThread().getName());
		 * return "Test"; });
		 * 
		 * try { System.out.println("Future 1" + future1.get());
		 * 
		 * System.out.println("Future 2" + future2.get());
		 * 
		 * System.out.println("Future 3" + future3.get()); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (ExecutionException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * future1.get().thenAccept(action-> { System.out.println("Complete" + action);
		 * 
		 * });
		 */

		EmployeeUtility.compareAndSort();
		EmployeeUtility.joinEmployeeName();
		EmployeeUtility.partionById();
		EmployeeUtility.groupBy();
		EmployeeUtility.groupByThenMapping();
		EmployeeUtility.groupByCounting();
		EmployeeUtility.collectingAndThen();
		EmployeeUtility.getMaxName();
		EmployeeUtility.getMinName();
		EmployeeUtility.getMax();
		EmployeeUtility.getMin();
		EmployeeUtility.getDistinct();
		EmployeeUtility.getCount();
		EmployeeUtility.sortArray();	
		EmployeeUtility.sum();
		EmployeeUtility.avg();

	}

}
