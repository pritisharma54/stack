class StockSpanner {
     Stack<Pair> stack;
     int count=0;
    
    class Pair{
        int number;
        int index;
        
        Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    public StockSpanner() {
         stack = new Stack<>();
    }
    
    public int next(int price) {
        count++;
        while(stack.size()>0 && stack.peek().number<=price){
            stack.pop();
        }

        int req = 0;
        if(stack.size()>0){
            req = count - stack.peek().index;
        }else{
            req = count;
        }
        stack.push(new Pair(price, count));
        return req;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

