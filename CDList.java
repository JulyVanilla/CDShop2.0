import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

class CDList {
	int amount;
	CD[] list;
	BufferedWriter bw;
	Random ra = new Random();
	
	public CDList(int n, BufferedWriter b) {
		amount = n;
		list = new CD[n];
		for (int i = 0; i < n; i++) {
			list[i] = new CD();
		}
		bw = b;
	}
	
	synchronized boolean rentCD(int serial) throws IOException {
		if (1 == list[serial].inventory) {
			list[serial].inventory = 0;
			GregorianCalendar gc = new GregorianCalendar();
			synchronized (bw) {
				bw.write(gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + ":" +  gc.get(Calendar.SECOND) + "    ");
				bw.write("\t" + "Rent    " + "\t" + (serial+1) + '\n');
			}
			return true;
		}
		return false;
	}
	
	synchronized boolean backCD(int serial) throws IOException {
		if (0 == list[serial].inventory) {
			list[serial].inventory = 1;
			GregorianCalendar gc = new GregorianCalendar();
			synchronized (bw) {
				bw.write(gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + ":" +  gc.get(Calendar.SECOND) + "    ");
				bw.write("\t" + "Back    " + "\t" + (serial+1) + '\n');
			}
			return true;
		}
		return false;
	}
	
	synchronized boolean sellCD(int serial, int n) throws IOException {
		if (list[serial].inventory >= n) {
			list[serial].inventory -= n;
			GregorianCalendar gc = new GregorianCalendar();
			synchronized (bw) {
				bw.write(gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + ":" +  gc.get(Calendar.SECOND) + "    ");
				bw.write("\t" + "Sell    " + "\t" + (serial+1) + "   " + "\t" + n + '\n');
			}
			return true;
		}
		return false;
	}
	
	synchronized boolean stockCD() throws IOException {
		for (int i = 0; i < amount; i++) {
			list[i].inventory = 10;
		}
		GregorianCalendar gc = new GregorianCalendar();
		synchronized (bw) {
			bw.write(gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + ":" +  gc.get(Calendar.SECOND) + "    ");
			bw.write("\t" + "Stock   " + '\n');
		}
		return true;
	}
	
}
