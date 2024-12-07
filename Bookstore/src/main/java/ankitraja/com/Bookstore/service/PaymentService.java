package ankitraja.com.Bookstore.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    public String createPaymentMethod(BigDecimal amount) throws StripeException {
        // Set your secret API key here
        Stripe.apiKey = "your_secret_api_key";

        // Prepare the parameters for the PaymentIntent
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount.multiply(new BigDecimal(100)).longValue()); // Amount in cents
        params.put("currency", "usd");

        // Create a PaymentIntent
        PaymentIntent intent = PaymentIntent.create(params);

        // Return the client secret for frontend integration
        return intent.getClientSecret();
    }
}
