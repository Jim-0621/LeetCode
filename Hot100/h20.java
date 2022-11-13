package Hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
// import java.util.Stack;

public class h20 {
    public static void main(String[] args) {
        String s = "(){}";
        boolean flag =  new Solution20().isValid(s);
        System.out.println(flag);
    }
}

class Solution20 {
    // java中单引号里面只能放一个字母或数字或符号;java中的双引号里面是0到多个字符构成。
    // 建立哈希表 dic 构建左右括号对应关系
    // ?是为了防止栈为空时.pop()操作报错
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        // .charAt(index) Returns the character (Unicode code point) at the specified index
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        // ?是为了防止链表为空时.removeLast()操作报错，与上同理
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            // .addLast(key) 把key添加到链表尾部
            if(map.containsKey(c)) stack.addLast(c);
            // .removeLast() Returns:the last element from this list
            // 字符可以==，字符串得用.equals()
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}


/*
// 这个版本和自己写的差不多，只使用到了栈，但用的更加灵活。
// 其实看自己代码的时候也能发现的，后面四个条件太冗余了，都返回false，想着怎么解决冗余，也许就能想到前面入栈的时候入右括号。
// for(char c:s.toCharArray()) 这个用法之前我也是没有用过的。定义一个遍历字符c，让它分别等于字符串数组s里面的各个字符。
public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }
 */

/*
// 自己写的版本
// java中字符串的比较需要用到.equals()，不能用==
// 栈的基本操作：push() 压入栈中； pop() 弹出栈顶元素； peep() 显示栈顶元素（不弹出）
// 截取字符串.subString(beginIndex,endIndex)
class Solution20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        stack.push("di");
        for (int i = 0; i < s.length(); i++) {
            String kh = s.substring(i,i+1);
            if(kh.equals("(") || kh.equals("[") || kh.equals("{")){
                stack.push(kh);
            }else if(kh.equals(")")){
                if(!stack.pop().equals("(")) return false;
            }else if(kh.equals("]")){
                if(!stack.pop().equals("[")) return false;
            }else if(kh.equals("}")){
                if(!stack.pop().equals("{")) return false;
            }else {
                return false;
            }
        }
        stack.pop();
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
 */

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false


提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */