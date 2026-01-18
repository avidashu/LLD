
package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationObserver;

public interface StockNotificationObservable {

    public void add (NotificationObserver observer );

    public void remove(NotificationObserver observer) ;

    public void notifySubscribers();

    public void setStockCount(int stockAdded);

    public int getStockCount();

}
