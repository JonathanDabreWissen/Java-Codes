
interface Notification{
    void send(String message);
}

class EmailService implements Notification{
    public void send (String message){
        System.out.println("Mail sent: " + message);
    }
}

class SMSService implements Notification {

    public void send(String message){
        System.out.println("SMS sent: " + message);
    }
}

class NotificationService  {
    private final Notification notification;
    
    public NotificationService(Notification notification){
        this.notification = notification;
    }

    public void sendNotification(String message){
        notification.send(message);
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        EmailService e1 = new EmailService();

        NotificationService ns1 = new NotificationService(e1);
        ns1.sendNotification("Hello I follow dependency inversion principle");


        NotificationService ns2 = new NotificationService(new SMSService());
        ns2.sendNotification("This is direct");


    }
}

/*
The Dependency Inversion Principle (DIP) states:

"High-level modules should not depend on low-level modules. Both should depend on abstractions."
"Abstractions should not depend on details. Details should depend on abstractions."

In simple terms, it means that:

High-level components (business logic) should not be tightly coupled to low-level components (implementation details).
Both should rely on interfaces or abstract classes to reduce coupling and improve flexibility and scalability.

*/