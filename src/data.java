import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class data {

    String filePath = "src//sales_data.csv";
    List<ventas> ventas = readCsv(filePath);

    public List<ventas> readCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .skip(1)
                    .map(line -> {
                        String[] data = line.split(",");
                        int quantityOrdered = Integer.parseInt(data[1]);
                        double sales = Double.parseDouble(data[4]);
                        String productLine = data[10];
                        String customerName = data[13];
                        String city = data[17];
                        return new ventas(quantityOrdered, sales, productLine, customerName, city);
                    })
                    .collect(Collectors.toList());
        }catch (IOException e) {
                System.out.println("Error al leer el archivo CSV: " + e.getMessage());
                return Collections.emptyList();
            }
        }

    public void imprimir(){
        String city = "NYC";
        ventas.stream().filter(v -> v.getCity().equals(city)).forEach(ventas -> System.out.println(ventas.toString()));
    }

    public double TotalVentas() {
        String ciudad = "NYC";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad))
                .mapToDouble(v -> v.getSales())
                .sum();
    }

    public double TotalClasicos() {
        String ciudad = "NYC";
        String tipo = "Classic Cars";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad)).
                filter(v ->v.getProductLine().equals(tipo))
                .mapToInt(v -> v.getQuantityOrdered())
                .sum();
    }

    public double TotalVentasClasicos() {
        String ciudad = "NYC";
        String tipo = "Classic Cars";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad)).
                filter(v ->v.getProductLine().equals(tipo))
                .mapToDouble(v -> v.getSales())
                .sum();
    }

    public double TotalMotos() {
        String ciudad = "NYC";
        String tipo = "Motorcycles";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad)).
                filter(v ->v.getProductLine().equals(tipo))
                .mapToInt(v -> v.getQuantityOrdered())
                .sum();
    }

    public double TotalVentasMotos() {
        String ciudad = "NYC";
        String tipo = "Motorcycles";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad)).
                filter(v ->v.getProductLine().equals(tipo))
                .mapToDouble(v -> v.getSales())
                .sum();
    }

    public String MaxCompradorCarros(){
        String ciudad = "NYC";
        String tipo = "Classic Cars";
        return ventas.stream()
                .filter(v -> v.getCity().equals(ciudad))
                .filter(v -> v.getProductLine().equals(tipo))
                .max(Comparator.comparingInt(v -> v.getQuantityOrdered()))
                .map(v -> v.getCustomerName())
                .orElse("No customer found");
    }

    public String MaxComprador(){
        return ventas.stream()
                .max(Comparator.comparingInt(v -> v.getQuantityOrdered()))
                .map(v -> v.getCustomerName())
                .orElse("No customer found");
    }

    public String MinComprador(){
        return ventas.stream()
                .min(Comparator.comparingInt(v -> v.getQuantityOrdered()))
                .map(v -> v.getCustomerName())
                .orElse("No customer found");
    }

}
