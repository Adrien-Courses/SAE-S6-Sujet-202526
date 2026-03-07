package fr.adriencaubel.hotel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int totalRooms;

    @OneToMany(mappedBy = "roomType",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<RoomTypePrice> prices = new ArrayList<>();

    public RoomType() {

    }
}
