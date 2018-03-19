
public class AllSequenceChar {

	public static void permutation(char[] s,int from,int to) {
        if(to <= 1)
            return;
        if(from == to) {
            System.out.println(s);
        } else {
    
            for(int i=from; i<=to; i++) {
            	if(isNeedSwap(s,from,i)){
            		swap(s,i,from); //交换前缀，使其产生下一个前缀
                    permutation(s, from+1, to);
                    swap(s,from,i); //将前缀换回，继续做上一个前缀的排列
            	}
            }
        }
    }

	/*
	 * 由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换 了。
	 * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。但是对bab，第二个数和第三个数不 同，则需要交换，
	 * 得到bba。由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
	 * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
	 * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
	 */
    private static boolean isNeedSwap(char[] s, int from, int k) {
    	boolean flag = true;
    	for (int i = from; i < k; i ++) {
    		if (s[i] == s[k]) {
    			flag = false;
    			break;
    			}
    		}
		return flag;
	}

	public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'a','b','b'};
        permutation(s, 0, 2);
    }
}
