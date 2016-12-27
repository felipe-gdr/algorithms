package hackerrank.cracking.code.interview;

public class BinaryStringOperations {
    BinaryStringOperations(String string, Integer integer){
        String binaryInteger = Integer.toBinaryString(integer);
        
        for( byte b : string.getBytes() ){
            // Perform a bitwise operation using byte and integer operands, save result as tmp:
            int tmp = b | integer; 
            System.out.println( Integer.toBinaryString(b) + " OR " + binaryInteger 
                + " = " + Integer.toBinaryString(tmp) + " = " + tmp );
        }
    }
    
    public static void main(String[] args) {
        new BinaryStringOperations("HackerRank", 8675309);
    }
}
