package com.qaprosoft.stockproject.service;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;

public class Service {
    
    private StockHasItemDAO stockHasItemDAO;

    public Service(StockHasItemDAO stockHasItemDAO) {
	super();
	this.stockHasItemDAO = stockHasItemDAO;
    }

    
}
   stockHasItemDAO.