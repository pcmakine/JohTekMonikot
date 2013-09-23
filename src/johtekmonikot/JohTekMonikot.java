/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package johtekmonikot;

/**
 *
 * @author pcmakine
 */
public class JohTekMonikot {

    static char[] tilat = {'a', 'r', 's', 'b', 'k', 'l'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] tuples = new int[100000][6];

        for (int i = 0; i < tuples.length; i++) {
            tuples[i] = generateTuple();
        }

        //L = 0 ja A = 0
        System.out.println(getProbabilityofTuple(tuples, new int[]{}, new int[]{0, 5}));
        System.out.println("");


        // L = 0 ja B = 0
        System.out.println(getProbabilityofTuple(tuples, new int[]{}, new int[]{3, 5}));


        System.out.println("");

        // K = 0 ja A = 1
        System.out.println(getProbabilityofTuple(tuples, new int[]{0}, new int[]{4}));



        System.out.println("");
        // K = 0 ja B = 1 ja A = 1
        System.out.println(getProbabilityofTuple(tuples, new int[]{0, 3}, new int[]{4}));

        System.out.println("");
        System.out.println("3a");
        //3a
        getProbabilityofTuple(tuples, new int[]{0, 1, 3}, new int[]{4});
        getProbabilityofTuple(tuples, new int[]{1, 3}, new int[]{4});

        System.out.println("");

        System.out.println("3b");

        //3b
        getProbabilityofTuple(tuples, new int[]{1, 2, 3, 4}, new int[]{});
        getProbabilityofTuple(tuples, new int[]{2, 3, 1}, new int[]{});

        System.out.println("");
        System.out.println("3c");

        //3c
        getProbabilityofTuple(tuples, new int[]{2, 3, 4}, new int[]{1});
        getProbabilityofTuple(tuples, new int[]{2, 3}, new int[]{1});

    }

    public static int[] generateTuple() {
        int[] monikko = new int[6];
        int a = generateValue(0.9);
        monikko[0] = a;
        int r;
        int s;
        int b;
        int k;
        int l;

        if (a == 1) {
            r = generateValue(0.9);
        } else {
            r = 0;
        }

        monikko[1] = r;

        if (a == 1) {
            s = generateValue(0.95);
        } else {
            s = 0;
        }

        monikko[2] = s;

        b = generateValue(0.95);
        monikko[3] = b;

        if (s == 1 && b == 1) {
            k = generateValue(0.99);
        } else {
            k = 0;
        }

        monikko[4] = k;

        if (k == 1) {
            l = generateValue(0.99);
        } else {
            l = 0;
        }

        monikko[5] = l;

        return monikko;
    }

    public static double getProbabilityofTuple(int[][] tuples, int[] oneTuple, int[] zeroTuple) {
        int count = 0;
        boolean onesokay = true;
        boolean zerosokay = true;
        for (int i = 0; i < tuples.length; i++) {
            for (int j = 0; j < oneTuple.length; j++) {
                if (tuples[i][oneTuple[j]] != 1) {
                    onesokay = false;
                }
            }
            for (int j = 0; j < zeroTuple.length; j++) {
                if (tuples[i][zeroTuple[j]] != 0) {
                    zerosokay = false;
                }
            }
            if (zerosokay && onesokay) {
                count++;
            }
            zerosokay = true;
            onesokay = true;
        }
        String print = count / (tuples.length * 1.0) * 100 + " prosentissa monikoista pätee ";

        for (int i = 0; i < zeroTuple.length; i++) {
            print = print + tilat[zeroTuple[i]] + " = 0, ";
        }

        for (int i = 0; i < oneTuple.length; i++) {
            print = print + tilat[oneTuple[i]] + " = 1, ";
        }

        System.out.println(print);
        return count / (tuples.length * 1.0) * 100;
    }

    public static int generateValue(double probability) {
        if (Math.random() < probability) {
            return 1;
        } else {
            return 0;
        }
    }
}
