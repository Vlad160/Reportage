import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[] height = {1, 5, 3, 6, 2, 8, 10, 5, 4};
        Integer[] max = new Integer[9];
        Integer[] maxMin = new Integer[9];
        Integer[] sequenceMax = new Integer[9];
        Integer[] sequenceMin = new Integer[9];
        for (int i = 0; i < 9; ++i) {
            max[i] = 0;
            sequenceMax[i] = -1;
            for (int j = 0; j < i; ++j) {
                if (height[j] < height[i]) {
                    if (1 + max[j] > max[i]) {
                        max[i] = max[j] + 1;
                        sequenceMax[i] = j;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(sequenceMax));
        Collections.reverse(Arrays.asList(height));
        for (int i = 0; i < 9; ++i) {
            max[i] = 0;
            sequenceMax[i] = -1;
            for (int j = 0; j < i; ++j) {
                if (height[j] < height[i]) {
                    if (1 + max[j] > max[i]) {
                        max[i] = max[j] + 1;
                        sequenceMax[i] = j;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(sequenceMax));
        for (int i = 0; i < 9; ++i) {
            maxMin[i] = 0;
            sequenceMin[i] = -1;
            for (int j = 0; j < i; ++j) {
                if (height[j] > height[i]) {
                    if (1 + maxMin[j] > maxMin[i]) {
                        maxMin[i] = maxMin[j] + 1;
                        sequenceMin[i] = j;
                    }
                }
            }

        }
        int answer = max[0];
        int pos = 0;
        for (int i = 0; i < 9; ++i) {
            if (max[i] > answer) {
                answer = max[i];
                pos = i;
            }
        }
        answer++;
        int answerMin = maxMin[0];
        int posMin = 0;
        for (int i = 0; i < 9; ++i) {
            if (maxMin[i] > answerMin) {
                answerMin = maxMin[i];
                posMin = i;
            }
        }
        System.out.println(answer);
        List<Integer> path = new LinkedList<>();
        while (pos != -1) {
            path.add(pos);
            pos = sequenceMax[pos];
        }
        Collections.reverse(path);
        System.out.println(path.toString());
        List<Integer> pathMin = new LinkedList<>();
        while (posMin != -1) {
            pathMin.add(posMin);
            posMin = sequenceMin[posMin];
        }
        Collections.reverse(pathMin);
        System.out.println(pathMin.toString());
    }
}
