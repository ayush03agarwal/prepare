package one;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}


public class RobotRoomCleaner {


    int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<List<Integer>> cleaned = new HashSet<>();

    public static void main(String[] args) {

        Set<List<Integer>> set = new HashSet<>();
        Integer a[] = {0, 0};
        set.add(Arrays.asList(a));
        Integer b[] = {0, 0};
        System.out.println(set.contains(Arrays.asList(b)));


    }

    public void cleanRoom(Robot robot) {

        dfs(0, 0, 0, robot);


    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void dfs(int x, int y, int dir, Robot robot) {
        Integer a[] = {x, y};
        cleaned.add(Arrays.asList(a));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int new_dir = (dir + i) % 4;
            int new_x = x + dirs[new_dir][0];
            int new_y = y + dirs[new_dir][1];
            Integer b[] = {new_x, new_y};
            if (robot.move() && !cleaned.contains(Arrays.asList(b))) {
                dfs(new_x, new_y, new_dir, robot);
                goBack(robot);
            }
            robot.turnRight();
        }
    }
}
