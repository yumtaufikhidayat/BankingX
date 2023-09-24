package com.taufik.bankingx.di

import android.content.Context
import androidx.room.Room
import com.taufik.bankingx.data.local.BankingXDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext mContext: Context
    ) = Room.databaseBuilder(
        context = mContext,
        klass = BankingXDatabase::class.java,
        name = "BankingX.db"
    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideDao(database: BankingXDatabase) = database.getBankingXDao()
}