package com.example.tmdt.service.impl;

import com.example.tmdt.dto.BillDetailDTO;
import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.mapper.BillDetailMapper;
import com.example.tmdt.mapper.BillMapper;
import com.example.tmdt.mapper.CartDetailMapper;
import com.example.tmdt.model.Product;
import com.example.tmdt.model.User;
import com.example.tmdt.model.Bill;
import com.example.tmdt.model.BillDetail;
import com.example.tmdt.model.CartDetail;
import com.example.tmdt.model.Shop;
import com.example.tmdt.repository.*;
import com.example.tmdt.service.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private BillDetailMapper billDetailMapper;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartDetailMapper cartDetailMapper;


    @Override
    public void save(BillDetailDTO dto) {

    }

    @Override
    public void delete(Long id) {
        Optional<BillDetail> billDetailOptional = billDetailRepository.findById(id);
        if (billDetailOptional.isPresent()) {
            BillDetail billDetail = billDetailOptional.get();
            billDetail.getBill().setStatus("Đơn hủy");
            billDetailRepository.save(billDetail);
        }


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
    public void addToBill(List<CartDetailDTO> cartDetailDTOS, Long idAccount) {
      List<CartDetail> cartDetails = cartDetailMapper.toEntity(cartDetailDTOS);
        for (CartDetail cartDetail : cartDetails) {
            createBillDetail(cartDetail, idAccount);
        }
    }

    @Override
    public List<BillDetailDTO> showBillByAccountAndStatus(Long idAccount, String status) {
        List<BillDetail> billDetails = billDetailRepository.showBillByAccountAndStatus(idAccount, status);
        return billDetailMapper.toDto(billDetails);

    }

//    @Override
//    public void saveToBill(List<BillDetailDTO> billDetailDTOS, Long idAccount) {
//
//        User user = userRepository.findUserByAccount_Id(idAccount);
//        List<BillDetail> billDetails = billDetailMapper.toEntity(billDetailDTOS);
//        for (BillDetail billDetail : billDetails) {
//            Product product = billDetail.getProduct();
//            product.setQuantity((int) (product.getQuantity() - billDetail.getQuantity()));
//            cartDetailRepository.deleteCartDetailByProduct(product.getId());
//            Bill bill = billDetail.getBill();
//            if (bill.getAddress() == null) {
//                bill.setName(user.getName());
//                bill.setPhone(user.getPhone());
//                bill.setAddress(user.getAddress());
//                bill.setWards(user.getWards());
//                bill.setDate(LocalDate.now());
//                bill.setStatus("Chờ xác nhận");
//                billRepository.save(bill);
//
//            }
//            billRepository.save(bill);
//        }
//
//
//    }

    @Override
    public List<BillDetailDTO> displayListBuy(Long idShop, String status) {
        return null;
    }

    @Override
    public List<BillDetailDTO> findByShop(Long idShop) {
        Shop shop = shopRepository.findShopByIdAccount(idShop);
        try {
            return billDetailMapper.toDto(billDetailRepository.findAllByProduct_Shop_Id(shop.getId()));
        }catch (Exception e) {
            return new ArrayList<>() ;
        }
    }

    @Override
    public List<CartDetailDTO> showProductUserSelect(List<Long> idCartDetails) {
        List<CartDetail> cartDetails = new ArrayList<>();
        for (Long idCartDetail : idCartDetails) {
            Optional<CartDetail> cartDetailOptional = cartDetailRepository.findById(idCartDetail);
            if (cartDetailOptional.isPresent()) {
                CartDetail cartDetail = cartDetailOptional.get();
                cartDetails.add(cartDetail);
            }
        }
        return cartDetailMapper.toDto(cartDetails);
    }




    private void createBillDetail(CartDetail cartDetail, Long idAccount) {
        User user = userRepository.findUserByAccount_Id(idAccount);
        Optional<Bill> billOptional = billRepository.findBillByIdAccount(cartDetail.getCart().getAccount().getId(), cartDetail.getProduct().getShop().getId());
        Bill bill;
        if (billOptional.isPresent() && billOptional.get().getStatus().equals("Chờ xác nhận")) {
            bill = billOptional.get();
        } else {
            bill = new Bill();
            bill.setAccount(cartDetail.getCart().getAccount());
            bill.setShop(cartDetail.getProduct().getShop());
            bill.setName(user.getName());
            bill.setPhone(user.getPhone());
            bill.setAddress(user.getAddress());
            bill.setWards(user.getWards());
            bill.setDate(LocalDate.now());
            bill.setStatus("Chờ xác nhận");
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
            productRepository.save(product);
            billDetailRepository.save(billDetail);
        }
        cartDetailRepository.deleteCartDetailByProduct(product.getId());

    }


}
