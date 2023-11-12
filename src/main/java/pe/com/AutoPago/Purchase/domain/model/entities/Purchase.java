package pe.com.AutoPago.Purchase.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private Long salePrice;

    @Getter
    private Long initialPercentage;

    @Getter
    private Long interestRate;

    @Getter
    private String rateType;

    @Getter
    private Long paymentsNumber;

    @Getter
    private Long notarialCost;

    @Getter
    private Long registrationCost;

    @Getter
    private Long gps;

    @Getter
    private Long portage;

    @Getter
    private Long administrationCost;

    @Getter
    private Long creditLifeInsurancePercentage;

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
