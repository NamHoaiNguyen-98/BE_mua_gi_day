package com.example.tmdt.service.impl;

import com.example.tmdt.dto.BillDetailDTO;
import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.model.Product;
import com.example.tmdt.model.buyPrd.Bill;
import com.example.tmdt.model.buyPrd.BillDetail;
import com.example.tmdt.model.buyPrd.CartDetail;
import com.example.tmdt.repository.*;
import com.example.tmdt.service.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillDetailService implements IBillDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillDetailRepository billDetailRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void save(BillDetailDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public BillDetailDTO findOne(Long id) {
        return null;
    }

    @Override
    public List<BillDetailDTO> findAll() {
        return null;
    }


    @Override
    public void addToBill(List<Long> idCartDetails) {
        Map<Long, List<CartDetail>> cartDetailsByShop = groupCartDetailByShop(idCartDetails);
        for (Map.Entry<Long, List<CartDetail>> entry : cartDetailsByShop.entrySet()) {
            List<CartDetail> cartDetails = entry.getValue();
            for (CartDetail cartDetail : cartDetails) {
                createBillDetail(cartDetail);
            }

        }
    }

    private Map<Long, List<CartDetail>> groupCartDetailByShop(List<Long> idCartDetails) {
        Map<Long, List<CartDetail>> cartDetailsByShop = new HashMap<>();
        for (Long idCartDetail : idCartDetails) {
            Optional<CartDetail> cartDetailOptional = cartDetailRepository.findById(idCartDetail);
            if (cartDetailOptional.isPresent()) {
                CartDetail cartDetail = cartDetailOptional.get();
                Long idShop = cartDetail.getProduct().getShop().getId();
                List<CartDetail> cartDetails = cartDetailsByShop.get(idShop);
                cartDetails.add(cartDetail);
            }
        }
        return cartDetailsByShop;
    }



    private void createBillDetail( CartDetail cartDetail) {
        Optional<Bill> billOptional = billRepository.findBillByIdAccount(cartDetail.getCart().getAccount().getId(), cartDetail.getProduct().getShop().getId());
        System.out.println(cartDetail.getCart().getAccount().getId());
        Bill bill;
        if (billOptional.isPresent()) {
            bill = billOptional.get();
        } else {
            bill = new Bill();
            bill.setAccount(cartDetail.getCart().getAccount());
            bill.setShop(cartDetail.getProduct().getShop());
            billRepository.save(bill);
        }
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(bill);
        billDetail.setProduct(cartDetail.getProduct());
        billDetail.setQuantity(cartDetail.getQuantity());
        Double newPrice = cartDetail.getProduct().getPrice() - (cartDetail.getProduct().getPrice() * cartDetail.getProduct().getPromotion() / 100);
        billDetail.setPrice(newPrice);
        Double total = cartDetail.getQuantity() * newPrice;
        billDetail.setTotal(total);
        Double quantity = cartDetail.getQuantity();
        Product product = cartDetail.getProduct();
        if (quantity <= product.getQuantity()) {
            product.setQuantity((int) (product.getQuantity() - quantity));
            productRepository.save(product);
            billDetailRepository.save(billDetail);
        }
    }
}
