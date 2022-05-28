package app.core.controllers;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemServiceException;
import app.core.exceptions.CouponSystemServiceExceptionBadRequest;
import app.core.exceptions.CouponSystemServiceExceptionNotFound;
import app.core.services.CompanyService;
import app.core.services.CustomerService;
import app.core.token.TokensManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController extends ClientController{

    @Autowired
    private TokensManager tokensManager;
    @Autowired
    private CustomerService customerService;


    @Override
    @PostMapping
    public String login(String email, String password) {

        return null;
    }

    public CustomerController() {
    }

    @PostMapping("/purchase-coupon")
    public void purchaseCoupon (@RequestBody Coupon coupon, @RequestHeader String token){
        try {
            this.customerService.purchaseCoupon(coupon);
        } catch (CouponSystemServiceExceptionNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (CouponSystemServiceExceptionBadRequest e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

//    @PutMapping("/update-coupon")
//    public void updateCoupon (@RequestBody Coupon coupon,@RequestHeader String token){
//        try {
//            this.companyService.updateCoupon(coupon);
//
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.MULTI_STATUS, e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/delete-coupon/{couponId}")
//    public void deleteCoupon (@PathVariable int couponId,@RequestHeader String token){
//        try {
//            this.companyService.deleteCoupon(couponId);
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        }
//    }
//
//
//
//    @GetMapping("/get-company-details")
//    public Company getOneCompany (@RequestHeader String token){
//        try {
//            return this.companyService.getCompanyDetails();
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
//
//
//    @GetMapping("/get-company-coupons")
//    public List<Coupon> getCompanyCoupons(@RequestHeader String token) {
//        try {
//            return companyService.getCompanyCoupons();
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
//
//    @GetMapping("/get-company-coupons-category")
//    public List<Coupon> getCompanyCoupons(@RequestBody Coupon.Category category, @RequestHeader String token) {
//        try {
//            return companyService.getCompanyCoupons(category);
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
//
//    @GetMapping("/get-company-coupons-max-price")
//    public List<Coupon> getCompanyCoupons(@RequestBody double maxPrice, @RequestHeader String token) {
//        try {
//            return companyService.getCompanyCoupons(maxPrice);
//        } catch (CouponSystemServiceException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
//


}
