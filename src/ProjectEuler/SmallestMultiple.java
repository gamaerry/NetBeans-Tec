package ProjectEuler;

public class SmallestMultiple {
    public static void main(String[] args) {
        int n = 20;
        int producto = 2;
        for (int i = 3, j = 2, actual = i; i <= n; i++, j = 2, actual = i) 
            do while (actual % j == 0) {
                    if (producto % actual != 0)
                        producto *= j;
                    actual /= j;
                }
            while (++j <= i);
        System.out.println(producto);
    }
}
