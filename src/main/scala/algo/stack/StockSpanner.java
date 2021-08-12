package algo.stack;

import java.util.Stack;

public class StockSpanner {
    Stack<Pair> stk;
    int count=0;
    public StockSpanner(){
        stk = new Stack<>();
    }
    public int next(int price){
        int res;
        while (!stk.isEmpty() && stk.peek().value<=price){
            stk.pop();
        }
        if(stk.isEmpty()){
            res = count+1;
        } else {
            res = count- stk.peek().index;
        }
        stk.push(new Pair(count++,price));
        return res;
    }

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));
    }
}
class Pair {
    int index;
    int value;
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
