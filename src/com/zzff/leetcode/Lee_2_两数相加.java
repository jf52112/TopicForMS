package com.zzff.leetcode;
//https://leetcode.cn/problems/add-two-numbers/

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class Lee_2_两数相加 {
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);//243  564   \\   249 5649=>70401  987 23 =>128
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        while (pre.next!=null){
            System.out.println("addTwoNumbers2=>"+pre.val);
            pre=pre.next;
        }
        System.out.println("addTwoNumbers2=>"+pre.val);
        return pre.next;
    }

    public static ListNode addTwoNumbers(ListNode k1, ListNode k2) {
        System.out.println(k1+"=="+k2);
        ListNode k1copy=k1;
        ListNode k2copy=k2;
        String k1Str="";
        String k2Str="";
        boolean flag=true;
        boolean flag2=true;
        do{
            if(k2copy.next!=null){
                k2Str=k2Str+k2copy.val;
                k2copy=k2copy.next;
            }
            if(k2copy.next==null&&flag2){

                if(!flag2){
                    k2Str=k2Str+0;
                }else {
                    k2Str=k2Str+k2copy.val;
                    flag2=false;
                }
            }
            if(k1copy.next!=null){
                k1Str=k1Str+k1copy.val;
                k1copy=k1copy.next;
            }
            if(k1copy.next==null){
                if(!flag){
                    k1Str=k1Str+0;
                }else {
                    k1Str=k1Str+k1copy.val;
                    flag=false;
                }

            }
        }while (k1copy.next!=null||k2copy.next!=null);
        k1Str=new StringBuilder(k1Str).reverse().toString();
        k2Str=new StringBuilder(k2Str).reverse().toString();
        BigDecimal bg1=new BigDecimal(k1Str);
        BigDecimal bg2=new BigDecimal(k2Str);
        BigDecimal add=bg1.add(bg2);
        //807=>708
        //List<String> asList = Arrays.asList(add.toString());
        char[] chars = add.toString().toCharArray();
        byte[] bytes = add.toString().getBytes();
        ListNode result=new ListNode();
        ListNode temp=new ListNode();
//        ListNode temp=new ListNode();
        for (int i = chars.length-1; i>=0; i--) {
            ListNode temp2=new ListNode(chars[i]-48);
            if(i==chars.length-1){
                result=temp=temp2;
            }else{
                temp.next=temp2;
                temp=temp2;
            }
        }
        System.out.println(result);
        while (result.next!=null){
            System.out.println(result.val);
            result=result.next;
        }System.out.println(result.val);
        return result;
    }

    public static void main(String[] args) {
        /*ListNode k11=new ListNode(2);
        ListNode k12=new ListNode(4);
        ListNode k13=new ListNode(3);
        k11.next=k12;
        k12.next=k13;
        ListNode k21=new ListNode(5);
        ListNode k22=new ListNode(6);
        ListNode k23=new ListNode(4);
        k21.next=k22;
        k22.next=k23;
        addTwoNumbers(k11,k21);
        addTwoNumbers2(k11,k21);*/
        ListNode k11=new ListNode(9);
        ListNode k12=new ListNode(8);
        ListNode k13=new ListNode(7);
        k11.next=k12;
        k12.next=k13;
        ListNode k21=new ListNode(2);
        ListNode k22=new ListNode(3);
        k21.next=k22;
        addTwoNumbers(k11,k21);
        addTwoNumbers2(k11,k21);
        System.out.println("hotfix添加");
        /*ListNode a=new ListNode(9);
        ListNode b=new ListNode(9);
        ListNode c=new ListNode(9);
        ListNode d=new ListNode(9);
        ListNode e=new ListNode(9);
        ListNode f=new ListNode(9);
        ListNode g=new ListNode(9);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        ListNode h=new ListNode(9);
        ListNode i=new ListNode(9);
        ListNode j=new ListNode(9);
        ListNode k=new ListNode(9);
        h.next=i;
        i.next=j;
        j.next=k;
        addTwoNumbers(a,h);*/

       /* ListNode b=new ListNode(2);
        ListNode c=new ListNode(4);
        ListNode d=new ListNode(9);
        b.next=c;
        c.next=d;
        ListNode e=new ListNode(5);
        ListNode f=new ListNode(6);
        ListNode g=new ListNode(4);
        ListNode h=new ListNode(9);
        e.next=f;
        f.next=g;
        g.next=h;
        addTwoNumbers(b,e);*/
        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]

//        BigDecimal b=new BigDecimal("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
//        BigDecimal a=new BigDecimal("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    }

}

/**
 * Definition for singly-linked list.
 * */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val)
     {
         this.val = val;
     }
     ListNode(int val, ListNode next)
     {
         this.val = val; this.next = next;
     }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
