package suanfa;

public class Quick3Way {

    public static void main(String[] args) {
        Integer[] testArray = {3, 1, 45, 8, 9, 5, 6};
        sort(testArray);
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
    }

    public static void sort(Integer[] a){
        sort(a, 0, a.length - 1);
    }

    public static void sort(Integer[] a, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;

        Integer v = a[lo];  // 切分点
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Integer[] a, int i, int j){
        if(i < 0 || i == j || a.length == 0) return;
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
