package leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EmployeeImportance_690 {
	public static int sum =0;
	public int dfs(Employee e) {
		Stack<Employee> stack = new Stack();
		stack.push(e);
		while(!stack.isEmpty()) {
			Employee element = stack.pop(); 
			if(!element.visited) {
				element.visited = true;
				sum = sum+element.value;
			}
			List<Employee> elements  = element.getEmployee();
			if(elements!=null && elements.size()!=0)
			for(Employee emp: elements) {
				if(emp!=null && !emp.visited) {
					stack.push(emp);
				}
			}
		}
		return sum;
	}
	public int getImportance(List<Employee> employees, int id) {
		for(Employee e:employees) {
			if(e.id==id) {
				return dfs(e);
			}
		}
		return 0;
	}
	public static void main(String args[]) {
		Employee e1 = new Employee(2,3,null);
		Employee e2 = new Employee(3,3,null);
		Employee e3 = new Employee(1,5,Arrays.asList(e1,e2));
		List<Employee> lst = Arrays.asList(e1,e2,e3);
		EmployeeImportance_690 e = new EmployeeImportance_690();
		System.out.println(e.getImportance(lst,1));
	}
}

class Employee {
	public Employee(int id, int value, List<Employee> employees) {
		super();
		this.id = id;
		this.value = value;
		this.employees = employees;
	}

	int id;
	int value;
	boolean visited;
	List<Employee> employees;

	Employee(int id) {
		this.id = id;
		this.employees = new ArrayList<>();
	}

	public void addEmployees(Employee employee) {
		this.employees.add(employee);
	}

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
