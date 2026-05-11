class Solution {
    public String decodeString(String s) {

        StringBuilder curr = new StringBuilder();
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> strStack = new java.util.Stack<>();

        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                strStack.push(curr);

                curr = new StringBuilder();
                num = 0;
            }

            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();

                while (repeat-- > 0) {
                    prev.append(curr);
                }

                curr = prev;
            }

            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}