package Data_Structure.정렬.HomeWork1.A2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainCode {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Java\\src\\Data_Structure\\정렬\\HomeWork1\\A2\\movie1.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";

        Movie[] m = new Movie[19];

        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {              // 파일 한줄 씩 읽어오기
            String[] sp = line.split("\t");                        // \t을 기준으로 문자열 분리
            m[i] = new Movie(sp[0], Integer.parseInt(sp[1]));
            i++;
        }

        InsertionSort.sort(m);


        for (Movie m1 : m) {
            System.out.println(m1.toString());
        }

        bufferedReader.close();
    }
}
