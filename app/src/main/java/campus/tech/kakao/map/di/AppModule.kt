package campus.tech.kakao.map.di

import android.content.Context
import androidx.room.Room
import campus.tech.kakao.map.database.AppDatabase
import campus.tech.kakao.map.database.MapItemDao
import campus.tech.kakao.map.network.KakaoApiService
import campus.tech.kakao.map.network.RetrofitInstance
import campus.tech.kakao.map.repository.MapRepository
import campus.tech.kakao.map.repository.MapRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "map_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMapItemDao(db: AppDatabase): MapItemDao {
        return db.mapItemDao()
    }

    @Provides
    @Singleton
    fun provideKakaoApiService(): KakaoApiService {
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideMapRepository(
        mapItemDao: MapItemDao,
        apiService: KakaoApiService
    ): MapRepository {
        return MapRepositoryImpl(mapItemDao, apiService)
    }
}
