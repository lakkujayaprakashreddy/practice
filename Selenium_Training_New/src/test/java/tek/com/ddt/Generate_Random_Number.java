package tek.com.ddt;

import java.util.Random;

public class Generate_Random_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		int random_Num=random.nextInt(1000);
		System.out.println(random_Num);
	}

}
