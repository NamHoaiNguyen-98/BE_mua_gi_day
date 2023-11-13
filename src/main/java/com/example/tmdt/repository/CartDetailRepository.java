package com.example.tmdt.repository;

import com.example.tmdt.model.buyPrd.Cart;
import com.example.tmdt.model.buyPrd.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    @Query(value = "SELECT * FROM cart_detail WHERE cart_id = :idCart AND product_id = :idProduct", nativeQuery = true)
    Optional<CartDetail> findCartDetailByCartAndProduct(@Param("idCart") Long idCart,
                                                       @Param("idProduct") Long idProduct);

    @Query(value = "SELECT * FROM cart_detail cd JOIN cart c ON cd.cart_id = c.id WHERE c.account_id = :idAccount", nativeQuery = true)
    List<CartDetail> showCart(@Param("idAccount") Long idAccount);

//    @Query(value = "SELECT * FROM cart WHERE account_id = :idAccount", nativeQuery = true)
//    Optional<Cart> findCartByIdAccount(@Param("idAccount") Long idAccount);

    @Query(value = "select * from cart_detail\n" +
            "inner join product on cart_detail.product_id = product.id\n" +
            "inner join cart on cart_detail.product_id = product.id where product.shop_id = :idShop and cart.confirm = :confirm ;\n" +
            ";", nativeQuery = true)
    List<CartDetail> displayCartOfShop(@Param("idShop") Long idShop ,@Param("confirm") String confirm);

}
