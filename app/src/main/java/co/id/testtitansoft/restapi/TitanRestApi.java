package co.id.testtitansoft.restapi;

import co.id.testtitansoft.object.BalanceResponse;
import co.id.testtitansoft.object.RequestBalance;
import co.id.testtitansoft.object.UserRank;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface TitanRestApi {

    @POST("api/Test/getbalance2/{id}")
    Observable<BalanceResponse> getUserBalance2(@Path("id") Integer id);

    @POST("api/Test/getbalance")
    Observable<BalanceResponse> getBalance(@Body RequestBalance requestBalance);

    @POST("api/Test/getuserrankings")
    Observable<List<UserRank>> getUserRank();

}
