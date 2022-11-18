package com.rbc.dowjoneschallenge.stock;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stock {

    private @Id
    @GeneratedValue Long id;

    @CsvBindByName
    private String quarter;
    @CsvBindByName
    private String stock;
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String open;
    @CsvBindByName
    private String high;
    @CsvBindByName
    private String low;
    @CsvBindByName
    private String close;
    @CsvBindByName
    private String volume;
    @CsvBindByName
    private String percent_change_price;
    @CsvBindByName
    private String percent_change_volume_over_last_wk;
    @CsvBindByName
    private String previous_weeks_volume;
    @CsvBindByName
    private String next_weeks_open;
    @CsvBindByName
    private String next_weeks_close;
    @CsvBindByName
    private String percent_change_next_weeks_price;
    @CsvBindByName
    private String days_to_next_dividend;
    @CsvBindByName
    private String percent_return_next_dividend;

    public Stock() {
    }

    public Stock(Long id, String quarter, String stock, String date, String open, String high, String low, String close, String volume, String percent_change_price, String percent_change_volume_over_last_wk, String previous_weeks_volume, String next_weeks_open, String next_weeks_close, String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend) {
        this.id = id;
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    public Stock(String stock) {
        this.stock = stock;
    }

    public static Stock from(String stock) {
        return new Stock(stock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPercent_change_price() {
        return percent_change_price;
    }

    public void setPercent_change_price(String percent_change_price) {
        this.percent_change_price = percent_change_price;
    }

    public String getPercent_change_volume_over_last_wk() {
        return percent_change_volume_over_last_wk;
    }

    public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }

    public String getPrevious_weeks_volume() {
        return previous_weeks_volume;
    }

    public void setPrevious_weeks_volume(String previous_weeks_volume) {
        this.previous_weeks_volume = previous_weeks_volume;
    }

    public String getNext_weeks_open() {
        return next_weeks_open;
    }

    public void setNext_weeks_open(String next_weeks_open) {
        this.next_weeks_open = next_weeks_open;
    }

    public String getNext_weeks_close() {
        return next_weeks_close;
    }

    public void setNext_weeks_close(String next_weeks_close) {
        this.next_weeks_close = next_weeks_close;
    }

    public String getPercent_change_next_weeks_price() {
        return percent_change_next_weeks_price;
    }

    public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }

    public String getDays_to_next_dividend() {
        return days_to_next_dividend;
    }

    public void setDays_to_next_dividend(String days_to_next_dividend) {
        this.days_to_next_dividend = days_to_next_dividend;
    }

    public String getPercent_return_next_dividend() {
        return percent_return_next_dividend;
    }

    public void setPercent_return_next_dividend(String percent_return_next_dividend) {
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock that = (Stock) o;
        return Objects.equals(id, that.id) && Objects.equals(quarter, that.quarter) && Objects.equals(stock, that.stock) && Objects.equals(date, that.date) && Objects.equals(open, that.open) && Objects.equals(high, that.high) && Objects.equals(low, that.low) && Objects.equals(close, that.close) && Objects.equals(volume, that.volume) && Objects.equals(percent_change_price, that.percent_change_price) && Objects.equals(percent_change_volume_over_last_wk, that.percent_change_volume_over_last_wk) && Objects.equals(previous_weeks_volume, that.previous_weeks_volume) && Objects.equals(next_weeks_open, that.next_weeks_open) && Objects.equals(next_weeks_close, that.next_weeks_close) && Objects.equals(percent_change_next_weeks_price, that.percent_change_next_weeks_price) && Objects.equals(days_to_next_dividend, that.days_to_next_dividend) && Objects.equals(percent_return_next_dividend, that.percent_return_next_dividend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quarter, stock, date, open, high, low, close, volume, percent_change_price, percent_change_volume_over_last_wk, previous_weeks_volume, next_weeks_open, next_weeks_close, percent_change_next_weeks_price, days_to_next_dividend, percent_return_next_dividend);
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "id=" + id +
                ", quarter='" + quarter + '\'' +
                ", stock='" + stock + '\'' +
                ", date='" + date + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                ", percent_change_price='" + percent_change_price + '\'' +
                ", percent_change_volume_over_last_wk='" + percent_change_volume_over_last_wk + '\'' +
                ", previous_weeks_volume='" + previous_weeks_volume + '\'' +
                ", next_weeks_open='" + next_weeks_open + '\'' +
                ", next_weeks_close='" + next_weeks_close + '\'' +
                ", percent_change_next_weeks_price='" + percent_change_next_weeks_price + '\'' +
                ", days_to_next_dividend='" + days_to_next_dividend + '\'' +
                ", percent_return_next_dividend='" + percent_return_next_dividend + '\'' +
                '}';
    }
}
