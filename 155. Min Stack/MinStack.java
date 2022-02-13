import java.util.Stack;
import javafx.util.Pair;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Pair<Integer, Integer>> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek().getValue()) {
            minStack.push(new Pair<>(stack.size(), val));
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.pop();
            if (stack.size() < minStack.peek().getKey())
                minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek().getValue();
    }
}
