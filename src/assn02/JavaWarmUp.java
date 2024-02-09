package assn02;
import java.util.Scanner;

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        String date[] = new String[n];
        String time1[] = new String[n];
        String category[] = new String[n];
        double fee[] = new double[n];
        int quantity[] = new int[n];
        double time2[] = new double[n];
        double asmCost[] = new double[n];

        for (int i = 0; i < n; i++) {
            date[i] = s.next();
            time1[i] = s.next();
            category[i] = s.next();
            fee[i] = s.nextDouble();
            quantity[i] = s.nextInt();
            time2[i] = s.nextDouble();
            asmCost[i] = s.nextDouble();
        }

        int highestItemIndex = getMaxPriceIndex(fee);
        int lowestItemIndex = getMinPriceIndex(fee);

        System.out.println(date[highestItemIndex]);
        System.out.println(time1[highestItemIndex]);
        System.out.println(category[highestItemIndex]);
        System.out.println(fee[highestItemIndex]);

        System.out.println(date[lowestItemIndex]);
        System.out.println(time1[lowestItemIndex]);
        System.out.println(category[lowestItemIndex]);
        System.out.println(fee[lowestItemIndex]);

        int[] numOfBatchesC = new int[categoriesList.length];
        double[] totFeeC = new double[categoriesList.length];
        int[] totQuantityC = new int[categoriesList.length];
        double[] totLaborCostC = new double[categoriesList.length];
        double[] totAsmCostC = new double[categoriesList.length];

        for (int i = 0; i < n; i++) {
            int catIndex =  0;
            for (int j = 0; j < categoriesList.length; j++) {
                if (category[i].equals(categoriesList[j])) {
                    catIndex = j;
                    break;
                }
            }

            numOfBatchesC[catIndex]++;
            totFeeC[catIndex] += fee[i] * quantity[i];
            totQuantityC[catIndex] += quantity[i];
            totLaborCostC[catIndex] += time2[i] * 16;
            totAsmCostC[catIndex] += asmCost[i];
        }

        for (int j = 0; j < categoriesList.length; j++) {
            if (numOfBatchesC[j] > 0) {
                System.out.println(categoriesList[j]);
                System.out.println(totQuantityC[j]);
                System.out.printf("%.2f\n", totFeeC[j]/totQuantityC[j]);
                System.out.printf("%.2f\n",(totFeeC[j] - (totLaborCostC[j] + totAsmCostC[j])) / totQuantityC[j]);
            }
        }
    }

    static int getMaxPriceIndex(double[] priceT) {
        int maxIndex = 0;

        for (int i = 0; i < priceT.length; i++) {
            if (priceT[i] > priceT[maxIndex]) {
                maxIndex = i;
            }
        }
        return (maxIndex);
    }

    static int getMinPriceIndex(double[] priceT){
            int minIndex = 0;

            for (int i = 1; i < priceT.length; i++) {
                if (priceT[i] < priceT[minIndex]) {
                    minIndex = i;
                }
            }
            return (minIndex);
    }
}