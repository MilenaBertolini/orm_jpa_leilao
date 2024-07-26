package orm.leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "id" })
@EqualsAndHashCode(of = { "participante" })
@Entity
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Double valor;

    // Muitos lances podem ser feitos por um participante
    @ManyToOne
    private Participante participante;

    public Lance(Double valor, Participante participante){
        this.valor = valor;
        this.participante = participante;
    }
    
}
