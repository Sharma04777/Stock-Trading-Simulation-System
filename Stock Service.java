import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    public Stock getStockData(String symbol) {
        String url = "https://api.example.com/stocks/" + symbol; //Replace with real api.
        return restTemplate.getForObject(url, Stock.class);
    }
}
