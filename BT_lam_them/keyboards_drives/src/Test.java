public class Test {
    public static void main(String[] args) {
        int[] keyboards = {40, 50, 60};
        int[] drives = {5, 8, 12};
        int b = 58;
        System.out.println(getMoneySpent(keyboards, drives, b));

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int sum = 0;
        int max = keyboards[0] + drives[0];
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                sum = keyboards[i] + drives[j];
                if (max < sum && sum <= b) {
                    max = sum;
                }
            }
        }
        if (max <= b) {
            return max;
        } else {
            return -1;
        }
    }

//    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
//        int max = 0;
//        int min = keyboards[0] + drives[0];
//        for (int i = 0; i < keyboards.length; i++) {
//            for (int j = 0; j < drives.length; j++) {
//                int sum = keyboards[i] + drives[j];
//                if (sum <= b && sum >= max) {
//                    max = sum;
//                }
//                if (sum <= min) {
//                    min = sum;
//                }
//            }
//        }
//        if (b < min) {
//            return -1;
//        } else {
//            return max;
//        }
//    }
}
