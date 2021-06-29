package pakiet.arkadiuszzimny.retrofitxmltest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsAPI {

    @GET("rss/2.0/headline?s=^GSPC")
    Call<ItemContainer> getItems();
}
