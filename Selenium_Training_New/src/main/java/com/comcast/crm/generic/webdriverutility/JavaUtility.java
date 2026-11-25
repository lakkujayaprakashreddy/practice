package com.comcast.crm.generic.webdriverutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int random_Num=random.nextInt(100000);
		return random_Num;
	}
	
	public String getSystemDateYYYYMMDD() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
	}
	public String getRandomEmail() {
		String email="";
		for(int i=0;i<5;i++) {
			int num=(int) ("abcdefghijklmnopqrstuvwxyz0123456789".length()*Math.random());
			char ch="abcdefghijklmnopqrstuvwxyz0123456789".charAt(num);
			email+=ch;
		}
		return email+"@gmail.com";
	}
	public String getrandomContactNumber() {
		String mobileNo="99";
		for(int i=1;i<=8;i++) {
			int num=(int) ("0123456789".length()*Math.random());
			char ch="0123456789".charAt(num);
			mobileNo+=ch;
		}
		return mobileNo;
	}
	public String getrandomString(int n) {
		String result="";
		for(int i=0;i<n;i++) {
			int num=(int) ("abcdefghijklmnopqrstuvwxyz".length()*Math.random());
			result+="abcdefghijklmnopqrstuvwxyz".charAt(num);
		}
		return result;
	}
	public void appLogin() {
		
	}
	
	public void waitForPageLoad() {
		
	}
	public void switchToWindow() {
		
	}
	public void select(String text) {
		
	}
	public void select(int text) {
		
	}

	public void getSheet(int lastRow) {
		// TODO Auto-generated method stub
		
	}
}
