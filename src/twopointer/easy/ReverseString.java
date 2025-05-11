package twopointer.easy;

public class ReverseString {
	public void reverseString(char[] s) {

		if(s.length <= 0) return;

		int left = 0;
		int right = s.length - 1;

		while(left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
		for(char c: s) {
			System.out.print(c);
		}
	}

	public static void main(String[] args) {
		ReverseString ob = new ReverseString();
		char[] s = {'h','e', 'l','l','o'};

		ob.reverseString(s);
	}

}
