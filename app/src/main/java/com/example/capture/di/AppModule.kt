package com.example.capture.di

import android.app.Application
import androidx.room.Room
import com.example.capture.grid_view.data.ImageDatabase
import com.example.capture.grid_view.data.ImageDatabase.Companion.migration_1_2
import com.example.capture.grid_view.data.ImageRepositoryImpl
import com.example.capture.grid_view.domain.AddImagesUsecase
import com.example.capture.grid_view.domain.DeleteImageUsecase
import com.example.capture.grid_view.domain.GetImagesUsecase
import com.example.capture.grid_view.domain.ImageRepository
import com.example.capture.grid_view.domain.ImageUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesCaptureDatabase(app: Application): ImageDatabase {
        return Room.databaseBuilder(
            app,
            ImageDatabase::class.java,
            ImageDatabase.DATABASE_NAME
        )
            .addMigrations(migration_1_2)
            .build()
    }

    @Provides
    @Singleton
    fun providesImageRepository(db: ImageDatabase): ImageRepository = ImageRepositoryImpl(db.imageDao)

    @Provides
    @Singleton
    fun providesImageUsecases(repository: ImageRepository): ImageUseCases = ImageUseCases(
        getImages = GetImagesUsecase(repository),
        deleteImage = DeleteImageUsecase(repository),
        insertImage = AddImagesUsecase(repository)
    )
}