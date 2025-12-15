public class MinimumMovesToBalanceCircular {


    public static void main(String[] args) {
        //1,2,-5,2
        MinimumMovesToBalanceCircular minimumMovesToBalanceCircular = new MinimumMovesToBalanceCircular();
        int[] balance = {1,2,-5,2};
        System.out.println(minimumMovesToBalanceCircular.minMoves(balance));
    }


    public long minMoves(int[] balance) {
        int idx = -1;
        long sum = 0;
        long moves = 0;
        int n = balance.length;
        for(int i=0;i<n;i++){
            if(balance[i]<0){
                idx = i;
            }
            sum +=  balance[i];
        }
        if(idx == -1) return 0;
        if(sum < 0) return -1;
        int d = 1;

        while(balance[idx] < 0){
            int left = (idx - d + n)%n;
            int right = (idx +d)%n;

            long total = balance[left] + balance[right];
            if(left == right){
                total -= balance[left];
            }

            long taken = Math.min(-balance[idx], total);
            long remaining = balance[idx] + taken;
            balance[idx] = (int) remaining;
            moves += (taken * d);
            d++;
        }

        return moves;
    }


}
