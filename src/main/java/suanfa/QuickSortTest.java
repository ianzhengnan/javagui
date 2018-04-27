package suanfa;


public class QuickSortTest {

    public static void main(String[] args) {
        Integer[] testArray = {3, 1, 45, 8, 9, 5, 6};
        sort(testArray);
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
    }

    public static void sort(Integer[] a){

        sort(a, 0, a.length -1);
    }

    public static void sort(Integer[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int i = partition(a, lo, hi);
        sort(a, lo, i - 1);
        sort(a, i + 1, hi);
    }

    public static int partition(Integer[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Integer v = a[lo];   // 切分元素
        while (true){
            while(less(a[++i], v)) if(i == hi) break;
            while (less(v, a[--j])) if(j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Integer a, Integer b){
        if (a < b)
            return true;
        else
            return false;
    }

    private static void exch(Integer[] a, int i, int j){
        if(i < 0 || i == j || a.length == 0) return;
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
