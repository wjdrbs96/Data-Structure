package Data_Structure.정렬.HomeWork1.A1;

public class MovieSort {
    public static void main(String[] args) {
        Movie[] m = new Movie[5];
        m[0] = new Movie("기생충", 2019);
        m[1] = new Movie("범죄도시", 2017);
        m[2] = new Movie("라라랜드", 2016);
        m[3] = new Movie("봉오동전투", 2019);
        m[4] = new Movie("뷰티인사이드", 2015);

        InsertionSort.sort(m);

        for (Movie m1 : m) {
            System.out.println(m1.toString());
        }


    }
}
