package one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = new int[2][];
        prerequisites[0] = new int[]{1, 0};
        System.out.println(canFinish(prerequisites.length, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        Map<Integer, List<Integer>> m = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i] != null && prerequisites[i].length != 0) {
                List<Integer> orDefault = m.getOrDefault(prerequisites[i][0], new ArrayList<>());
                orDefault.add(prerequisites[i][1]);
                m.put(prerequisites[i][0], orDefault);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (prerequisites[i] != null) {
                if (!isCycle(m, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCycle(Map<Integer, List<Integer>> m, int[] visited, int i) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == 2) {
            return false;
        }
        visited[i] = 1;
        if (m.get(i) != null) {
            List<Integer> a = m.get(i);
            for (int b : a) {
                if (isCycle(m, visited, b)) {
                    return true;
                }
            }
        }
        visited[i] = 2;
        return false;
    }

}
