import java.util.*;
import java.io.*;

public class Test {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String arg[]) throws IOException {
		BufferedWriter bw = null;
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\2.txt", true)));
		
		CDShop cds = new CDShop(bw);
		Thread st_thread = new Thread(new StockThread(cds));
		Thread se_thread1 = new Thread(new SellThread(cds));
		Thread se_thread2 = new Thread(new SellThread(cds));
		Thread se_thread3 = new Thread(new SellThread(cds));
		Thread rt_thread1 = new Thread(new RentThread(cds));
		Thread rt_thread2 = new Thread(new RentThread(cds));
		
		bw.write("start\n");
		
		st_thread.start();
		se_thread1.start();
		se_thread2.start();
		se_thread3.start();
		rt_thread1.start();
		rt_thread2.start();
		
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		st_thread.stop();
		se_thread1.stop();
		se_thread2.stop();
		se_thread3.stop();
		rt_thread1.stop();
		rt_thread2.stop();
		
		bw.write("end");
		bw.close();
		System.out.println("end");
		
		return;
	}
}
