package ObserverPattern.Observer;
import ObserverPattern.Observer.NotificationObserver;
import ObserverPattern.Observable.StockNotificationObservable;


public class EmailNotificationObserverImpl implements NotificationObserver{

    String emailId;
    StockNotificationObservable observable;

    public EmailNotificationObserverImpl (String emailId, StockNotificationObservable observable)
    {
        this.emailId = emailId;
        this.observable = observable;
    }

    public void update()
    {
        sendEmail(emailId, "product is back in stock!!!");
    }

    private void sendEmail(String emailId, String msg)
    {
        System.out.println(emailId + msg);

        //send mail functionality
    }
}