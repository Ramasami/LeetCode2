public class CheckIfABeforeB {
    public boolean checkString(String s) {
        boolean b = false;
        for (char c : s.toCharArray()) {
            if (c == 'b')
                b = true;
            else if (b)
                return false;
        }
        return true;
    }
}