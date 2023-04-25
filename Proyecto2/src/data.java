import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalInt;

public class data {

    String filePath = "src//sales_data.csv";
    ArrayList <ventas> ventas = readCsv(filePath);

    public ArrayList<ventas> readCsv( String filePath) {
        ArrayList<ventas> ventasList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int orderNumber = Integer.parseInt(data[0]);
                int quantityOrdered = Integer.parseInt(data[1]);
                double priceEach = Double.parseDouble(data[2]);
                int orderLineNumber = Integer.parseInt(data[3]);
                double sales = Double.parseDouble(data[4]);
                String orderDate = data[5];
                String status = data[6];
                int quarterId = Integer.parseInt(data[7]);
                int monthId = Integer.parseInt(data[8]);
                int yearId = Integer.parseInt(data[9]);
                String productLine = data[10];
                double msrp = Double.parseDouble(data[11]);
                String productCode = data[12];
                String customerName = data[13];
                String phone = data[14];
                String addressLine1 = data[15];
                String addressLine2 = data[16];
                String city = data[17];
                String state = data[18];
                String postalCode = data[19];
                String country = data[20];
                String territory = data[21];
                String contactLastName = data[22];
                String contactFirstName = data[23];
                String dealSize = data[24];

                ventas ventas = new ventas(orderNumber, quantityOrdered, priceEach, orderLineNumber, sales, orderDate,
                        status, quarterId, monthId, yearId, productLine, msrp,
                        productCode, customerName, phone, addressLine1, addressLine2,
                        city, state, postalCode, country, territory, contactLastName,
                        contactFirstName, dealSize);

                ventasList.add(ventas);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el CSV file: " + e.getMessage());
        }
        return ventasList;
    }

    public void imprimir(){
        ventas.forEach(ventas -> System.out.println(ventas.toString()));
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
