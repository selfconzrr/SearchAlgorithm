import java.util.ArrayList;

public class blockSearch {

	private int[] index; // ��������
	private ArrayList[] list;

	public blockSearch(int[] index) {
		if (index != null && index.length != 0) {
			this.index = index;
			this.list = new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList();// ��ʼ����������
			}
		} else {
			throw new Error("index cannot be null or empty");
		}
	}

	/**
	 * ����Ԫ��
	 */
	public void insert(int value) {
		int i = binarysearch(value);// ���ֲ���ȷ�������ĸ���
		list[i].add(value);// ��Ԫ�ز��뵽��Ӧ�Ŀ�
	}

	/**
	 * ���ֲ���
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
				start = mid + 1;// �����ȣ�Ҳ�������
			}
		}
		return start;
	}

	/**
	 * ����Ԫ��
	 */
	public boolean search(int data) {
		int i = binarysearch(data);// �ȶ��ֲ���ȷ�����ĸ���
		for (int j = 0; j < list[i].size(); j++) {// Ȼ��˳������ڸÿ����ĸ�λ��
			if (data == (int) list[i].get(j)) {
				System.out.println(String.format("����Ԫ��Ϊ  %d ��: %d��  ��%d�� Ԫ��",
						data, i + 1, j + 1));
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ӡÿ��Ԫ��
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
		int[] index = { 10, 20, 30 };// �Ը��������ֵ��Ϊ�ֿ�ı�׼
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
