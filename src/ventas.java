import java.io.*;
import java.util.*;

public class ventas {
    private int quantityOrdered;
    private double sales;
    private String productLine;
    private String customerName;
    private String city;

    public ventas(int quantityOrdered, double sales, String productLine, String customerName, String city) {
        this.quantityOrdered = quantityOrdered;
        this.sales = sales;
        this.productLine = productLine;
        this.customerName = customerName;
        this.city = city;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ventas{" +
                "quantityOrdered=" + quantityOrdered +
                ", sales=" + sales +
                ", productLine='" + productLine + '\'' +
                ", customerName='" + customerName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
