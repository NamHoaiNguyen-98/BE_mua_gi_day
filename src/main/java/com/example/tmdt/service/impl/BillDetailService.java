package com.example.tmdt.service.impl;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.dto.BillDetailDTO;
import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.mapper.BillDetailMapper;
import com.example.tmdt.mapper.BillMapper;
import com.example.tmdt.mapper.ProductMapper;
import com.example.tmdt.model.Product;
import com.example.tmdt.model.User;
import com.example.tmdt.model.buyPrd.Bill;
import com.example.tmdt.model.buyPrd.BillDetail;
import com.example.tmdt.model.buyPrd.CartDetail;
import com.example.tmdt.model.fkProduct.Shop;
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
    private ShopRepository shopRepository ;
    @Autowired
    private BillDetailMapper billDetailMapper ;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private UserRepository userRepository;


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
        List<CartDetail> cartDetails = new ArrayList<>();
        for (Long idCartDetail : idCartDetails) {
            Optional<CartDetail> cartDetailOptional = cartDetailRepository.findById(idCartDetail);
            if(cartDetailOptional.isPresent()) {
                CartDetail cartDetail = cartDetailOptional.get();
                cartDetails.add(cartDetail);
            }
        }
        for (CartDetail cartDetail : cartDetails) {
            createBillDetail(cartDetail);
        }
    }

    @Override
    public List<BillDetailDTO> showBillByAccountAndStatus(Long idAccount, String status) {
            List<BillDetail> billDetails = billDetailRepository.showBillByAccountAndStatus(idAccount, status);
            return billDetailMapper.toDto(billDetails);

    }

    @Override
    public void saveToBill(List<BillDetailDTO> billDetailDTOS, Long idAccount) {
        User user = userRepository.findUserByAccount_Id(idAccount);
        List<BillDetail> billDetails = billDetailMapper.toEntity(billDetailDTOS);
        for (BillDetail billDetail : billDetails) {
            Product product = billDetail.getProduct();
            product.setQuantity((int) (product.getQuantity() - billDetail.getQuantity()));
            cartDetailRepository.deleteCartDetailByProduct(product.getId());
            Bill bill = billDetail.getBill();
            if (bill.getAddress() == null) {
                bill.setName(user.getName());
                bill.setPhone(user.getPhone());
                bill.setAddress(user.getAddress());
                bill.setWards(user.getWards());
                bill.setDate(LocalDate.now());
                bill.setStatus("Chờ xác nhận");
                billRepository.save(bill);

            }
            billRepository.save(bill);
        }



    }

    @Override
    public List<BillDetailDTO> displayListBuy(Long idShop, String status) {
        return null;
    }

    @Override
    public List<BillDetailDTO> findByShop(Long idShop) {
        Shop shop = shopRepository.findShopByIdAccount(idShop);
        return billDetailMapper.toDto(billDetailRepository.findAllByProduct_Shop_Id(shop.getId()));
    }


    private void createBillDetail( CartDetail cartDetail) {
        try {


            Optional<Bill> billOptional = billRepository.findBillByIdAccount(cartDetail.getCart().getAccount().getId(), cartDetail.getProduct().getShop().getId());
            Bill bill;
            if (billOptional.isPresent() && billOptional.get().getStatus().equals("0")) {
                bill = billOptional.get();
            } else {
                bill = new Bill();
                bill.setAccount(cartDetail.getCart().getAccount());
                bill.setShop(cartDetail.getProduct().getShop());
                bill.setStatus("0");
                bill.setDate(LocalDate.now());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
