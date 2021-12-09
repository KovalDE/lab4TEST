package lpnu.repository;

import lpnu.entity.Operator;
import lpnu.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperatorRepository {
    private List<Operator> operators = new ArrayList<>();
    private long id = 1;

    public List<Operator> getAllOperator() {
        return operators;
    }

    public Operator getOperatorId(long id) {
        return operators.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Operator with id {" + id + "} not found"));
    }

    public Operator saveOperator(Operator operator) {

        operator.setId(id++);
        operators.add(operator);

        return operator;
    }

    public Operator updateOperator(Operator operator) {
        Operator savedOperator = getOperatorId(operator.getId());

        savedOperator.setName(operator.getName());

        return savedOperator;
    }

    public void deleteOperatorId(long id) {
        operators = operators.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
