package lpnu.service;

import lpnu.dto.OperatorDTO;
import lpnu.entity.Delivery;

import java.util.List;

public interface OperatorService {
    List<OperatorDTO> getAllOperator();
    OperatorDTO getOperatorById(long id);
    OperatorDTO saveOperator(OperatorDTO operatorDTO);
    OperatorDTO updateOperator(OperatorDTO operatorDTO);
    void deleteOperatorById(long id);

    Delivery createDelivery();

}
