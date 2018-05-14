import java.io.BufferedWriter;
import java.io.IOException;

class StockThread implements Runnable {
	CDShop cds;

	public StockThread(CDShop s) {
		cds = s;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				cds.sell.stockCD();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
