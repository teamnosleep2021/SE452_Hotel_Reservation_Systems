package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
// import java.util.List;
import lombok.Data;
// import lombok.ToString;

@Data
@Entity
@Table(name = "ROOM_TYPES")
public class RoomTypes {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "ROOM_TYPE_STR")
    @NotBlank(message = "room type desc cannot be blank")
    private String type;

    // @OneToMany(mappedBy = "roomTypes")
    // @ToString.Exclude
    // private List<Rooms> rooms;
}
