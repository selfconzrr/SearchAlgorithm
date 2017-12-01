import java.util.ArrayList;

public class blockSearch {

	private int[] index; // 建立索引
	private ArrayList[] list;

	public blockSearch(int[] index) {
		if (index != null && index.length != 0) {
			this.index = index;
			this.list = new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList();// 初始化三个容器
			}
		} else {
			throw new Error("index cannot be null or empty");
		}
	}

	/**
	 * 插入元素
	 */
	public void insert(int value) {
		int i = binarysearch(value);// 二分查找确定插入哪个块
		list[i].add(value);// 将元素插入到对应的块
	}

	/**
	 * 二分查找
	 */
	private int binarysearch(int value) {
		int start = 0;
		int end = index.length;
		int mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (index[mid] > value) {
				end = mid - 1;
			} else {
				start = mid + 1;// 如果相等，也插入后面
			}
		}
		return start;
	}

	/**
	 * 查找元素
	 */
	public boolean search(int data) {
		int i = binarysearch(data);// 先二分查找确定在哪个块
		for (int j = 0; j < list[i].size(); j++) {// 然后顺序查找在该块内哪个位置
			if (data == (int) list[i].get(j)) {
				System.out.println(String.format("查找元素为  %d 第: %d块  第%d个 元素",
						data, i + 1, j + 1));
				return true;
			}
		}
		return false;
	}

	/**
	 * 打印每块元素
	 */
	public void printAll() {
		for (int i = 0; i < list.length; i++) {
			ArrayList l = list[i];
			System.out.print("ArrayList" + i + ":");
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j) + "  ");
			}
			System.out.println();
		}
	}

	public static void test() {
		int[] index = { 10, 20, 30 };// 以该数组里的值作为分块的标准
		blockSearch blocksearch = new blockSearch(index);
		blocksearch.insert(1);
		blocksearch.insert(12);
		blocksearch.insert(22);

		blocksearch.insert(10);
		blocksearch.insert(18);
		blocksearch.insert(23);

		blocksearch.insert(5);
		blocksearch.insert(15);
		blocksearch.insert(27);

		blocksearch.printAll();

		System.out.println(blocksearch.search(18));
		System.out.println(blocksearch.search(29));
	}
}
