package sinergiarh.challenge.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

// Entidad de empleado, con sus respectivos atributos y relaciones

@NoArgsConstructor
@Getter @Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Employee tutor;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Task.class, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "employee_tasks",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    public Employee(String name, String surname, String phone, Gender gender, Employee tutor, List<Task> tasks) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.gender = gender;
        this.tutor = tutor;
        this.tasks = tasks;
    }

    public Employee(String name, String surname, Gender gender, List<Task> tasks) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.tasks = tasks;
    }
    
}
