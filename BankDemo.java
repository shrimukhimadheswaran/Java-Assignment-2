
import salem.ICICIBank;
import erode.SBIBank;
import coimbatore.KVBBank;

public class BankDemo {
    public static void main(String[] args) {
        ICICIBank icici = new ICICIBank();
        SBIBank sbi = new SBIBank();
        KVBBank kvb = new KVBBank();

        icici.calculateInterest(7.5);
        sbi.calculateInterest(7.0);
        kvb.calculateInterest(7.25);
    }
}

