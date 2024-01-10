import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalcException {
        Scanner in = new Scanner(System.in);
        String stroka = in.nextLine();

        if (romanToInt(String.valueOf(stroka.charAt(0))) != 0) {
            System.out.println(romeCalc(stroka));
        } else{
            System.out.println(arabCalc(stroka));
        }
    }
    public static int romanToInt(String roman){

        String[] RomeNums = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int i = 0;i<RomeNums.length;i++){
            if (roman.equals(RomeNums[i])){
                return i+1;
            }
        }
        return 0;
    }
    public static String romeCalc(String input) throws CalcException{
        String stroka = input;
        String[] nums = stroka.split(" ");
        try {
            int num1 = romanToInt(nums[0]);
            int num2 = romanToInt(nums[2]);
            String ans = new String();
            if (num1 == 0 | num2 == 0) {
                throw new CalcException("throws Exception");
            } else if (nums.length >= 4) {
                throw new CalcException("throws Exception");
            } else if (nums[1].equals("+")) {
                return RomanNumberConverter.toRoman(num1 + num2);
            } else if (nums[1].equals("-")) {
                if (num1 < num2){
                    throw new CalcException("throws Exception");
                } else{
                    return RomanNumberConverter.toRoman(num1 - num2);
                }
            } else if (nums[1].equals("*")) {
                return RomanNumberConverter.toRoman(num1 * num2);
            } else if (nums[1].equals("/")) {
                return RomanNumberConverter.toRoman(num1 / num2);
            } else {
                throw new CalcException("throws Exception");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "throws Exception";
        }
    }
    public static String arabCalc(String input) throws CalcException{
        String stroka = input;
        String[] nums = stroka.split(" ");
        try {
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[2]);
            String ans = new String();
            if (num1 >= 11 | num2 >= 11 | num1 <= 0 | num2 <= 0) {
                throw new CalcException("throws Exception");
            } else if (nums.length >= 4) {
                throw new CalcException("throws Exception");
            } else if (nums[1].equals("+")) {
                ans = Integer.toString(num1 + num2);
                return ans;
            } else if (nums[1].equals("-")) {
                ans = Integer.toString(num1 - num2);
                return ans;
            } else if (nums[1].equals("*")) {
                ans = Integer.toString(num1 * num2);
                return ans;
            } else if (nums[1].equals("/")) {
                ans = Integer.toString(num1 / num2);
                return ans;
            } else {
                throw new CalcException("throws Exception");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "throws Exception";
        }
    }
}