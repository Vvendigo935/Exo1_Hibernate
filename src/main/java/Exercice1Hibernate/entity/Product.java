package Exercice1Hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String reference;
    private LocalDate purchaseDate;
    private double price;
    private int stock;

@OneToMany(mappedBy = "product")
    private List<Picture>pictures;

@OneToMany(mappedBy = "product")
    private List<Comment>comments;

}
