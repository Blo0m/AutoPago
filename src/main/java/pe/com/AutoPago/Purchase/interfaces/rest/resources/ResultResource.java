package pe.com.AutoPago.Purchase.interfaces.rest.resources;

public record ResultResource(Long id, Double interest, Double lifeInsurance, Double fee, Double amortization, Double balance, Double finalBalance,
                             Double flow, Double riskInsurance, Double gps, Double ports, Double adminBills, Long creditId) {
}
