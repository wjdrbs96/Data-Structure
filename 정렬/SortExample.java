package Data_Structure.정렬;

public class SortExample {
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable key;

        int j = 0;
        for (int i = 1; i < n; ++i) {
            key = a[i];
            j = i - 1;

            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Movie[] hitMovies = new Movie[5];

        hitMovies[0] = new Movie("명량", 2014);
        hitMovies[1] = new Movie("극한직업", 2019);
        hitMovies[2] = new Movie("신과함께", 2017);
        hitMovies[3] = new Movie("국제시장", 2014);
        hitMovies[4] = new Movie("베테랑", 2015);
        sort(hitMovies);

        for (Movie m : hitMovies) {
            System.out.println(m.toString());
        }
    }

}

class Movie implements Comparable {
    private String title;
    private int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + "(" + year + ")";
    }

    @Override
    public int compareTo(Object o) {
        Movie m = (Movie)o;
        return this.title.compareTo(m.title);
    }
}
