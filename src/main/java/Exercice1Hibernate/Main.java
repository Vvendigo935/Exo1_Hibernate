package Exercice1Hibernate;

import Exercice1Hibernate.dao.ProductDAO;
import Exercice1Hibernate.entity.Product;
import Exercice1Hibernate.util.SessionFactorySingleton;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductDAO productDAO = new ProductDAO(SessionFactorySingleton.getSession());

        Product product1 = Product.builder().brand("Peugeot").reference("206").buyDate(new Date(2000,11,11)).price(19999.99).stock(3).build();
        Product product2 = Product.builder().brand("Warhammer 40.000 : DARKTIDE").reference("FatShark.343").buyDate(new Date(2023,10,24)).price(44.99).stock(78).build();
        Product product3 = Product.builder().brand("JBL").reference("Yamal.8-2").buyDate(new Date(2025,05,19)).price(8.2).stock(10).build();
        Product product4 = Product.builder().brand("Ravager").reference("BeaupletHQ").buyDate(new Date(2025,01,01)).price(50).stock(141).build();
        Product product5 = Product.builder().brand("BIC").reference("Stylo.p60t8910").buyDate(new Date(2024,07,20)).price(4).stock(1452).build();

//        productDAO.save(product1);
//        productDAO.save(product2);
//        productDAO.save(product3);
//        productDAO.save(product4);
//        productDAO.save(product5);

//        System.out.println("Mettez l'id du produit recherché : ");
//        int idSearch = scanner.nextInt();
//        Product foundProduct = productDAO.get(scanner.nextInt());

//        Product foundProduct = productDAO.get(2);
//        foundProduct.setBuyDate(new Date (2020,10,10));
//        System.out.println(foundProduct.toString());

//        foundProduct = productDAO.get(3);
//        productDAO.delete(foundProduct);
//
//        foundProduct = productDAO.get(1);
//        foundProduct.setBrand("En fait c'est une Renault mdr");
//        productDAO.save(foundProduct);


        System.out.println(productDAO.getAllProduct());

        System.out.println(productDAO.getPriceOver100());

        System.out.println(productDAO.getDatebtw()); // j'ai eu des problèmes avec la date (le fameux an de grace 3924)



    }
}