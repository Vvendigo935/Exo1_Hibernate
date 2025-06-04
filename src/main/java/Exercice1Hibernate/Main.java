package Exercice1Hibernate;


import Exercice1Hibernate.dao.ProductDAO;
import Exercice1Hibernate.entity.Product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);

        // exo 1

        Product product1 = Product.builder().brand("Brand1").reference("12za8e1aze").purchaseDate(LocalDate.now()).price(12.5).stock(200).build();
        Product product2 = Product.builder().brand("Brand1").reference("aze121azex").purchaseDate(LocalDate.now()).price(120.5).stock(20).build();
        Product product3 = Product.builder().brand("Brand3").reference("az87e74a1z").purchaseDate(LocalDate.now()).price(2.5).stock(500).build();
        Product product4 = Product.builder().brand("Brand4").reference("aze5445aez").purchaseDate(LocalDate.now()).price(18).stock(20).build();
        Product product5 = Product.builder().brand("Brand2").reference("hbfg1h741e").purchaseDate(LocalDate.now()).price(3).stock(1000).build();

//        List<Product> products = List.of(product1,product2,product3,product4,product5);
//
//        for(Product p : products){
//            productDAO.save(p);
//        }
//

        // exo 2 et+

//        Product productShow = productDAO.get(2);
//        System.out.println("Product id : 2");
//        System.out.println(productShow);
//
//        System.out.println("delete :");
//        System.out.println(productDAO.delete(3));
//
//        Product productEdit = productDAO.get(1);
//
//        System.out.println("product Befor Edit :");
//        System.out.println(productEdit);
//
//        productEdit.setReference("4a6f1ds21sq32f1sq");
//        productEdit.setPurchaseDate(LocalDate.now());
//
//        productDAO.save(productEdit);
//
//        System.out.println("product after Edit :");
//        System.out.println(productEdit);


        // Exo 3 partie 1

 //       searchBtw2Date();
  //      searchWithPrice();

        // Exo 3 partie 2

  //      productDAO.getAllStockValue("Brand1");
//    System.out.println(productDAO.getAllBrandValue("Brand1"));
        System.out.println(productDAO.getAvgPrice());


    }

    private static void searchBtw2Date(){
        Scanner scanner = new Scanner(System.in);
        int startYear, startMonth, startDay, endYear, endMonth,endDay;
        ProductDAO productDAO = new ProductDAO();
        //     productDAO.getAllProductBetween2Date(LocalDate.of(1999,10,10),LocalDate.of(2025,06,02));
        //    System.out.println(productDAO.getAllProductBetween2Date(LocalDate.of(1999,10,10),LocalDate.of(2025,06,04)));  ici c'est... pas Paris mais mon test

        System.out.println("Type 2 date for your research");
        System.out.println("Type the start year please : ");
        startYear = scanner.nextInt();
        System.out.println("Type the start Month please : ");
        startMonth  = scanner.nextInt();
        System.out.println("Type the start Day please : ");
        startDay = scanner.nextInt();

        System.out.println("Type the end Year please : ");
        endYear = scanner.nextInt();
        System.out.println("Type the end Month please : ");
        endMonth = scanner.nextInt();
        System.out.println("Type the end Day please : ");
        endDay = scanner.nextInt();

        System.out.println("Result of your research : ");
        System.out.println(productDAO.getAllProductBetween2Date(LocalDate.of(startYear,startMonth,startDay),LocalDate.of(endYear,endMonth,endDay)));

    }

private static void searchWithPrice(){
    Scanner scanner = new Scanner(System.in);
    int stockSearch;
    ProductDAO productDAO = new ProductDAO();
    System.out.println("Search articles that the product have a stock reserve under :...");
        stockSearch = scanner.nextInt();
    System.out.println(productDAO.getAllProductUnderTheStock(stockSearch));
    }


}