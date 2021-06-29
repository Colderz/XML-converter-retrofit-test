package pakiet.arkadiuszzimny.retrofitxmltest;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitInstance {

    //SimpleXmlConverterFactory deprecated without replacement for Android. Deprecated doesn't mean non-functional.

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://feeds.finance.yahoo.com")
            .client(new OkHttpClient())
            .addConverterFactory(
                    SimpleXmlConverterFactory.createNonStrict(
                            new Persister(new AnnotationStrategy())
                    )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build();

    public static final NewsAPI yahooFinanceService = retrofit.create(NewsAPI.class);

}
