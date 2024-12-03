import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        String currentDir = new File("").getAbsolutePath();
        System.out.println("Current working directory: " + currentDir);

        // 파일을 읽어옴
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));

        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] numbers = line.split("\\s+");

            // 분리된 문자열을 정수로 변환하여 각 리스트에 추가
            column1.add(Integer.parseInt(numbers[0]));
            column2.add(Integer.parseInt(numbers[1]));
        }

        // 각 컬럼을 오름차순으로 정렬
        Collections.sort(column1);
        Collections.sort(column2);

        // 절댓값 거리의 합 계산
        int absoluteDistanceSum = 0;
        for (int i = 0; i < column1.size(); i++) {
            absoluteDistanceSum += Math.abs(column1.get(i) - column2.get(i));
        }

        System.out.println("Sum of absolute distances: " + absoluteDistanceSum);

        br.close();
    }
}