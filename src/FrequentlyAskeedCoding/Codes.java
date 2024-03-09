package FrequentlyAskeedCoding;

public class Codes {




    public static void feboNacci() {
        int n1 = 0, n2 = 1,sum=0;

        System.out.print(n1+"  "+n2);

       while(n1<50) {
           sum = n1 + n2;
           System.out.print(" " + sum);
           n2 = n1;
           n1 = sum;
       }
    }

    public static void main(String args[]){
        feboNacci();
    }
}
