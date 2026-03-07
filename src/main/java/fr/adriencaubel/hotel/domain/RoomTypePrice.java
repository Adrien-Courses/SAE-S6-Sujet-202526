package fr.adriencaubel.hotel.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "room_type_prices")
public class RoomTypePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal pricePerNight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    public RoomTypePrice() {
    }

    // getters & setters

    public Long getId() { return id; }

    public LocalDate getStartDate() { return startDate; }

    public LocalDate getEndDate() { return endDate; }

    public BigDecimal getPricePerNight() { return pricePerNight; }

    public RoomType getRoomType() { return roomType; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }

    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
}
