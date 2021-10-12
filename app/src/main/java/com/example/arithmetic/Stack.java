package com.example.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ================================================
 * 类名：com.example.arithmetic
 * 时间：2021/10/11 16:01
 * 描述：栈操作的算法示例
 * 修改人：
 * 修改时间：
 * 修改备注：
 * ================================================
 *
 * @author Admin
 */
public class Stack {

    /**
     * @author Admin
     * @date 2021/10/11 16:08
     * https://leetcode-cn.com/problems/valid-parentheses/
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 栈与"括号序列"
     * "最近相关性"
     */

    public static boolean isValid(String s) {
        //因为成对的括号，存在先进做括号，后出右括号的规则，
        // 所以遇到左括号就进栈，遇到右括号就出栈并且校验，直到最后都抵消为空
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                //访问前需要判断stack是否为空
                if (stack.isEmpty() || map.get(stack.removeLast()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * @author Admin
     * @date 2021/10/11 16:24
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
     * 150. 逆波兰表达式求值
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 说明：
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     */

    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }


}
