import com.machinecoding.udaan.Request.ClaimDealRequest;
import com.machinecoding.udaan.service.DealService;
import org.junit.jupiter.api.Test;

public class TestCases {

    ClaimDealRequest claimDealRequest = new ClaimDealRequest(1, 1);
    DealService dealService = new DealService();


    @Test
    public void testClaimDeal(){
        assert(dealService.claimDeal(claimDealRequest).isSuccess());
    }
}
