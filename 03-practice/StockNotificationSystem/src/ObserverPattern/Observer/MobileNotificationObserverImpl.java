package ObserverPattern.Observer;

import ObserverPattern.Observable.StockNotificationObservable;

public class MobileNotificationObserverImpl implements NotificationObserver {

    private String phNumber;
    private StockNotificationObservable observable;

    public MobileNotificationObserverImpl(String phNumber,
                                          StockNotificationObservable observable) {
        this.phNumber = phNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendSms(phNumber, "Stock is back again!!!");
    }

    private void sendSms(String phNumber, String message) {
        System.out.println("SMS sent to " + phNumber + " : " + message);
    }
}
