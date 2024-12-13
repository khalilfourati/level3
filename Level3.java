package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		// TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des employés
		String names = employees.stream()
				.map(Employee::getName)
				.reduce("", (name1, name2) -> name1 + " " + name2).trim();
		System.out.println("All employee names: " + names);

		// TO DO 2: Retourner une chaîne de caractères qui contient tous les noms des employés en majuscules séparés par #
		String namesMajSplit = employees.stream()
				.map(employee -> employee.getName().toUpperCase())
				.collect(Collectors.joining("#"));
		System.out.println("All employee names in uppercase separated by #: " + namesMajSplit);

		// TO DO 3: Retourner un set d'employés
		Set<Employee> emps = employees.stream()
				.collect(Collectors.toSet());
		System.out.println("Set of employees: " + emps);

		// TO DO 4: Retourner un TreeSet d'employés (tri par nom)
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
		System.out.println("TreeSet of employees sorted by name: " + emps2);

		// TO DO 5: Retourner une Map qui regroupe les employés par salaire
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("Map grouping employees by salary: " + map);

		// TO DO 6: Retourner une Map qui regroupe les noms des employés par salaire
		Map<Integer, String> mm = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.joining(", "))));
		System.out.println("Map grouping employee names by salary: " + mm);

		// TO DO 7: Retourner le min, max, average, sum, count des salaires
		String s = employees.stream()
				.mapToInt(Employee::getSalary)
				.summaryStatistics()
				.toString();
		System.out.println("Salary statistics (min, max, average, sum, count): " + s);
	}
}
