import java.io.IOException;
import java.util.Random;

class SellThread implements Runnable {
	CDShop cds;
	
	public SellThread(CDShop s) {
		cds = s;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			long time = r.nextInt(200);
			int num = r.nextInt(5) + 1;
			int serial = r.nextInt(10);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				if (cds.sell.sellCD(serial, num)) {
				}
				else {
					int is_wait = r.nextInt(2);
					if (1 == is_wait) {
						cds.sell.stockCD();
						cds.sell.sellCD(serial, num);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
