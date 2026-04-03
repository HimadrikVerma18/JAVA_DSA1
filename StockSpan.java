import java.util.*;
class StockSpan {
    int[] stockSpan(int[] price){
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && price[s.peek()] <= price[i]){
                s.pop();
            }
            span[i] = s.isEmpty() ? i+1 : i - s.peek();
            s.push(i);
        }
        return span;
    }
}