package ru.anb.chatapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anb.chatapp.data.ChatListRepositoryImpl
import ru.anb.chatapp.domain.ChatListRepository

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun provideListChatRepository(): ChatListRepository {
        return ChatListRepositoryImpl()
    }

}