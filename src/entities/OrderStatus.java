package entities;

public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIERY(3);

    private Integer code;

    OrderStatus(){
    }
    OrderStatus(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) { this.code = code; }
}
