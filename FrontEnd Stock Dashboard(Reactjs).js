import React, { useState, useEffect } from 'react';
import axios from 'axios';

function StockDashboard() {
    const [stocks, setStocks] = useState([]);

    useEffect(() => {
        axios.get('/api/stocks')
            .then(response => setStocks(response.data))
            .catch(error => console.error('Error fetching stocks:', error));
    }, []);

    return (
        <div>
            <h2>Stock Dashboard</h2>
            <table>
                <thead>
                    <tr>
                        <th>Symbol</th>
                        <th>Company Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {stocks.map(stock => (
                        <tr key={stock.symbol}>
                            <td>{stock.symbol}</td>
                            <td>{stock.companyName}</td>
                            <td>{stock.currentPrice}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default StockDashboard;
