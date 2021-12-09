package lpnu.mapper;

import lpnu.dto.OperatorDTO;
import lpnu.entity.Operator;
import org.springframework.stereotype.Component;

@Component
public class OperatorToOperatorDTOMapper {

    DeliveryListMapper deliveryListMapper;

    public OperatorToOperatorDTOMapper(DeliveryListMapper deliveryListMapper) {
        this.deliveryListMapper = deliveryListMapper;
    }

    public Operator toEntity(OperatorDTO operatorDTO){
        Operator operator = new Operator();

       operator.setId(operatorDTO.getId());
       operator.setName(operatorDTO.getName());
       operator.setDelivery(deliveryListMapper.toEntity(operatorDTO.getDeliveryDTO()));

        return operator;
    }

    public OperatorDTO toDTO(Operator operator){
        OperatorDTO operatorDTO = new OperatorDTO();

        operatorDTO.setId(operator.getId());
        operatorDTO.setName(operator.getName());
        operatorDTO.setDeliveryDTO(deliveryListMapper.toDTO(operator.getDelivery()));

        return operatorDTO;
    }
}
