package pakiet.arkadiuszzimny.retrofitxmltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;


public class MainActivity extends AppCompatActivity {

    interface ApiService {
        @GET("rss/2.0/headline?s=^GSPC")
        Call<ResponseBody> getItems();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://feeds.finance.yahoo.com")
                .client(new OkHttpClient())
                .addConverterFactory(
                        SimpleXmlConverterFactory.createNonStrict(
                                new Persister(new AnnotationStrategy())
                        )
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        ApiService yahooFinanceService = retrofit.create(ApiService.class);

        try {
            Response<ResponseBody> response = yahooFinanceService.getItems().execute();
            System.out.println("Request done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Call<ItemContainer> response = RetrofitInstance.yahooFinanceService.getItems();

        //response.enqueue(new Callback<ItemContainer>() {
        //    @Override
        //    public void onResponse(Call<ItemContainer> call, Response<ItemContainer> response) {
        //        ItemContainer items = response.body();
        //        System.out.println(items);
        //    }
//
        //    @Override
        //    public void onFailure(Call<ItemContainer> call, Throwable t) {
        //        System.out.println("BŁĄD! "+t.getCause());
        //    }
        //});



    }
}