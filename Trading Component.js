import React, { useState } from 'react';
import axios from 'axios';

function TradingComponent() {
    const [stockSymbol, setStockSymbol] = useState('');
    const [quantity, setQuantity] = useState(0);

    const handleBuy = () => {
        axios.post('/api/trade/buy', {
            userId: 1, // Example user ID
            stockSymbol,
            quantity,
        })
        .then(response=> alert(response.data))
        .catch(error => console.error('Error buying stock:', error));
    };

    return (
        <div>
            <h2>Trade Stocks</h2>
            <input type="text" placeholder="Stock Symbol" onChange={e => setStockSymbol(e.target.value)} />
            <input type="number" placeholder="Quantity" onChange={e => setQuantity(e.target.value)} />
            <button onClick={handleBuy}>Buy</button>
        </div>
    );
}

export default TradingComponent;
