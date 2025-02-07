import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

public class FlightExampleCompletableFuture {
    public static CompletableFuture<String> fetchFlightDetails(){
        return CompletableFuture.supplyAsync(()->{
            delay(2);
            return "Flight Details: Mumbai->New York | Price: Rs. 50,000";
            
        });
    }

    public static CompletableFuture<String> processPayment(String flightDetails){
        return CompletableFuture.supplyAsync(()->{
            delay(3);
            return "Payment Successful for: " + flightDetails;
        });

    }


    public static CompletableFuture<Void> sendEmail(String paymentConfirmation){
        return CompletableFuture.runAsync(()->{
            delay(1);
            System.out.println("Email Sent: " + paymentConfirmation);
        });
    }

    private static void delay(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        System.out.println("Booking Started...");

        CompletableFuture<Void> bookingProcess = fetchFlightDetails()
            .thenCompose(FlightExampleCompletableFuture::processPayment)
            .thenApply(payment -> "🎉 Booking Confirmed!\n" + payment)
            .thenCompose(confirmation -> sendEmail(confirmation)) // Ensures email is sent
            .thenRun(() -> System.out.println("✅ Booking Process Completed")); // Final completion message

        bookingProcess.join(); //wait for completion
        System.out.println("Booking Process Completed");
    }
}
