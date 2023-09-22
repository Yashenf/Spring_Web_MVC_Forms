package com.example.demo.entity;

        import jakarta.persistence.*;
        import lombok.*;

        import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TechLead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String mobile;
    private String email;
    @OneToMany(mappedBy = "techLead")
    private List<Project> projects;
}
