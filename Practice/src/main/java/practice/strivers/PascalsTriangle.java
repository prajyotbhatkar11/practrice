package practice.strivers;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {


    public static void main(String[] args) {
        int rows = 5;
        System.out.println(setPascalTriangle(rows));

    }

    public static List<List<Integer>> setPascalTriangle(int rows) {
        List<List<Integer>> result = new ArrayList<>();

//            List<Integer> triangleList = new ArrayList<>();
//            triangleList.add(1);
//            result.add(triangleList);
        for (int i = 1; i <= rows; i++) {
            List<Integer> angleList = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                if (j == 0 || j == i - 1) {
                    angleList.add(1);
                } else {
                    angleList.add(result.get(i - 2).get(j) + result.get(i - 2).get(j - 1));
                }
            }
            result.add(angleList);
        }

        return result;
    }
}
