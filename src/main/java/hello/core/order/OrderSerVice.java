package hello.core.order;

public interface OrderSerVice {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
