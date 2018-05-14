import java.io.IOException;
import java.util.Random;

class RentThread implements Runnable {
	CDShop cds;
	
	public RentThread(CDShop s) {
		cds = s;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			long time = r.nextInt(200);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int serial = r.nextInt(10);
			try {
				if (cds.rent.rentCD(serial)) {
					long time2 = r.nextInt(100) + 200;
					try {
						Thread.sleep(time2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					cds.rent.backCD(serial);
				}
				else {
					int is_wait = r.nextInt(2);
					if (0 == is_wait) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						cds.rent.rentCD(serial);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
