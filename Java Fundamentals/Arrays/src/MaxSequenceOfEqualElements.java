import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] array = scan.nextLine().split(" ");
        int longestSeqCount = 0;
        String sequence = "";
        for (int fi = 0; fi < array.length; fi++){
            int currentSeqCount = 0;
            String currentSequence = "";
            for (int ci = fi; ci < array.length; ci++) {
                if(array[ci].equals(array[fi])){
                    currentSeqCount++;
                    currentSequence = currentSequence.concat(array[ci] + " ");
                }else{
                    break;
                }
            }
            if(currentSeqCount > longestSeqCount){
                longestSeqCount = currentSeqCount;
                sequence = currentSequence;
            }
        }
        System.out.println(sequence);
    }
}
