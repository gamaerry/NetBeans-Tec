package ProjectEuler;
public class SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        int[] t = terna();
        System.out.println(t[0]*t[1]*t[2]);
    }
    static int[] terna(){
        for (int i = 1; i < 998; i++)
            for (int j = 1; j < 998; j++) 
                for (int k = 1; k < 998; k++) 
                    if (i*i+j*j==k*k && i+j+k==1000)
                        return new int[]{i,j,k};
        return null;
    }
}
