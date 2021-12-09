package lpnu.service.impl;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.dto.DrinksDTO;
import lpnu.dto.OrderDTO;
import lpnu.dto.PizzaDTO;
import lpnu.entity.Order;
import lpnu.mapper.OrderToOrderDTOMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderToOrderDTOMapper orderMapper;

    //@Value("${limit}")
    private int limit;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderToOrderDTOMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(final long id) {
        return orderMapper.toDTO(orderRepository.getOrdersId(id));
    }

    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {
        final Order order = orderMapper.toEntity(orderDTO);
        order.setTotalPrice(getTotalPrice(orderDTO));
        orderRepository.saveOrder(order);

        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {

        final Order order = orderMapper.toEntity(orderDTO);

        return orderMapper.toDTO(orderRepository.updateOrder(order));
    }

    @Override
    public void deleteOrderById(final long id) {
        orderRepository.deleteOrderId(id);
    }

    @Override
    public Double getTotalPrice(OrderDTO orderDTO) {
        double totalPrice = 0.;
        totalPrice += orderDTO.getPizzasDTO().stream().mapToDouble(PizzaDTO::getTotalPrice).sum();
        totalPrice += orderDTO.getDrinksDTO().stream().mapToDouble(DrinksDTO::getPrice).sum();

        return totalPrice;
    }
}
