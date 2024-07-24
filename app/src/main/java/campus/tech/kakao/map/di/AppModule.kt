package campus.tech.kakao.map.di

import android.content.Context
import androidx.room.Room
import campus.tech.kakao.map.dao.MapItemDao
import campus.tech.kakao.map.database.AppDatabase
import campus.tech.kakao.map.network.KakaoApiService
import campus.tech.kakao.map.network.RetrofitInstance
import campus.tech.kakao.map.repository.MapRepository
import campus.tech.kakao.map.repository.MapRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindMapRepository(
        mapRepositoryImpl: MapRepositoryImpl
    ): MapRepository

    companion object {

        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "map.db"
            ).build()
        }

        @Provides
        @Singleton
        fun provideMapItemDao(database: AppDatabase): MapItemDao {
            return database.mapItemDao()
        }

        @Provides
        @Singleton
        fun provideKakaoApiService(): KakaoApiService {
            return RetrofitInstance.api
        }
    }
}
