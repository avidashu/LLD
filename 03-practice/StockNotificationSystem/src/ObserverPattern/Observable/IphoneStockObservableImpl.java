package ObserverPattern.Observable;


import ObserverPattern.Observer.NotificationObserver;// Must import the interface
import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements StockNotificationObservable {

    private List<NotificationObserver> observerList = new ArrayList<>();
    private int stockCount = 0;


    public void add(NotificationObserver observer) { // Name must match interface exactly
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationObserver observer) {
        observerList.remove(observer);
    }

    public void notifySubscribers()
    {
        for(NotificationObserver observer : observerList)
        {
            observer.update();
        }
    }

    public void setStockCount(int newStock)
    {
        if(stockCount == 0 && newStock > 0) {
            notifySubscribers();
        }

        stockCount = newStock;

    }
    public int getStockCount()
    {
        return stockCount;
    }


}
