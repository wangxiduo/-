package read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class print {
	public static void main(String[] args) {
		//printchaset();
		readchaset();
	}
	public static void printdemo() {
		PrintWriter bw = null;
		try {
			bw = new PrintWriter("a.txt");
			bw.println("hello");
		} catch (IOException e) {

		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
	public static void printchaset() {
		OutputStreamWriter ow = null;
		try {
			ow = new OutputStreamWriter(new FileOutputStream("b.txt"), "utf-8");
			ow.write("中国");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (ow != null) {
				try {
					ow.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readchaset() {
		InputStreamReader ow = null;
		try {
			ow = new InputStreamReader(new FileInputStream("b.txt"), "utf-8");
			char[] chs = new char[1024];
			int len = ow.read(chs);
			System.out.println(new String(chs,0,len));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (ow != null) {
				try {
					ow.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
