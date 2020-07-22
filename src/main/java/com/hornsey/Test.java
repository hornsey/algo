package com.hornsey;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.hornsey.effectivejava.chapter2.PhoneNumber;
import lombok.val;
import org.ipanda.common.utils.serialize.JsonHelper;
import org.omg.CORBA.Object;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huangtao
 * @date 2020/6/9
 */
public class Test {
	public static void main(String[] args) {

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);

//		Test test = new Test();

	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		int times = n > 0 ? n : -n;
		double result = 1;
		Map<Integer, Double> map = new HashMap<>(33);
		int res = 0;
		map.put(0, x);

		for (int i = 0; i < 32; i++) {
			res = times % 2;
			if (map.get(i) == null) {
				double tmp = map.get(i-1);
				map.put(i, tmp*tmp);
			}
			if (res == 1) {
				result *= map.get(i);
			}
			times = times >> 1;
			if (times == 0) {
				break;
			}
		}
		if (n < 0) {
			result = 1/result;
		}
		return result;
	}


	void test() {
//		[-2147483648,null,2147483647]
		TreeNode root = new TreeNode(-2147483648);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2147483647);
		root.left = null;
		root.right = right;
 		System.out.println(isValidBST(root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int len = q.size();
			List<Integer> sub = new ArrayList<>(len);
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				sub.add(node.val);

				if (node.left != null) {
					q.offer(node.left);
				}

				if (node.right != null) {
					q.offer(node.right);
				}
			}
			result.add(sub);
		}
		return result;
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		inOrderBST(queue, root);
		int min = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			if (queue.peek().val < min) {
				return false;
			}
			min = queue.poll().val;
		}
		return true;
	}

	public void inOrderBST(Queue<TreeNode> queue, TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderBST(queue, root.left);
		queue.offer(root);
		inOrderBST(queue, root.right);
	}

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int[][][] dp = new int[2][k+1][2];
		dp[0][0][1] = -prices[0];
		for (int i = 1; i < k; i++) {
			dp[0][i][1] = Integer.MIN_VALUE;
		}

		for (int i = 1; i < n; i++) {
			int cur = i & 1;
			int prev = (i-1) & 1;
			dp[cur][0][1] = Math.max(dp[prev][0][1], -prices[i]);
			for (int j = 1; j <= k; j++) {
				dp[cur][j][0] = Math.max(dp[prev][j][0], dp[prev][j-1][1] + prices[i]);
				dp[cur][j][1] = Math.max(dp[prev][j][1], dp[prev][j][0] - prices[i]);
			}
		}

		int result = 0;
		for (int i = 0; i <= k; i++) {
			int last = (n-1) & 1;
			if (dp[last][i][0] > result) {
				result = dp[last][i][0];
			}
		}
		return result;

	}

	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		int subLen = 0;
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		int[] valid = new int[len];
		Character tmp;
		for (int i = 0; i < len; i++) {
			tmp = s.charAt(i);
			if (tmp == '(') {
				stack.push(i);
			} else if (!stack.isEmpty()){
				valid[stack.pop()] = 1;
				valid[i] = 1;
			}

		}
		for (int i = 0; i < len; i++) {
			if (valid[i] == 1) {
				subLen += 1;
			} else {
				if (subLen > result) {
					result = subLen;
				}
				subLen = 0;
			}
		}
		return result;

	}

	public int maxProfit(int[] prices) {

		int n = prices.length;
		if (n < 2) {
			return 0;
		}

		int[][][] dp = new int[n][3][2];
		dp[0][0][0] = 0;
		dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;


		for (int i = 1; i < n; i++) {
			dp[i][0][1] = Math.max(dp[i-1][0][1], -prices[i]);
			for (int j = 1; j <= 2; j++) {
				dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
			}
		}
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if (dp[n-1][i][0] > result) {
				result = dp[n-1][i][0];
			}
		}
		return result;
	}

	public int maxProfit2(int[] prices) {

		int n = prices.length;
		if (n < 2) {
			return 0;
		}

		int[][][] dp = new int[n][3][2];
		dp[0][0][0] = 0;
		dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;


		for (int i = 1; i < n; i++) {
			dp[i][0][1] = Math.max(dp[i-1][0][1], -prices[i]);
			dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1] + prices[i]);
			dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0] - prices[i]);
			dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][1] + prices[i]);
			dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][2][0] - prices[i]);

		}
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if (dp[n-1][i][0] > result) {
				result = dp[n-1][i][0];
			}
		}
		return result;
	}

	public int minSubArrayLen(int s, int[] nums) {
		Queue<Integer> q = new LinkedList<Integer>();
		int sum = 0;
		int len = 0;
		int result = nums.length;

		for (int i = 0; i < nums.length; i++) {
			q.offer(nums[i]);
			sum += nums[i];
			len += 1;
			while (!q.isEmpty() && sum - q.peek() > s) {
				sum -= q.peek();
				len -= 1;
				q.poll();
			}
			if (sum > s && len < result) {
				result = len;
			}
		}
		return result;
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>(nums2.length);
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[nums1.length];

		for (int i = 0; i < nums2.length; i++) {
			int n = nums2[i];
			while (!stack.isEmpty()) {
				if (stack.peek() < n) {
					map.put(stack.pop(), n);
					continue;
				}
				break;
			}
			stack.push(n);
		}

		for (int i = 0; i < nums1.length; i++) {
			int n = nums1[i];
			result[i] = map.getOrDefault(n, -1);
		}
		return result;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

		TreeNode l, r;
		while (!queue.isEmpty()) {
			l = queue.poll();
			r = queue.poll();

			if (l == null && r == null) {
				continue;
			}

			if (l == null || r == null || (l.val != r.val)) {
				return false;
			}

			queue.offer(l.left);
			queue.offer(r.right);
			queue.offer(l.right);
			queue.offer(r.left);
		}

		return true;

	}

	public boolean isAnagram(String s, String t) {
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a, b);

	}

	void bitOp() {
		int x = 8;
		boolean result = (x & 1) == 0;
		System.out.println(result);

		/**
		 * 清零最低位的1
		 */
		int y = x & (x - 1);
		System.out.println(y);

		/**
		 * 得到最低位的1
		 */
		int z = x & (-x);
		System.out.println(z);
	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack();
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || map.get(stack.pop()) != ch) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

//	public boolean isAnagram(String s, String t) {
//		char [] a = s.toCharArray();
//		char [] b = t.toCharArray();
//		Arrays.sort(a);
//		Arrays.sort(b);
//		String na = new String(a);
//		String nb = new String(b);
//
//		return na.equals(nb);
//	}
}
