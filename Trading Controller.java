import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trade")
public class TradingController {

    @Autowired
    private TradingService tradingService;

    @PostMapping("/buy")
    public ResponseEntity<String> buyStock(
            @RequestParam Long userId,
            @RequestParam String stockSymbol,
            @RequestParam int quantity) {
        tradingService.buyStock(userId, stockSymbol, quantity);
        return ResponseEntity.ok("Stock bought successfully");
    }

    // Sell stock API...
}
