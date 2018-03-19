public class mainSearch {

	public static int orderSearch(int arr[], int target) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == target)
				return i;
		return -1;
	}

	public static int biSearch(int arr[], int target) {
		int low = 0, high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 2,5,8,9,11,16,20,23,999,1000 };
		System.out.println("顺序查找999" + orderSearch(array, 999));
		System.out.println("二分查找999" + biSearch(array, 999));
		blockSearch.test();
	}
}
