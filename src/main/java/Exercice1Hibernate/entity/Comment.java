package Exercice1Hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private LocalDate com_date;
    private int note;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "idProduct")
    private Product product;

    @Override
    public String toString() {
        return "Comment{" +
                "idProduct=" +
                ", content='" + content + '\'' +
                ", com_date=" + com_date +
                ", note=" + note +
                ", product=" + product +
                '}';
    }
}
