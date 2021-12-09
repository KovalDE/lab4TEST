package lpnu.service.impl;

import lpnu.dto.OperatorDTO;
import lpnu.entity.Delivery;
import lpnu.entity.Operator;
import lpnu.mapper.OperatorToOperatorDTOMapper;
import lpnu.repository.OperatorRepository;
import lpnu.service.OperatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;
    private final OperatorToOperatorDTOMapper operatorDTOMapper;

    public OperatorServiceImpl(OperatorRepository operatorRepository, OperatorToOperatorDTOMapper operatorDTOMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorDTOMapper = operatorDTOMapper;
    }

    @Override
    public List<OperatorDTO> getAllOperator() {
        return operatorRepository.getAllOperator().stream()
                .map(e -> operatorDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public OperatorDTO getOperatorById(long id) {
        return operatorDTOMapper.toDTO(operatorRepository.getOperatorId(id));
    }

    @Override
    public OperatorDTO saveOperator(OperatorDTO operatorDTO) {
        final Operator operator = operatorDTOMapper.toEntity(operatorDTO);
        operatorRepository.saveOperator(operator);
        return operatorDTO;    }

    @Override
    public OperatorDTO updateOperator(OperatorDTO operatorDTO) {
        final Operator operator = operatorDTOMapper.toEntity(operatorDTO);
        operatorRepository.updateOperator(operator);
        return operatorDTO;   }

    @Override
    public void deleteOperatorById(long id) {
        operatorRepository.deleteOperatorId(id);

    }

    @Override
    public Delivery createDelivery() {
        return null;
    }
}
