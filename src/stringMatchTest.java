public class stringMatchTest {
	/**
	 * @Author：ZhangRui
	 * @Purpose：For learning string match
	 * @Date：2017/05/14
	 * @Email：1138517609@qq.com
	 * @Blog：http://blog.csdn.net/u011489043
	 * @GitHub：https://github.com/selfcon
	 */
	
	//BF（Brute Force）算法:
	public static int bfMatch(String s,String t){
		int j = 0,i = 0;
		while(i < s.length() && j < t.length()){
			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if(j == t.length())
			return i - j;
		else
			return -1;
	}
	//KMP（Knuth Morris Pratt）算法:
	public static int kmpMatch(String s,String t,int []next){
		int i = 0,j = 0;
		while(i < s.length() && j < t.length()){
			//如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++ 
			if(j == -1 || s.charAt(i) == t.charAt(j)){// 当j为-1时，要移动的是i，当然j也要归0
				i++;
				j++;
			} else {
				//如果j != -1，且当前字符匹配失败（即S[i] != T[j]），则令i不变，j = next[j]      
	            //j右移j-next[j]
				j = next[j];
			}
		}
		if(j == t.length())
			return i - j;
		else
			return -1;
	}
	//KMP算法中求解next数组。
	public static int []getKMPNext(String t){
		int [] next = new int [t.length()];
		next[0] = -1;//初始化
		int j = 0,k = -1;
		while(j < t.length() - 1){
			if(k == -1 || t.charAt(j) == t.charAt(k)){//t[k]表示前缀，t[j]表示后缀
//				if(t.charAt(j) != t.charAt(k))
//					next[j] = k;
//				else 
//					next[j] = next[k];// 当两个字符相等时要跳过
				next[++j] = ++k;// next[j + 1] = next[j] + 1 = k + 1
			} else {
				k = next[k];
			}
		}
		return next;
		
	}
	//main函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BBC ABCDAB ABCDABCDABDE";
		String t = "ABCDABD";
		System.out.println("resulr： " +bfMatch(s, t));
		System.out.println("resulr： " +kmpMatch(s, t, getKMPNext(t)));		
	}
}
