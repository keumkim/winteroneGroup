package winterschoolone;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Coupon_table")
public class Coupon {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String userId;
    private String menuId;
    private Integer qty;
    private Integer stampQty=0;
    private Integer couponQty=0;
    

    @PostPersist
    public void onPostPersist(){//쿠폰 발행
        Issued issued = new Issued();
        BeanUtils.copyProperties(this, issued);
        issued.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){//쿠폰 사용처리
        Used used = new Used();
        BeanUtils.copyProperties(this, used);
        used.publishAfterCommit();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getStampQty() {
        return stampQty;
    }

    public void setStampQty(Integer stampQty) {
        this.stampQty += stampQty;
    }

    public Integer getCouponQty() {
        return couponQty;
    }

    public void setCouponQty(Integer couponQty) {
        this.couponQty += couponQty;
    }

}
