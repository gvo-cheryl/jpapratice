package practice;


import javax.persistence.*;

@Entity
public class Image {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Image(){

    }

    public Image(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
