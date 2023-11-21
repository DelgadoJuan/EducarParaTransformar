package com.apiMobile.ApiMobileEducarParaTransformar.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioEntity titular;
    @CreationTimestamp
    private LocalDateTime fechaPago;
    private TipoPago tipoPago;
    private Mes mes;
    private double monto;

    public PagoEntity(Long id, UsuarioEntity titular, LocalDateTime fechaPago, Mes mes, double monto, TipoPago tipoPago) {
        this.id = id;
        this.titular = titular;
        this.fechaPago = fechaPago;
        this.mes = mes;
        this.monto = monto;
        this.tipoPago = tipoPago;
    }

    public PagoEntity(UsuarioEntity titular, double monto, Mes mes, TipoPago tipoPago) {
        this.titular = titular;
        this.monto = monto;
        this.mes = mes;
        this.tipoPago = tipoPago;
    }

    public PagoEntity() {
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getTitular() {
        return titular;
    }

    public void setTitular(UsuarioEntity titular) {
        this.titular = titular;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "PagoEntity{" +
                "id=" + id +
                ", titular=" + titular +
                ", fechaPago=" + fechaPago +
                ", tipoPago=" + tipoPago +
                ", mes=" + mes +
                ", monto=" + monto +
                '}';
    }
}
