package Data_Structure.정렬.HomeWork1.A1;

public class Movie implements Comparable {
    private String title;
    private int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }


    /*@Override                                // 정렬 기준 1 (제목순으로 정렬)
    public int compareTo(Object o) {
        Movie m1 = (Movie)o;

        return this.title.compareTo(m1.title);
    }*/

    /*@Override                               // 정렬 기준 2 (연도순으로 정렬)
    public int compareTo(Object o) {
        Movie m1 = (Movie)o;

        return this.year - m1.year;
    }*/

    @Override                             // 정렬 기준 3 (1. 연도순으로 정렬 -> 2. 연도가 같으면 제목 순)
    public int compareTo(Object o) {
        Movie m1 = (Movie)o;

        if (this.year == m1.year) {
            return this.title.compareTo(m1.title);
        }

        return this.year - m1.year;

    }

    @Override
    public String toString() {
        return title + "(" + year + ")";
    }


}
