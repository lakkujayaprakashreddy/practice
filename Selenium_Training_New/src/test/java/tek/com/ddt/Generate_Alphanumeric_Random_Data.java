package tek.com.ddt;

public class Generate_Alphanumeric_Random_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		int n=4;
		StringBuilder builder=new StringBuilder(n);
		for(int i=0;i<n;i++) {
			int index=(int)(alphaNumericString.length()*Math.random());
			builder.append(alphaNumericString.charAt(index));
		}
		System.out.println(builder);
	}

}
