package demo;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String aa = "9223372036854775808";
		// System.out.println(myAtoi(aa));
		// reverse(12321);
		System.out.println(isPalindrome(131));

	}

	public static int myAtoi(String str) {
		String tem = "";
		if (str == null || (tem = str.trim()).length() == 0) {
			return 0;
		}
		int len = tem.length();
		// ��һ���ַ�����+��-�����֣���˵����������
		char fc = tem.charAt(0);
		// �ж��ܹ��ж��ٸ���Ч�ַ����ӵڶ����ַ���ʼ�ܹ��ж��ٸ�0
		int t = len; // �ܹ��ж��ٸ���Ч���ַ���
		int k = 1; // ����0�����index
		for (int i = 1; i < len; i++) {
			char tc = tem.charAt(i);
			if (tc < '0' || tc > '9') {
				t = i;
				break;
			}
			if (tc == '0' && k == i) {
				k++;
			}
		}

		if (k == t && (fc == '-' || fc == '+' || fc == '0')) { // �����Ч����ȫ��0
			return 0;
		}
		String r = "";
		if (fc == '-') { // ���Ϊ-
			r = "-" + tem.substring(k, t);
		} else if (fc == '+') {// ��һ���ַ�Ϊ+
			r = tem.substring(k, t);
		} else if (fc == '0') {
			r = tem.substring(k, t);
		} else if (fc >= '0' && fc <= '9') {// ��һ���ַ�Ϊ����
			r = tem.substring(0, t);
		} else {
			return 0;
		}

		return checkStr(fc, r);
	}

	public static int checkStr(char c, String str) {
		if (str.length() > 11 && c == '-') {
			return -1 << 31;
		} else if (str.length() > 11 && c != '-') {
			return (1 << 31) - 1;
		}
		long lo = Long.parseLong(str);
		if (lo >= (1 << 31) - 1) {
			return (1 << 31) - 1;
		} else if (lo <= -1 << 31) {
			return -1 << 31;
		} else {
			return (int) lo;
		}
	}

	public static void reverse(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
			System.out.println(result);
		}
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}

		return result == x;
	}
}
