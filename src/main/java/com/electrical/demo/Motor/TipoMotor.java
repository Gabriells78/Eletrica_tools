package com.electrical.demo.Motor;

public enum TipoMotor {

    TRIFASICO(1),
    MONOFASICO(2);

    private final int Bill_tipe;

    TipoMotor(Integer Bill_tipe) {this.Bill_tipe = Bill_tipe;}

    public Integer getBill_type(){return Bill_tipe;}

    @Override
    public String toString() {
        return super.toString();
    }
}
