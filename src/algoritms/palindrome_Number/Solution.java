package algoritms.palindrome_Number;

class Solution {
    public static boolean isPalindrome(int x) {
        String n = Integer.toString(x);
        for (int i = 0; i < n.length(); i++){
            char right = n.charAt(n.length() - i -1);
        }

        return true;
    }

    public static void main(String[] args) {
        int x = 123;
        isPalindrome(x);
    }

}