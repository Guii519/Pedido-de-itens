package aplication;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Order order = new Order();

        System.out.println("Enter cliente data: ");

        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();
        Date dataDeNascimento;
        dataDeNascimento = sdf.parse(birthDate);

        Client client = new Client(name, email, dataDeNascimento);

        System.out.println("Enter order data: ");
        System.out.println("Status: ");
        String status00 = sc.nextLine();
        OrderStatus status01;
        try {
            status01 = OrderStatus.valueOf(status00.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Status inválido.");
            sc.close();
            return;
        }

        System.out.print("How many items to this order? ");
        int quantidadeItem = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < quantidadeItem; i++){
            System.out.println("enter #" + (i + 1) + " item data:");

            System.out.print("Product name: ");
            String nomeDoProduto = sc.nextLine();
            System.out.print("Product price: ");
            double precoDoProduto = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            Product product = new Product(nomeDoProduto, precoDoProduto);
            OrderItem item = new OrderItem(quantidade, precoDoProduto, product);
            order.addItem(item);
        }

        System.out.println("ORDER SUMMARY: ");

        System.out.print("Order moment: ");
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);
        System.out.println(dataHoraFormatada);

        System.out.print("Order status: ");
        System.out.println(status01);

        System.out.print("Client: ");
        System.out.println(client);

        System.out.println("Order items: ");
        for(OrderItem item : order.getItem()){
            System.out.println(item.getProduct().getName() +
                    "$" + item.getPrice() +
                    "Quantity: " + item.getQuantity() +
                    ", subtotal: " + "$" + item.subTotal());
        }
        System.out.print("Total price: " + "$" + order.total());

        sc.close();
    }
}
