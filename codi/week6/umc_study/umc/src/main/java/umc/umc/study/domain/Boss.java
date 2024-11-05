package umc.umc.study.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer store_id;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Store> StoreList = new ArrayList<>();

}
