package fr.adriencaubel.hotel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Setter
@Getter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    public RoomType roomType;
    public LocalDate fromDate;
    public LocalDate toDate;
    public int quantity;
    public BigDecimal amount;
    public String status;
    public String nom;
    public String prenom;
    public String email;

    @OneToMany(mappedBy = "booking",
            cascade = CascadeType.ALL)
    private List<BookingOption> options = new ArrayList<>();

    public Booking() {
    }

    public void setOptions(List<BookingOption> options) {
        this.options = options;
    }

    public List<BookingOption> getOptions() {
        return options;
    }
}
