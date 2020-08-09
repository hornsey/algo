package com.hornsey.algo.leetcode;

/**
 * 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 *
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）
 *
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 *
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * 请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 *
 * @author huangtao
 * @date 2020/8/9
 */
public class Q5484Solution {
	public char findKthBit(int n, int k) {

		String sn = genSn(n);
		return sn.charAt(k-1);
	}

	private String genSn(int n) {
		if (n == 1) {
			return "0";
		}

		String snPre = "0";
		String sn = "0";
		for (int i = 2; i <= n; i++) {
			snPre = sn;
			sn = snPre + "1" + reverseInvert(snPre);
		}

		return sn;
	}

	private String reverseInvert(String s) {
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i) == '1' ? '0' : '1');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q5484Solution solution = new Q5484Solution();
		System.out.println((char)solution.findKthBit(4,11));
	}
}
