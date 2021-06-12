package Test.com.muthuAltimetrik;

public class arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1,5,3,9,4,4};
		int large=arr[0];
		int second=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			if(large<arr[i+1])
			{
				second=large;
				large=arr[i+1];
			}
			else if(second<arr[i+1]) {
		
				second=arr[i+1];
			}
		}
		
		System.out.println(large);
		System.out.println(second);

	}

}
