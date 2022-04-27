package day0428;

// ***이진탐색/이분탐색(Binary Search) 알고리즘***
// #이진 탐색이란? 데이터가 정렬되어있는 배열에서 특정한 값을 찾아내는 알고리즘.
// #시간 복잡도? O(logN)
public class BinarySearchTest {

	public static void main(String[] args) {
		
		int[] arr = {17, 28, 43, 67, 88, 92, 100};
		
		System.out.println(binarySearch1(arr, 43));
		System.out.println(binarySearch2(arr, 43, 0, arr.length-1));
	}
	
	// 1. 반복문을 이용한 방법
	public static int binarySearch1(int arr[], int target) {
		
		int low = 0;
		int high = arr.length-1;
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;		// 배열의 중간에 있는 임의의 값을 선택
			
			if(arr[mid] == target) {	// 찾고자 하는 값과 비교
				return mid;				// 해당 값을 찾으면 리턴.
			}
			else if(arr[mid] > target) {	// target이 중간값보다 작으면 중간값을 기준으로
				high = mid - 1;				// 좌측의 데이터들을 대상으로 다시 탐색
			}
			else {				// target이 중간값보다 크면 배열의 우측을 대상으로 다시 탐색
				low = mid + 1;
			}
		}
		return -1;
	}

	// 2. 재귀함수를 이용한 방법
	public static int binarySearch2(int arr[], int target, int low, int high) {
		
		if(low>high) {
			return -1;
		}
		
		int mid = (low + high) / 2;
		if(arr[mid] == target) {
			return mid;
		} 
		else if(arr[mid] > target) {
			return binarySearch2(arr, target, low, mid-1);
		}
		else {
			return binarySearch2(arr, target, mid+1, high);
		}
	}
}
