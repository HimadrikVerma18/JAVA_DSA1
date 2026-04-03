import java.util.*;
class SlidingWindow {
    int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int j=0;

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[j++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}