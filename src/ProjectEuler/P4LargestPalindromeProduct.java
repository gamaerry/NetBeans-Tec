package ProjectEuler;

public class P4LargestPalindromeProduct {
    public static void main(String[] args) {
        int palindromo = 0;
        boolean palindromoEncontrado = false;
        for (int i = 999; i > 99; i--){
            for (int j = i; j > 99 && !palindromoEncontrado; j--) {
                palindromoEncontrado = esPalindromo(i*j);
                if (palindromoEncontrado && j*i >palindromo)
                    palindromo =i*j;
            }
            palindromoEncontrado = false;
        }
        System.out.println(palindromo);
    }
    static boolean esPalindromo(int n) {
        String s = n + "";
        for (int i = 0; i < s.length()/2; i++) 
            if (!(s.charAt(i) == s.charAt(s.length() - (i+1))))
                return false;
        return true;
    }
}