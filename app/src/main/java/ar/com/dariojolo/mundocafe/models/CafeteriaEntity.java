package ar.com.dariojolo.mundocafe.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "cafeterias")
public class CafeteriaEntity {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String name, address, neighborhood;
    public int image;
    public float rating;
//    public List<CafeteriaMessageEntity>messages;
    public boolean favorita;

    public CafeteriaEntity(Long id, String name, String address, String neighborhood, int image, float rating, boolean favorita) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.image = image;
        this.rating = rating;
        this.favorita = favorita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }
}
