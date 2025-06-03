package Exercice1Hibernate;

import net.bytebuddy.asm.Advice;
import Exercice1Hibernate.dao.ProductDAO;
import Exercice1Hibernate.entity.Product;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

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






    }
}