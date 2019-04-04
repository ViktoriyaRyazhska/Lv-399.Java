package dynamicProgramming;

public class TwoHundred {
    static int[] iArr = new int[100];

    public static void main(String[] args) {
        int iVol = 5;
        currSlag(iVol, iVol, 0);
    }

    static void currSlag(int n, int k, int i) {

        if ( n < 0 || k < 0 ) return;
        if ( n == 0 ) {
            for (int j = 0; j < i; j++) System.out.print(iArr[j] + " ");
            System.out.println();
        }
        else {
            if ( n >= k) {
                iArr[i] = k;
                currSlag(n - k, k - 1, i + 1);
            }
            if ( k > 1) currSlag(n, k - 1, i);
        }
    }
}