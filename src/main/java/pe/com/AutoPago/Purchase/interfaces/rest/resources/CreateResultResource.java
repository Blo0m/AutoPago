package pe.com.AutoPago.Purchase.interfaces.rest.resources;

public record CreateResultResource(Long n, String graceType, Double interest, Double lifeInsurance, Double fee, Double amortization, Double balance, Double finalBalance,
                                   Double flow, Double riskInsurance, Double gps, Double ports, Double adminBills, Long creditId) {
}
