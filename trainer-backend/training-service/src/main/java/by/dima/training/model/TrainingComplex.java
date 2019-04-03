package by.dima.training.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class TrainingComplex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_complex")
    private Set<Training> training;

    @ManyToMany(targetEntity = Muscle.class, fetch = FetchType.EAGER)
    @JoinTable(name = "tag_complex",
            joinColumns = {@JoinColumn(name = "id_complex")},
            inverseJoinColumns = {@JoinColumn(name = "id_tag")})
    private Set<Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingComplex that = (TrainingComplex) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(training, that.training) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
