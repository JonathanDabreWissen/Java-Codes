interface Notification{
    void notifyUser(String notification);
}

class EmailNotification implements Notification{
    public void notifyUser(String notification){
        System.out.println("You have recieved an email: " + notification);
    }
}

class SMSNotification implements Notification{
    public void notifyUser(String notification){
        System.out.println("You have recieved a sms: " + notification);
    }
}

class PushNotification implements Notification{
    public void notifyUser(String notification){
        System.out.println("Here's a push notification: " + notification);
    }
}

abstract class NotificationFactory{
    abstract  Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new SMSNotification();
    }
}

class PushNotificationFactory{
    Notification createNotification(){
        return new PushNotification();
    }
}

public class FactoryMethodExampleNotificationSystem {
   public static void main(String[] args) {
        NotificationFactory nf1 = new EmailNotificationFactory();
        Notification e1 = nf1.createNotification();

        e1.notifyUser("Hello hi");
   }
}   
