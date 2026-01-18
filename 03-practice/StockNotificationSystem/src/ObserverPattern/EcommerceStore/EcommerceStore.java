package ObserverPattern.EcommerceStore;

import ObserverPattern.Observable.IphoneStockObservableImpl;
import ObserverPattern.Observable.StockNotificationObservable;
import ObserverPattern.Observer.EmailNotificationObserverImpl;
import ObserverPattern.Observer.MobileNotificationObserverImpl;
import ObserverPattern.Observer.NotificationObserver;

public class EcommerceStore {

    public static void main(String[] args) {

        StockNotificationObservable iphoneStockObservable =
                new IphoneStockObservableImpl();

        NotificationObserver observer1 =
                new EmailNotificationObserverImpl(
                        "ashuisavid@gmail.com",
                        iphoneStockObservable);

        NotificationObserver observer2 =
                new MobileNotificationObserverImpl(
                        "763536281",
                        iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);

        // stock becomes available
        iphoneStockObservable.setStockCount(20);
    }
}
