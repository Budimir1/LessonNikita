package Test;

import java.util.function.IntUnaryOperator;

public class ComplexMath {
    public static int complex_math(int n, int x, int y) {
        // базовые операции
        int add = x + y;
        int sub = x - y;
        int mul = x * y;

        // защита от деления на ноль
        double div = y != 0 ? (double) x / y : 0;

        // степень
        double power = Math.pow(x, 2) + Math.pow(y, 3);

        // факториал
        IntUnaryOperator factorial = new IntUnaryOperator() {
            public int applyAsInt(int k) {
                if (k <= 1)
                    return 1;
                return k * applyAsInt(k - 1);
            }
        };
        int fact = factorial.applyAsInt(n);

        // фибоначчи
        IntUnaryOperator fibonacci = new IntUnaryOperator() {
            public int applyAsInt(int k) {
                if (k <= 1)
                    return k;
                return applyAsInt(k - 1) + applyAsInt(k - 2);
            }
        };
        int fib = fibonacci.applyAsInt(n);

        // итоговая формула
        double result = add + sub + mul + div + power + fact + fib;

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(complex_math(5, 3, 2));
    }
}

//import java.util.Stack;
//
//class Test{
//    public class ListNode{
//        int val;
//         ListNode next;
//         ListNode() {}
//         ListNode(int val) {
//             this.val = val;
//         }
//         ListNode(int val, ListNode next) {
//             this.val = val;
//             this.next = next;
//         }
//    }
////    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
////        Stack<Character> stack = new Stack<>();
////// стек мап и лист
////
////    }
//
//
//
//
//    public static void main(String[] args) {
//        String strs = "([{}])";
//
//    }
//}

//    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for (char c: s.toCharArray()) {
//
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
//                stack.pop();
//            }else if (c == ']' && !stack.empty() && stack.peek() == '[') {
//                stack.pop();
//            }else if (c == '}' && !stack.empty() && stack.peek() == '{') {
//                stack.pop();
//            }
//            else return false;
//        }
//        return stack.isEmpty();
//    }

//    public static String longestCommonPrefix(String[] strs) {
//        for (int i = 0; i < strs[0].length(); i++){
//            char current = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++){
//                if (i == strs[j].length() || strs[j].charAt(i) != current){
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }
//public class Solution {
//    public int findEquilibriumIndex(int[] nums) {
//
//    left
//    for
//    left +=nums[i]
//    riht = total - left -  nums[i];
//
//    }
//}
//[1,3,5,7,4,3,6,4,6,4,3,6,4]
//[1, 2, 3, 4, 3, 2, 1]
//public class Test {
//    public static void main(String[] args) {
//        int num = 17;
//        boolean isPrime = true;
//        if (num <= 1) {
//            isPrime = false;
//        } else {
//            for (int i = 2; i <= Math.sqrt(num); i++) {
//                if (num % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//        System.out.println(num + " простое? " + isPrime);
//    }
//}
//
//
//
//public class Test {
//    public static void main(String[] args) {
//        int n = 5;
//        int result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        System.out.println(n + "! = " + result);
//    }
//}


//public class Test {
//    public static void main(String[] args) {
//        int[] numbers = {3, 7, 2, 9, 5};
//        int max = numbers[0];
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i] > max) {
//                max = numbers[i];
//            }
//        }
//        System.out.println("Максимальный элемент: " + max);
//    }
//}

//
//import java.util.Scanner;
//
///**
// * (2 * n) -1 = n * n;
// * n = 1 -> ((2 * 2) - 1) = 4
// * k = 1;
// * k = 4;
// * k = 9;
// */
//public class Test {
//    public static int n;
//    public static int k = 1;
//    public static Scanner I = new Scanner(System.in);
//    public static void matAlg(){
//
//        if (k == n){
//            System.out.println("Доказательство выполнено: " + k + "=" + n);
//        }else{
//            for (int i = 0; i < n; i++) {
//                k = k + ((2 * n) - 1);
//            }
//            n = n * n;
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("Введите число");
//        n = I.nextInt();
//        while (k == n){
//            matAlg();
//        }
//    }
//}
//import java.util.Scanner;
//
//public class Test {
//    public static Scanner E = new Scanner(System.in);
//    public static int m;
//    public static int n;
//    public static int r;
//
//    public static void E0() {
//        if (m < n) {
//            int t;
//            t = m;
//            m = n;
//            n = t;
//        }
//    }
//
//    public static void E1() {
//        r = m % n;
//    }
//
//        public static void E3() {
//        m = n;
//        n = r;
//    }
//
//    public static void main(String[] args) {
//        System.out.print("Введите первое число: ");
//        m = E.nextInt();
//        System.out.print("Введите второе число: ");
//        n = E.nextInt();
//
//        E0();
//        E1();
//        while (r != 0){
//            E3();
//            E1();
//        }
//        System.out.println("Общий делитель: " + n);
//    }
//}


//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class Test extends JFrame {
//
//    private JTextField textField;
//
//    public Test() {
//        super("Test");
//        createGUI();
//    }
//
//    public void createGUI() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//
//        JButton button1 = new JButton("Button 1");
//        button1.setActionCommand("Button 1 was pressed!");
//        panel.add(button1);
//
//        JButton button2 = new JButton("Button 2");
//        button2.setActionCommand("Button 2 was pressed!");
//        panel.add(button2);
//
//        JButton button3 = new JButton("Button 3");
//        button3.setActionCommand("Button 3 was pressed!");
//        panel.add(button3);
//
//        textField = new JTextField();
//        textField.setColumns(23);
//        panel.add(textField);
//
//        ActionListener actionListener = new TestActionListener();
//
//        button1.addActionListener(actionListener);
//        button2.addActionListener(actionListener);
//
//        button3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                textField.setText(e.getActionCommand());
//            }
//        });
//
//        getContentPane().add(panel);
//        setPreferredSize(new Dimension(320, 100));
//    }
//
//    public class TestActionListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            textField.setText(e.getActionCommand());
//        }
//    }
//
//    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                JFrame.setDefaultLookAndFeelDecorated(true);
//                Test frame = new Test();
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//    }
//}

//import java.io.BufferedReader;
//        import java.io.BufferedWriter;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.OutputStreamWriter;
//        import java.util.HashMap;
//
//public class Main {
//
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        HashMap<String, String> word = new HashMap<>();
//
//        int countWord = Integer.parseInt(reader.readLine());
//
//        for (int i = 0; i < countWord; i++) {
//            String line = reader.readLine();
//            String[] parts = line.split(" ");
//            word.put(parts[0], parts[ 1]);
//            word.put(parts[1], parts[0]);
//        }
//        String query = reader.readLine();
//        String synonym = word.get(query);
//        writer.write(synonym);
//        writer.newLine();
//
//        reader.close();
//        writer.close();
//    }
//}



