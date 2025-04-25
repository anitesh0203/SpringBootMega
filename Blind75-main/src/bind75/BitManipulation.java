package bind75;

public class BitManipulation {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {

            int carry = 1&n;
            n>>=1;
            n = n&carry;
        }
        return n;

    }

    public static void main(String[] args) {
        BitManipulation bitManipulation = new BitManipulation();
        int ans = bitManipulation.reverseBits(01001);
        System.out.println(ans);
    }
}
