import java.util.*;
class SortStack {
    void sortStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.pop();
            sortStack(s);
            insert(s, x);
        }
    }

    void insert(Stack<Integer> s, int x){
        if(s.isEmpty() || s.peek() <= x){
            s.push(x);
            return;
        }
        int temp = s.pop();
        insert(s, x);
        s.push(temp);
    }
}