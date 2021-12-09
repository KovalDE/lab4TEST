package lpnu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperatorDTO {
    private Long id;
    private String name;
    private List<DeliveryDTO> deliveryDTO =new ArrayList<>();


    public OperatorDTO() {
    }

    public OperatorDTO(Long id, String name, List<DeliveryDTO> deliveryDTO) {
        this.id = id;
        this.name = name;
        this.deliveryDTO = deliveryDTO;
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

    public List<DeliveryDTO> getDeliveryDTO() {
        return deliveryDTO;
    }

    public void setDeliveryDTO(List<DeliveryDTO> deliveryDTO) {
        this.deliveryDTO = deliveryDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorDTO that = (OperatorDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(deliveryDTO, that.deliveryDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deliveryDTO);
    }

    @Override
    public String toString() {
        return "OperatorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliveryDTO=" + deliveryDTO +
                '}';
    }
}