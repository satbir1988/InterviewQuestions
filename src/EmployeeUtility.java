package com.answers;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeUtility {
	
	private static Integer[] arrayInteger = new Integer[] {9,7,8,12,15,3,6,37};

	public static Map<Integer, List<Employee>> compareAndSort() {
		System.out.println("*****************CompareAndSort****************");

		Map<Integer, List<Employee>> map = getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.collectingAndThen(Collectors.toList(),
						l -> l.parallelStream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()))));
		System.out.println(map);
		return map;
	}

	public static String joinEmployeeName() {
		System.out.println("*****************Joining****************");
		String names = EmployeeUtility.getEmployees().stream().filter(employee -> employee.getDepartmentId().intValue() == 1).map(Employee::getName)
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(names);
		return names;
	}

	public static Map<Boolean, List<Employee>> partionById() {
		System.out.println("*****************Partioning****************");
		Map<Boolean, List<Employee>> map = EmployeeUtility.getEmployees().stream()
				.collect(Collectors.partitioningBy(employee -> employee.getDepartmentId() % 2 == 0));
		System.out.println(map);
		return map;
	}

	public static Map<Integer, List<Employee>> groupBy() {
		System.out.println("*****************GroupBy****************");
		Map<Integer, List<Employee>> employeesById = EmployeeUtility.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId));
		System.out.println(employeesById);
		return employeesById;

	}

	// Mapping Collectors(Function,Collector(Function,Collectors))
	public static Map<Integer, List<String>> groupByThenMapping() {
		System.out.println("*****************GroupAndMapping****************");
		Map<Integer, List<String>> employeesById = EmployeeUtility.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(employeesById);
		return employeesById;

	}

	public static Map<Integer, Long> groupByCounting() {
		System.out.println("*****************GroupAndCounting****************");
		Map<Integer, Long> employeesById = EmployeeUtility.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.counting()));
		System.out.println(employeesById);
		return employeesById;
	}

	// Collectors(Collectors,Function)
	public static Map<Integer, Integer> collectingAndThen() {
		System.out.println("*****************CollectingAndThen****************");
		Map<Integer, Integer> employeesById = EmployeeUtility.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
		System.out.println(employeesById);
		return employeesById;
	}

	public static String getMaxName() {
		System.out.println("*****************MaxByName****************");
		String maxName = getEmployees().stream()
				.collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getName)), emp -> {
					return emp.map(Employee::getName).orElse("");
				}));
		System.out.println(maxName);
		return maxName;
	}
	
	public static String getMinName() {
		System.out.println("*****************MinByName****************");
		String minName = getEmployees().stream()
				.collect(Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Employee::getName)), emp -> {
					return emp.map(Employee::getName).orElse("");
				}));
		System.out.println(minName);
		return minName;
	}
	
	public static void getDistinct() {
		System.out.println("*****************Distinct****************");
		List<String> distinct = getEmployees().stream().map(Employee::getName).distinct().collect(Collectors.toList());
		System.out.println(distinct);
	}
	
	public static void getCount() {
		System.out.println("*****************Count****************");
		Long count = getEmployees().stream().map(Employee::getName).count();
		System.out.println(count);
	}
	
	public static String getMax() {
		System.out.println("*****************Max****************");
		String maxName = getEmployees().stream().map(Employee::getName).max(Comparator.naturalOrder()).get();
		System.out.println(maxName);
		return maxName;
	}
	
	public static String getMin() {
		System.out.println("*****************Min****************");
		String maxName = getEmployees().stream().map(Employee::getName).min(Comparator.naturalOrder()).get();
		System.out.println(maxName);
		return maxName;
	}
	
	public static void sortArray() {
		System.out.println("*****************Sort Array****************");
		Integer[] arrayInteger = new Integer[] {9,7,8,12,15,3,6,37};
		Arrays.sort(arrayInteger);
		System.out.println("Sorted Array " + Arrays.asList(arrayInteger));
		
		Integer[] streamArray = new Integer[] {9,7,8,12,15,3,6,37};
		
		List<Integer> sortedList = Arrays.asList(streamArray).stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Array using stream" + Arrays.asList(sortedList));
	}
	
	public static void sum() {
		Integer sum = Arrays.stream(arrayInteger).mapToInt(Integer::intValue).sum();
		System.out.println("*****************Sum****************");
		System.out.println(sum);
	}
	
	public static void avg() {
		OptionalDouble avg = Arrays.stream(arrayInteger).mapToInt(Integer::intValue).average();
		System.out.println("*****************Average****************");
		System.out.println(avg);
	}


	public static List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Sansa"));
		employeeList.add(new Employee(1, "Jon"));
		employeeList.add(new Employee(1, "Arya"));
		employeeList.add(new Employee(1, "Ned"));
		employeeList.add(new Employee(2, "Sarsi"));
		employeeList.add(new Employee(2, "Joffery"));
		employeeList.add(new Employee(1, "Benjen"));
		return employeeList;
	}

}
