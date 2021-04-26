package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "room_types")
public class RoomTypes {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "type_str")
    @NotBlank(message = "room type desc cannot be blank")
    private String type;

    @OneToMany(mappedBy = "roomTypes")
    @ToString.Exclude
    private List<Rooms> rooms;
}
