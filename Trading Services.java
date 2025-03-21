import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TradingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    public void buyStock(Long userId, String stockSymbol, int quantity) {
        User user = userRepository.findById(userId).orElseThrow();
        Stock stock = stockRepository.findBySymbol(stockSymbol).orElseThrow();
        BigDecimal totalCost = stock.getCurrentPrice().multiply(BigDecimal.valueOf(quantity));
        if (user.getBalance().compareTo(totalCost) >= 0) {
            user.setBalance(user.getBalance().subtract(totalCost));
            userRepository.save(user);

            Transaction transaction = new Transaction();
            transaction.setUserId(userId);
            transaction.setStockSymbol(stockSymbol);
            transaction.setTransactionType("BUY");
            transaction.setQuantity(quantity);
            transaction.setPrice(stock.getCurrentPrice());
            transactionRepository.save(transaction);

            //Portfolio logic
            //...
        }
        else{
            throw new RuntimeException("Insufficient funds");
        }
    }

    // Sell stock logic...
}
