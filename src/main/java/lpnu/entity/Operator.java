package lpnu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operator {

    private Long id;
    private String name;
    private List<Delivery> delivery= new ArrayList<>();

    public Operator() {
    }

    public Operator(Long id, String name, List<Delivery> delivery) {
        this.id = id;
        this.name = name;
        this.delivery = delivery;
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

    public List<Delivery> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(id, operator.id) && Objects.equals(name, operator.name) && Objects.equals(delivery, operator.delivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, delivery);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delivery=" + delivery +
                '}';
    }
}
