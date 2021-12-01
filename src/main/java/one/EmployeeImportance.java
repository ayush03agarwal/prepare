package one;

import java.util.*;

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        if (employees.isEmpty()) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (Employee e : employees) {
            map.put(e.id, index++);
        }

        Employee emp = employees.get(map.get(id));
        q.addAll(emp.subordinates);

        int total = emp.importance;
        while (!q.isEmpty()) {
            int subId = q.remove();
            Employee subE = employees.get(map.get(subId));
            q.addAll(subE.subordinates);
            total += subE.importance;
        }
        return total;

    }

}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};