package pe.com.AutoPago.Purchase.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Positive
    @Getter
    private Long salePrice;

    @Positive
    @Getter
    private Long initialPercentage;

    @Positive
    @Getter
    private Long interestRate;

    @Positive
    @Getter
    private String rateType;

    @Positive
    @Getter
    private Long paymentsNumber;

    @Positive
    @Getter
    private Long notarialCost;

    @Positive
    @Getter
    private Long registrationCost;

    @Positive
    @Getter
    private Long gps;

    @Positive
    @Getter
    private Long portage;

    @Positive
    @Getter
    private Long administrationCost;

    @Positive
    @Getter
    private Long creditLifeInsurancePercentage;

    @Positive
    @Getter
    private Long riskInsurancePercentage;

    public Purchase() {
    }

    public Purchase(Long salePrice, Long initialPercentage, Long interestRate, String rateType, Long paymentsNumber, Long notarialCost, Long registrationCost, Long gps, Long portage, Long administrationCost, Long creditLifeInsurancePercentage, Long riskInsurancePercentage) {
        this.salePrice = salePrice;
        this.initialPercentage = initialPercentage;
        this.interestRate = interestRate;
        this.rateType = rateType;
        this.paymentsNumber = paymentsNumber;
        this.notarialCost = notarialCost;
        this.registrationCost = registrationCost;
        this.gps = gps;
        this.portage = portage;
        this.administrationCost = administrationCost;
        this.creditLifeInsurancePercentage = creditLifeInsurancePercentage;
        this.riskInsurancePercentage = riskInsurancePercentage;
    }
}
