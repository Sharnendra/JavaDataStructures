package com.design.patterns.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StrategyDesignPattern {

	private static List<Stock> stockList = new ArrayList<>();
	public static List<Stock> getStockList() {
		return stockList;
	}

	public static void main(String[] args) {

		createStocks();
		StockFilter.filterStockData(getStockList(), (x)->x.getCountryCode().equals("US"))
		.stream().forEach(System.out::println);
	}
	
	private static Consumer<Stock> generateStockList=(Stock data)->{
		stockList.add(data);
	};
	
	private static void createStocks() {
		for(int i=0;i<=5;i++) {
			Stock stock=new Stock();
			stock.setAmount(500.00*7*(i==0?i==3?4:1:2));
			stock.setCountryCode(i%2==0?"US":"AMV");
			stock.setShare(i%2!=0?"Data":"Intranet");
			generateStockList.accept(stock);
			stock=null;
		}
	}
}

class Stock{
	private String share;
	private double Amount;
	private String countryCode;
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Stock [share=" + share + ", Amount=" + Amount + ", countryCode=" + countryCode + "]";
	}
}

class StockFilter{
	
	public static List<Stock> filterStockData(List<Stock> stock, Predicate<Stock> p){
		List<Stock> filterStockData =new ArrayList<Stock>();
		for (Stock temp : stock) {
			if(p.test(temp))filterStockData.add(temp);
		}
		return filterStockData;
	}
}