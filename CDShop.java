import java.io.BufferedWriter;

class CDShop {
	CDList rent = null;
	CDList sell = null;
	BufferedWriter bw;
	
	public CDShop(BufferedWriter b) {
		bw = b;
		rent = new CDList(10, bw);
		sell = new CDList(10, bw);
		initRent(rent);
		initSell(sell);
	}

	void initRent(CDList rent) {
		for (int i = 0; i < rent.amount; i++) {
			rent.list[i].inventory = 1;
		}
	}
	
	void initSell(CDList sell) {
		for (int i = 0; i < sell.amount; i++) {
			sell.list[i].inventory = 10;
		}
	}
}
