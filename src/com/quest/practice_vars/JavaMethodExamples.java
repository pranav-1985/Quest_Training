package com.quest.practice_vars;

public class JavaMethodExamples {

    private static final int x = 30;

    public static void main(String[] args) {


        JavaMethodExamples javaMethodExamples = new JavaMethodExamples();
        javaMethodExamples.display("hello");
        int result = javaMethodExamples.add(2, 4);
        System.out.println(result);
    }

    /**
     * display string
     *
     * @param str - name
     */
    private void display(String str) {
        System.out.println(str);
    }

    /**
     * adds two numbers
     *
     * @param a - n1
     * @param b - n2
     * @return -sum
     */
    private int add(int a, int b) {
        return a + b;
    }
}
