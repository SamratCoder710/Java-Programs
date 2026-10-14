package sanam.greedy;

public class MaximizeSumOfSquaresOfDigit {

    static void main() {
        MaximizeSumOfSquaresOfDigit maximizeSumOfSquaresOfDigit = new MaximizeSumOfSquaresOfDigit();
        String result = maximizeSumOfSquaresOfDigit.maxSumOfSquares(2,17);
        System.out.println(result);
    }

    public String maxSumOfSquaresShortSolution(int num, int sum) {
        if(sum > 9 * num) return "";
        StringBuilder sb = new StringBuilder();
        while(num-- > 0){
            int digit = Math.min(sum,9);
            sb.append(digit);
            sum -= digit;
        }
        return sb.toString();
    }

        public String maxSumOfSquares(int num, int sum) {
            StringBuilder sb = new StringBuilder();
            while(sum > 0){
                int digit = Math.min(sum,9);
                sb.append(digit);
                sum -= digit;
                if(sb.length() > num){
                    return "";
                }
            }

            int addZeroes = num - sb.length();
            while(addZeroes > 0){
                sb.append('0');
                addZeroes--;
            }
            return sb.toString();
        }
}
